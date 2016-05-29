package com.courses.spalah.reader;

import com.courses.spalah.track.Track;

import java.util.List;

/**
 * Created by Jeka on 23.05.2016.
 */
public class CachableTrackReader implements TrackReader {
    private TrackReader trackReader;
    private boolean loaded = false;

    @Override
    public void load() {
        if (!loaded) {
            trackReader.load();
            loaded = true;
            return;
        }
        System.out.println("not loading");
    }

    @Override
    public Track next() {
        return trackReader.next();
    }

    @Override
    public List<Track> getAll() {
        return trackReader.getAll();
    }

    public void setTrackReader(TrackReader trackReader) {
        this.trackReader = trackReader;
    }
}
