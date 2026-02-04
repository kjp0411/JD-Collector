package com.kjp0411.jdcollector.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JdCollectService {

    public byte[] collectCsv(List<String> urls) {
        // TODO
        // 1. 각 URL에 대해 JD 파싱
        // 2. JobDescription 리스트 생성
        // 3. CSV 포맷으로 변환

        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("title,company,content\n");

        for (String url : urls) {
            // 더미 데이터 추가
            csvBuilder.append("dummy title,dummy company,dummy content\n");
        }

        return csvBuilder.toString().getBytes(StandardCharsets.UTF_8);
    }
}
