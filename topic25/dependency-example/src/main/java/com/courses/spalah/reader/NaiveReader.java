package com.courses.spalah.reader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.courses.spalah.track.Track;

/**
 * @author Ievgen Tararaka
 */
public class NaiveReader implements TrackReader{
    private static final List<Track> AVAILABLE_TRACKS = new ArrayList<>();

    static {
        AVAILABLE_TRACKS.add(new Track("Don't Let Me Down", 600));
        AVAILABLE_TRACKS.add(new Track("Don't Mind", 420));
        AVAILABLE_TRACKS.add(new Track("Panda", 355));
        AVAILABLE_TRACKS.add(new Track("Work From Home", 111));
    }

    private List<Track> currentTracks = new ArrayList<>();
    private Iterator<Track> trackIterator;

    @Override
    public void load() {
        System.out.println("LOADING");
        currentTracks.addAll(AVAILABLE_TRACKS);
        trackIterator = currentTracks.iterator();
    }

    @Override
    public Track next() {
        if (trackIterator.hasNext()) {
            return trackIterator.next();
        }
        return null;
    }

    @Override
    public List<Track> getAll() {
        return currentTracks;
    }

    public List<Track> getCurrentTracks() {
        return currentTracks;
    }
}
