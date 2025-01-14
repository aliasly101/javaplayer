import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class SongPlayer {
    File[] files;
    SongPaylist songPlaylist = new SongPaylist();

    public int chooseFiles() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileFilter(new FileNameExtensionFilter("WAV Files", "wav"));

        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
            setSongs();
            System.out.println(result);
            return result;

        } else {
            System.out.println(result);
            return result;
        }
    }
    public void setSongs() {

        songPlaylist.setSongs(files);

    }
    public void chooseSong(int index) {
        if (index > songPlaylist.filelist.size() || index < 1) {
            System.out.println("Invalid index! Please refer to song list index number");

        } else {
            songPlaylist.playSong(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Scanner scanner = new Scanner(System.in);
            SongPlayer songPlayer = new SongPlayer();
            System.out.println("Java Music Player");
            System.out.println("----------------");
            System.out.println("Press 1 to load songs");
            System.out.println("Press 2 to Play song by num");
            System.out.println("Press 3 to Pause song");
            System.out.println("Press 4 to Skip song");
            System.out.println("Press 5 to exit song");
            while (true) {

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (songPlayer.chooseFiles() != 0) {
                            System.out.println();
                            break;
                        };
                    case 2:
                        System.out.println("Choose a song no");
                        int songIndex = scanner.nextInt();

                        songPlayer.chooseSong(songIndex);
                        break;
                    case 3:
                        songPlayer.songPlaylist.pauseSong();
                        break;
                    case 4:
                        songPlayer.songPlaylist.skipSking();
                        break;
                    case 5:
                        songPlayer.songPlaylist.current.clearSong();
                        break;

                }
                if (choice == 5) {
                    break;
                }

            }
        });
    }
}