package com.courses.spalah.track;

/**
 * @author Ievgen Tararaka
 */
public class Track {
    private String name;
    private int durationInSeconds;

    public Track() {
    }

    public Track(String name, int durationInSeconds) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", durationInSeconds=" + durationInSeconds +
                '}';
    }
}
