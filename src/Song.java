import java.io.*;
import javax.sound.sampled.*;

public class Song implements Player {

    public String name;
    public File file;
    public AudioInputStream fileStream;
    public Clip clip;

    void convertSong(File file) {
        clearSong();
        this.file = file;
        this.name = file.getName();
        try {
            fileStream = AudioSystem.getAudioInputStream(this.file);
            this.clip = AudioSystem.getClip();

        } catch (UnsupportedAudioFileException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        }

    }
    void clearSong() {
        try {
            if (clip != null && clip.isRunning()) {

                clip.close();
                System.out.println("Cleared song");
            }
        } catch (Exception e) {
            System.out.println("Error while clearing song: " + e.getMessage());
        }
    }

    @Override
    public void playSong() {
        try {

            clip.open(fileStream);
            clip.start();
            System.out.println("Now playing " + file.getName());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void playSong(int num) {

    }

    @Override

    public void pauseSong() {
        int getFramePosition;
        if (clip.isRunning()) {
            getFramePosition = clip.getFramePosition();
            clip.stop();
            clip.setFramePosition(getFramePosition);
            System.out.println("Paused");
        } else if (!clip.isRunning()) {
            clip.start();
            System.out.println("Started");

        }

    }

}