package com.test.wiki.markup.file;

import com.test.wiki.markup.model.xsd.Report;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.stream.XMLStreamException;
import java.io.File;

public class ReportReader {
    static final JAXBContext context = initContext();

    private static JAXBContext initContext() {
        try {
            return JAXBContext.newInstance(Report.class);
        } catch (JAXBException e) {
            System.out.println("Impossible to create JAXBContext. Reason: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Report readFile(File file) throws JAXBException, XMLStreamException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Report) unmarshaller.unmarshal(file);
    }
}
