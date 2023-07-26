package com.example.demo.api;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @GetMapping(value = "{shortcode}/train/{trainNumber}/waggon/{number}")
    public List<String> getTrackSections(@PathVariable String shortcode, @PathVariable int trainNumber, @PathVariable int number) {
        List<String> trackSections = new ArrayList<>();

        try {
            Station station = getStationData(); // Implement the method to get Station object from XML

            assert station != null;
            for (Track track : station.getTracks()) {
                for (Train train : track.getTrains()) {
                    if (train.getTrainNumbers().contains(trainNumber)) {
                        for (Waggon waggon : train.getWaggons()) {
                            if (waggon.getPosition() == number) {
                                trackSections.addAll(waggon.getSections());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            // Handle any exceptions or return an error response if necessary.
            e.printStackTrace();
        }

        return trackSections;
    }

    // Implement the method to read XML data and convert it into a Station object.
    private Station getStationData() {
        try {
            // Load the XML file as an InputStream
            InputStream xmlResource = StationController.class.getClassLoader().getResourceAsStream("xml/AA_2017-11-30_10-07-58.xml");

            // Create an XmlMapper instance
            XmlMapper xmlMapper = new XmlMapper();

            // Deserialize the XML data into a Station object

            return xmlMapper.readValue(xmlResource, Station.class);
        } catch (Exception e) {
            // Handle any exceptions that might occur during XML parsing
            e.printStackTrace();
        }

        return null; // Return null if the XML data couldn't be parsed or encountered an error.
    }
}
