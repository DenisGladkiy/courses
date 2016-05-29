package com.courses.spalah.reader;

import com.courses.spalah.track.Track;

import java.util.List;

/**
 * Created by Jeka on 23.05.2016.
 */
public interface TrackReader {
    void load();

    Track next();

    List<Track> getAll();
}
