package com.example.demo1;

import com.example.demo1.Player;

import java.io.*;
import java.util.*;

public class SongPaylist implements Player {
    Song current = new Song();
    File currentFile;

    ArrayList < File > filelist = new ArrayList < File > ();

    public String setSongs(File[] files) {

        for (File file: files) {
            if (!filelist.contains(file)) {

                filelist.add(file);
            }

        }

        String songList = printSongList();
        return songList;

    }
    public String printSongList() {
        int songNo = 0;
        StringBuilder sb = new StringBuilder("");
        for (File file: filelist) {
            songNo += 1;
            sb.append(songNo).append(". ").append(file.getName()).append("\n"); // Adding newline after each song
       }
        return sb.toString();
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