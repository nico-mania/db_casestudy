package com.example.demo.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "station")
public class Station {

    @XmlElement(name = "shortcode")
    private String shortcode; //<shortcode> Die Abkürzung für den Bahnhof(2-5 Zeichen)

    @XmlElement(name = "name")
    private String name; //Stationsname

    @XmlElement(name = "validity")
    private String validity;

    @XmlElementWrapper(name = "tracks")
    @XmlElement(name = "track")
    private List<Track> tracks; //Gleis

    //Getter and Setter
    @XmlElement(name = "shortcode")
    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "validity")
    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    @XmlElementWrapper(name = "tracks")
    @XmlElement(name = "track")
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}

    class Track {
        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "number")
        private int number;

        @XmlElementWrapper(name = "trains")
        @XmlElement(name = "train")
        private List<Train> trains;

        @XmlElement(name = "sections")
        private String sections;

        //Getter and Setter
        @XmlElement(name = "name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        @XmlElement(name = "sections")
        public String getSections() {
            return sections;
        }

        public void setSections(String sections) {
            this.sections = sections;
        }
    }

    class Train {
        @XmlElementWrapper(name = "trainNumbers")
        @XmlElement(name = "trainNumber")
        private List<Integer> trainNumbers;

        @XmlElement(name = "anno")
        private String anno;

        @XmlElement(name = "time")
        private String time;

        @XmlElement(name = "additionalText")
        private String additionalText;

        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "subtrains")
        private String subtrains;

        @XmlElementWrapper(name = "waggons")
        @XmlElement(name = "waggon")
        private List<Waggon> waggons;

        @XmlElement(name = "traintypes")
        private String traintypes;

        //Getter and Setter
        @XmlElementWrapper(name = "trainNumbers")
        @XmlElement(name = "trainNumber")
        public List<Integer> getTrainNumbers() {
            return trainNumbers;
        }

        public void setTrainNumbers(List<Integer> trainNumbers) {
            this.trainNumbers = trainNumbers;
        }

        @XmlElement(name = "anno")
        public String getAnno() {
            return anno;
        }

        public void setAnno(String anno) {
            this.anno = anno;
        }

        @XmlElement(name = "time")
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @XmlElement(name = "additionalText")
        public String getAdditionalText() {
            return additionalText;
        }

        public void setAdditionalText(String additionalText) {
            this.additionalText = additionalText;
        }

        @XmlElement(name = "name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlElement(name = "subtrains")
        public String getSubtrains() {
            return subtrains;
        }

        public void setSubtrains(String subtrains) {
            this.subtrains = subtrains;
        }

        public List<Waggon> getWaggons() {
            return waggons;
        }

        @XmlElementWrapper(name = "waggons")
        @XmlElement(name = "waggon")
        public void setWaggons(List<Waggon> waggons) {
            this.waggons = waggons;
        }

        @XmlElement(name = "traintypes")
        public String getTraintypes() {
            return traintypes;
        }

        public void setTraintypes(String traintypes) {
            this.traintypes = traintypes;
        }
    }

    class Waggon {
        @XmlElement(name = "position")
        private int position; //Waggon number

        @XmlElement(name = "isWaggon")
        private int isWaggon;

        @XmlElementWrapper(name = "sections")
        @XmlElement(name = "identifier")
        private List<String> sections;

        @XmlElement(name = "number")
        private int number;

        @XmlElement(name = "type")
        private String type;

        @XmlElement(name = "symbols")
        private String symbols;

        @XmlElement(name = "differentDestination")
        private String differentDestination;

        @XmlElement(name = "length")
        private int length;

        //Getter and Setter
        @XmlElement(name = "position")
        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @XmlElement(name = "isWaggon")
        public int getIsWaggon() {
            return isWaggon;
        }

        public void setIsWaggon(int isWaggon) {
            this.isWaggon = isWaggon;
        }

        @XmlElementWrapper(name = "sections")
        @XmlElement(name = "identifier")
        public List<String> getSections() {
            return sections;
        }

        public void setSections(List<String> sections) {
            this.sections = sections;
        }

        @XmlElement(name = "number")
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @XmlElement(name = "type")
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @XmlElement(name = "symbols")
        public String getSymbols() {
            return symbols;
        }

        public void setSymbols(String symbols) {
            this.symbols = symbols;
        }

        @XmlElement(name = "differentDestination")
        public String getDifferentDestination() {
            return differentDestination;
        }

        public void setDifferentDestination(String differentDestination) {
            this.differentDestination = differentDestination;
        }

        @XmlElement(name = "length")
        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }




