package com.kjp0411.jdcollector.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jd")
public class JdCollectController {

    @PostMapping("/collect")
    public ResponseEntity<Resource> collectJd() {
        // TODO
        // 1. 요청으로부터 JD URL 목록 받기
        // 2. 서비스에 전달해서 CSV 생성
        // 3. CSV 파일을 ResponseEntity<Resource>로 반환

        byte[] dummyCsv = "title,company,content\n".getBytes();
        ByteArrayResource resource = new ByteArrayResource(dummyCsv);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=jd.csv")
            .contentType(MediaType.parseMediaType("text/csv"))
            .body(resource);
    }
}
