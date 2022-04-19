package com.test.astraia.service;

import com.test.astraia.model.xsd.Report;
import com.test.astraia.model.xsd.Section;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    void toWikiFormatEmotyReport() {
        Report report = new Report();

        String result = service.toWikiFormat(report);

        Assertions.assertEquals("", result);
    }

    @Test
    void toWikiFormatCheckHeaders() {
        String result = service.toWikiFormat(getReportWithTwoSections());

        Assertions.assertEquals("=Heading 1=\n" +
                "==Heading 2==\n" +
                "\n" +
                "=Heading 1=\n" +
                "==Heading 2==\n"
                , result);
    }

    private Report getReportWithTwoSections(){
        String str = "Some string";
        Section sections = getSection(1);
        sections.getContent().add(getSection(2));
        Report report = new Report();
        report.getContent().add(sections);
        report.getContent().add(sections);
        return report;
    }
    private Section getSection(int order) {
        Section section = new Section();
        section.setHeading("Heading "+ order);
        return section;
    }
}