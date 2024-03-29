package com.test.wiki.markup.service;

import com.test.wiki.markup.model.xsd.Report;
import com.test.wiki.markup.model.xsd.Section;
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
    void toWikiFormatEmptyReport() {
        Report report = new Report();

        String result = service.toWikiFormat(report);

        Assertions.assertEquals("", result);
    }

    @Test
    void toWikiFormatCheckHeaders() {
        String result = service.toWikiFormat(getReportWithTwoSections());

        Assertions.assertEquals("""
                        =Heading 1=
                        ==Heading 2==
                        =Heading 1=
                        ==Heading 2==
                        """
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