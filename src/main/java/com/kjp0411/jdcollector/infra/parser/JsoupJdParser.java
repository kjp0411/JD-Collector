package com.kjp0411.jdcollector.infra.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kjp0411.jdcollector.domain.JobDescription;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JsoupJdParser implements JdParser {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public JobDescription parse(String url) {
        try {
            Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

            Element jsonLdScript = document
                .select("script[type=application/ld+json]")
                .stream()
                .filter(script -> script.html().contains("\"@type\":\"JobPosting\""))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("JobPosting JSON-LD not found"));

            JsonNode root = objectMapper.readTree(jsonLdScript.html());

            String title = root.path("title").asText();
            String content = root.path("description").asText();
            String company = root
                .path("hiringOrganization")
                .path("name")
                .asText();

            return new JobDescription(
                title,
                company,
                content,
                url
            );

        } catch (IOException e) {
            throw new RuntimeException("JD 파싱 실패: " + url, e);
        }
    }
}