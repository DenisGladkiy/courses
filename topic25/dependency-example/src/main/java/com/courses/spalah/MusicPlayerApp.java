package com.courses.spalah;

import java.util.List;

import com.courses.spalah.reader.TrackReader;
import com.courses.spalah.track.Track;

/**
 * @author Ievgen Tararaka
 */
public class MusicPlayerApp {
    private TrackReader trackReader;
    private String shout;

    public MusicPlayerApp(TrackReader trackReader, String shout) {
        this.trackReader = trackReader;
        this.shout = shout;
    }

    public void play() {
        playInterface();
    }

    private void playInterface() {
        trackReader.load();

        List<Track> tracks = trackReader.getAll();
        System.out.println("Tracks: " + tracks);

        for (int i = 0; i < tracks.size(); i++) {
            Track track = trackReader.next();
            System.out.println("Playing track " + track.getName() + " for " + track.getDurationInSeconds() + " seconds");
            System.out.println(shout);
        }
    }
}
