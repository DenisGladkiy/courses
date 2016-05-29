package com.courses.spalah.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jeka on 23.05.2016.
 */
public class ReaderFactory {
    static List<TrackReader> readers = new ArrayList<>();

    static {
        readers.add(new NaiveReader());
        readers.add(new RandomTrackReader());
        readers.add(new CachableTrackReader());
    }

    public static TrackReader create() {
        Random r = new Random();
        int random = r.nextInt(readers.size());
        return readers.get(random);
    }
}
