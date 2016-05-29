package com.courses.spalah.reader;

import com.courses.spalah.track.Track;

import java.util.Collections;

/**
 * Created by Jeka on 23.05.2016.
 */
public class RandomTrackReader extends NaiveReader {
    @Override
    public void load() {
        super.load();
        Collections.shuffle(getCurrentTracks());
    }
}
