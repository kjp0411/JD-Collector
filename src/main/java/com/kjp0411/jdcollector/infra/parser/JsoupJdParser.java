package com.kjp0411.jdcollector.infra.parser;

import com.kjp0411.jdcollector.domain.JobDescription;
import org.springframework.stereotype.Component;

@Component
public class JsoupJdParser implements JdParser {

    @Override
    public JobDescription parse(String url) {
        // TODO: Jsoup 기반 실제 HTML 파싱 구현 예정
        return new JobDescription(
            "not implemented",
            "not implemented",
            "not implemented",
            url
        );
    }

}
