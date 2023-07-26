package com.example.demo.api;

import com.example.demo.api.Station;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/station")
public class StationController {

        @GetMapping(value = "{shortcode}/train/{trainNumber}/waggon/{number}")
        public Map<String, List<String>> getTrackSections(@PathVariable String shortcode, @PathVariable int trainNumber, @PathVariable int number) {
            List<String> trackSections = new ArrayList<>();

            try {
                List<Station> stations = getAllStationsData(); // Get all Station objects from XML files

                for (Station station : stations) {
                    if (station.getShortcode().equals(shortcode)) {
                        for (Track track : station.getTracks()) {
                            for (Train train : track.getTrains()) {
                                if (train.getTrainNumbers().contains(trainNumber)) {
                                    for (Waggon waggon : train.getWaggons()) {
                                        if (waggon.getNumber() == number) {
                                            trackSections.addAll(waggon.getSections());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                // Handle any exceptions or return an error response if necessary.
                e.printStackTrace();
            }

            // Wrap the list of track sections within a map with key "sections"
            Map<String, List<String>> response = new HashMap<>();
            response.put("sections", trackSections);

            return response;
        }

    // Implement the method to read all XML data from the "xml/" folder and convert them into a list of Station objects.
    private List<Station> getAllStationsData() {
        List<Station> stations = new ArrayList<>();
        try {
            // Get a list of all XML files in the "xml/" folder
            ClassPathResource resource = new ClassPathResource("xml/");
            String[] xmlFiles = resource.getFile().list();

            // Create an XmlMapper instance
            XmlMapper xmlMapper = new XmlMapper();

            // Iterate over all XML files and deserialize them into Station objects
            if (xmlFiles != null) {
                for (String xmlFile : xmlFiles) {
                    InputStream xmlResource = StationController.class.getClassLoader().getResourceAsStream("xml/" + xmlFile);
                    Station station = xmlMapper.readValue(xmlResource, Station.class);
                    stations.add(station);
                }
            }
        } catch (IOException e) {
            // Handle any exceptions that might occur during XML parsing
            e.printStackTrace();
        }

        return stations;
    }
}