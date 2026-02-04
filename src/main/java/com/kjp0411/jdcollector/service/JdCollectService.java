package com.kjp0411.jdcollector.service;

import com.kjp0411.jdcollector.domain.JobDescription;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JdCollectService {

    public byte[] collectCsv(List<String> urls) {
        List<JobDescription> jobDescriptions = collectJobDescriptions(urls);
        String csv = convertToCsv(jobDescriptions);
        return csv.getBytes(StandardCharsets.UTF_8);
    }

    private List<JobDescription> collectJobDescriptions(List<String> urls) {
        List<JobDescription> result = new ArrayList<>();

        for (String url : urls) {
            // TODO: 실제 파싱 로직으로 교체 예정
            JobDescription jd = new JobDescription(
                "dummy title",
                "dummy company",
                "dummy content",
                url
            );
            result.add(jd);
        }
        return result;
    }

    private String convertToCsv(List<JobDescription> jobDescriptions) {
        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("title,company,content,sourceUrl\n");

        for (JobDescription jd : jobDescriptions) {
            csvBuilder.append(jd.getTitle()).append(",")
                .append(jd.getCompany()).append(",")
                .append(jd.getContent()).append(",")
                .append(jd.getSourceUrl()).append("\n");
        }
        return csvBuilder.toString();
    }
}
