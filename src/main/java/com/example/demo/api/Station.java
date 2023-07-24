package com.example.demo.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "station")
public class Station {

    private String ril100; //<shortcode> Die Abkürzung für den Bahnhof(2-5 Zeichen)
    private String name; //Stationsname
    private List<Track> tracks; //Gleis

    //Getter and Setter
    @XmlElement(name = "shortcode")
    public String getRil100() {
        return ril100;
    }

    public void setRil100(String ril100) {
        this.ril100 = ril100;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "tracks")
    @XmlElement(name = "track")
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    class Track {
        private int number;
        private List<Train> trains;

        //Getter and Setter
        @XmlElement(name = "number")
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @XmlElementWrapper(name = "trains")
        @XmlElement(name = "train")
        public List<Train> getTrains() {
            return trains;
        }

        public void setTrains(List<Train> trains) {
            this.trains = trains;
        }
    }

    class Train {
        private List<Integer> trainNumbers;
        private List<Waggon> waggons;

        //Getter and Setter
        @XmlElementWrapper(name = "trainNumbers")
        @XmlElement(name = "trainNumber")
        public List<Integer> getTrainNumbers() {
            return trainNumbers;
        }

        public void setTrainNumbers(List<Integer> trainNumbers) {
            this.trainNumbers = trainNumbers;
        }

        public List<Waggon> getWaggons() {
            return waggons;
        }

        @XmlElementWrapper(name = "waggons")
        @XmlElement(name = "waggon")
        public void setWaggons(List<Waggon> waggons) {
            this.waggons = waggons;
        }
    }

    class Waggon {
        private int position; //Waggon number
        private List<String> sections;


        //Getter and Setter
        @XmlElement(name = "position")
        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
        
        @XmlElementWrapper(name = "sections")
        @XmlElement(name = "identifier")
        public List<String> getSections() {
            return sections;
        }

        public void setSections(List<String> sections) {
            this.sections = sections;
        }


    }

}


