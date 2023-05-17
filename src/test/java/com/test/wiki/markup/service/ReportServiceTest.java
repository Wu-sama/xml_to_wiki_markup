package com.test.wiki.markup.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class ReportServiceTest {

    private final ReportService service = new ReportService();

    @BeforeAll
    static void init(){
        ReportService.setOutputFolderPath("src/test/resources/examples/output/");
    }

    @Test
    void parseExample1ToWikiFormat() throws IOException {
        File example1 = new File("src/test/resources/examples/example1.xml");
        Path path = service.formatReport(example1);

        String wikiReport = Files.readString(path);
        String reportExample = Files.readString(Paths.get("src/test/resources/examples/example1.wiki"));
        Assertions.assertEquals(wikiReport, reportExample);
        Files.deleteIfExists(path);
    }
}