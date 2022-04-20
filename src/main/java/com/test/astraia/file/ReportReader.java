package com.test.astraia.file;

import com.test.astraia.model.xsd.Report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
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

    public Report readFile(File file) throws JAXBException, XMLStreamException {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(file));
        xsr = xif.createFilteredReader(xsr, new StreamFilter() {

            @Override
            public boolean accept(XMLStreamReader reader) {
                if(reader.getEventType() == XMLStreamReader.CHARACTERS) {
                    return reader.getText().trim().length() > 0;
                }
                return true;
            }

        });
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Report) unmarshaller.unmarshal(xsr);
    }
}
