package com.test.astraia.file;

import com.test.astraia.model.xsd.Report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReportReader {
    static final JAXBContext context = initContext();

    private static JAXBContext initContext() {
        try {
            return JAXBContext.newInstance(Report.class);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Report readFile(File file) throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Report) unmarshaller.unmarshal(file);
    }
}
