package com.courses.spalah;

import com.courses.spalah.reader.NaiveReader;
import com.courses.spalah.reader.ReaderFactory;
import com.courses.spalah.reader.TrackReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ievgen Tararaka
 */
public class MusicPlayerAppStarter {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"music-app-context.xml"});

        MusicPlayerApp musicPlayerApp = applicationContext.getBean("musicApp", MusicPlayerApp.class);
        musicPlayerApp.play();
        MusicPlayerApp musicPlayerApp1 = applicationContext.getBean("musicApp", MusicPlayerApp.class);
        MusicPlayerApp musicPlayerApp2 = applicationContext.getBean("musicApp", MusicPlayerApp.class);
        MusicPlayerApp musicPlayerApp3 = applicationContext.getBean("musicApp", MusicPlayerApp.class);
        System.out.println(musicPlayerApp);
        System.out.println(musicPlayerApp1);
        System.out.println(musicPlayerApp2);
        System.out.println(musicPlayerApp3);

        TrackReader trackReader = applicationContext.getBean("trackReader", TrackReader.class);
        System.out.println(trackReader);
        trackReader = applicationContext.getBean("trackReader", TrackReader.class);
        System.out.println(trackReader);
        trackReader = applicationContext.getBean("trackReader", TrackReader.class);
        System.out.println(trackReader);
    }
}
