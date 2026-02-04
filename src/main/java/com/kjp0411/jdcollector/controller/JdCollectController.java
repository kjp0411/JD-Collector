package com.kjp0411.jdcollector.controller;

import com.kjp0411.jdcollector.controller.dto.JdCollectRequest;
import com.kjp0411.jdcollector.service.JdCollectService;
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
public class JdCollectController{

    private final JdCollectService jdCollectService;

    public JdCollectController(JdCollectService jdCollectService) {
        this.jdCollectService = jdCollectService;
    }

    @PostMapping("/collect")
    public ResponseEntity<Resource> collectJd(@RequestBody JdCollectRequest request) {
        System.out.println("요청 URL 개수: " + request.getUrls().size());

        byte[] dummyCsv = jdCollectService.collectCsv(request.getUrls());
        ByteArrayResource resource = new ByteArrayResource(dummyCsv);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=jd.csv")
            .contentType(MediaType.parseMediaType("text/csv"))
            .body(resource);
    }
}
