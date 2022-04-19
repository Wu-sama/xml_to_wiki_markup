package com.test.astraia.service;

import com.test.astraia.model.xsd.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WikiReportServiceTest {

    private final WikiReportService service =  new WikiReportService();

    @Test
    void toWikiFormatOnlyStrings() {
        String str = "Some string";
        Report report = new Report();
        report.getContent().add(str);
        report.getContent().add(str);

        String result = service.toWikiFormat(report);

        Assertions.assertEquals(str+"\n"+str, result);
    }
}