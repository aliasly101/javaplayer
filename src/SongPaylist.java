import java.io.*;
import java.util.*;

public class SongPaylist implements Player {
    Song current = new Song();
    File currentFile;

    ArrayList < File > filelist = new ArrayList < File > ();

    public void setSongs(File[] files) {
        for (File file: files) {
            if (!filelist.contains(file)) {

                filelist.add(file);
                System.out.println("Added " + file.getName());
                System.out.println("Theres " + filelist.size() + " in the playlist");

            }

        }
        printSongList();

    }
    public void printSongList() {
        int songNo = 0;
        for (File file: filelist) {
            songNo += 1;
            System.out.println(songNo + ". " + file.getName());
        }
    }

    @Override
    public void playSong() {

    }

    @Override
    public void playSong(int num) {
        currentFile = filelist.get(num - 1);
        System.out.println("Loaded " + currentFile.getName());

        current.convertSong(currentFile);
        current.playSong();

    }
    @Override
    public void pauseSong() {
        current.pauseSong();
    }

    public void skipSking() {
        int currentIndex;

        currentIndex = filelist.indexOf(currentFile);
        System.out.println(currentIndex);
        currentIndex = (currentIndex + 1) % filelist.size(); // to become 0 and reach start of arraylist by moduling if limit reach
        currentFile = filelist.get(currentIndex);
        current.convertSong(currentFile);
        current.playSong();

    }

}