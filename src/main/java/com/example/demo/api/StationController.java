package com.example.demo.api;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class StationController {

    @GetMapping("/station")
    Station station() throws XMLStreamException, IOException {
        InputStream xmlResource = StationController.class.getClassLoader().getResourceAsStream("xml/0Test.xml");
        XMLInputFactory xmlInputFactory = javax.xml.stream.XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlResource);

        XmlMapper mapper = new XmlMapper();

        return mapper.readValue(xmlStreamReader, Station.class);
    }
}
