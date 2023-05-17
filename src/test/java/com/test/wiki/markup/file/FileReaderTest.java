package com.test.wiki.markup.file;

import com.test.wiki.markup.model.xsd.Report;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;

class FileReaderTest {
    private final ReportReader reportReader =  new ReportReader();

    @Test
    public void readFile() throws XMLStreamException, JAXBException {
        String filePath = "BuildReportTask/examples/example1/example1.xml";
        File file = new File(filePath);
        Report report = reportReader.readFile(file);

        Assertions.assertNotNull(report);
    }

    @Test
    public void readFile2() throws JAXBException, XMLStreamException {
        String filePath = "BuildReportTask/examples/example2/example2.xml";
        File file = new File(filePath);
        Report report = reportReader.readFile(file);
        Assertions.assertNotNull(report);
    }
}