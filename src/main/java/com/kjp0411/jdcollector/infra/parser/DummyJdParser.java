package com.kjp0411.jdcollector.infra.parser;

import com.kjp0411.jdcollector.domain.JobDescription;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DummyJdParser implements JdParser {

    @Override
    public JobDescription parse(String url) {
        return new JobDescription(
            "dummy title",
            "dummy company",
            "dummy content",
            url
        );
    }
}
