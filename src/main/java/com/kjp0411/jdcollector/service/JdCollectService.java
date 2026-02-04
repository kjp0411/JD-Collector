package com.kjp0411.jdcollector.service;

import com.kjp0411.jdcollector.domain.JobDescription;
import com.kjp0411.jdcollector.infra.csv.CsvEscapeUtil;
import com.kjp0411.jdcollector.infra.parser.JdParser;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JdCollectService {

    private final JdParser jdParser;

    public JdCollectService(JdParser jdParser) {
        this.jdParser = jdParser;
    }

    public byte[] collectCsv(List<String> urls) {
        List<JobDescription> jobDescriptions = collectJobDescriptions(urls);
        String csv = convertToCsv(jobDescriptions);
        return csv.getBytes(StandardCharsets.UTF_8);
    }

    private List<JobDescription> collectJobDescriptions(List<String> urls) {
        List<JobDescription> result = new ArrayList<>();

        for (String url : urls) {
            result.add(jdParser.parse(url));
        }
        return result;
    }

    private String convertToCsv(List<JobDescription> jobDescriptions) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("title,company,content,sourceUrl\n");

        for (JobDescription jd : jobDescriptions) {
            csvBuilder
                .append(CsvEscapeUtil.escape(jd.getTitle())).append(",")
                .append(CsvEscapeUtil.escape(jd.getCompany())).append(",")
                .append(CsvEscapeUtil.escape(jd.getContent())).append(",")
                .append(CsvEscapeUtil.escape(jd.getSourceUrl()))
                .append("\n");
        }
        return csvBuilder.toString();
    }
}
