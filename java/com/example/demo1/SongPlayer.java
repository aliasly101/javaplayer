package com.example.demo1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class SongPlayer{
    File[] files;
    SongPaylist songPlaylist = new SongPaylist();

    public void chooseFiles(Stage stage) {

        FileChooser chooser = new FileChooser();
//        chooser.setMultiSelectionEnabled(true);
        chooser.setTitle("Load your songs");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("WAV","*.wav")
        );


//        int result = chooser.showOpenDialog(null);
        List<File> selectedFiles = chooser.showOpenMultipleDialog(stage);
        if (selectedFiles!= null)
        {
            files = selectedFiles.toArray(new File[0]);

        }

    }
    public String setSongs() {
        String returnedSetSong = songPlaylist.setSongs(files);
        System.out.println("SongPLayer" + returnedSetSong);

        return returnedSetSong;

    }
    public void chooseSong(int index) {
        if (index > songPlaylist.filelist.size() || index < 1) {
            System.out.println("Invalid index! Please refer to song list index number");

        } else {
            songPlaylist.playSong(index);
        }
    }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//
//            Scanner scanner = new Scanner(System.in);
//            SongPlayer songPlayer = new SongPlayer();
//            System.out.println("Java Music Player");
//            System.out.println("----------------");
//            System.out.println("Press 1 to load songs");
//            System.out.println("Press 2 to Play song by num");
//            System.out.println("Press 3 to Pause song");
//            System.out.println("Press 4 to Skip song");
//            System.out.println("Press 5 to exit song");
//            while (true) {
//
//                int choice = scanner.nextInt();
//                switch (choice) {
//
//
//                    case 2:
//                        System.out.println("Choose a song no");
//                        int songIndex = scanner.nextInt();
//
//                        songPlayer.chooseSong(songIndex);
//                        break;
//                    case 3:
//                        songPlayer.songPlaylist.pauseSong();
//                        break;
//                    case 4:
//                        songPlayer.songPlaylist.skipSking();
//                        break;
//                    case 5:
//                        songPlayer.songPlaylist.current.clearSong();
//                        break;
//
//                }
//                if (choice == 5) {
//                    break;
//                }
//
//            }
//        });
//    }
