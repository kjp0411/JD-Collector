package com.kjp0411.jdcollector.infra.parser;

import com.kjp0411.jdcollector.domain.JobDescription;

public interface JdParser {

    JobDescription parse(String url);

}
