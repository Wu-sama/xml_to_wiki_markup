package com.test.astraia.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

class ReportServiceTest {

    private final ReportService service = new ReportService();

    @BeforeAll
    static void init(){
        ReportService.setOutputFolderPath("src/test/resources/examples/output/");
    }

    @Test
    void parseExample1ToWikiFormat(){
        File example1 = new File("src/test/resources/examples/example1.xml");
        service.formatReport(example1);
    }
}