package com.kjp0411.jdcollector.controller;

import com.kjp0411.jdcollector.controller.dto.JdCollectRequest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jd")
public class JdCollectController {

    @PostMapping("/collect")
    public ResponseEntity<Resource> collectJd(@RequestBody JdCollectRequest request) {
        System.out.println("요청 URL 개수: " + request.getUrls().size());

        byte[] dummyCsv = "title,company,content\n".getBytes();
        ByteArrayResource resource = new ByteArrayResource(dummyCsv);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=jd.csv")
            .contentType(MediaType.parseMediaType("text/csv"))
            .body(resource);
    }
}
