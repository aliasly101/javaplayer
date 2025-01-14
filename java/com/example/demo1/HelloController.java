package com.example.demo1;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloController {
    String  inputChoice;

    private String output;
    private SongPlayer songPlayer = new SongPlayer();
    private SongPaylist songPaylist = songPlayer.songPlaylist;
    Label songLabels = new Label("null");
    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button skipButton;

    @FXML
    private TextField songNum;

    @FXML
    private Button loadMusicButton;

    @FXML
    private GridPane gridPane;

    @FXML
    protected void loadMusicButton() {
        // Calling the chooseFiles method from the SongPlayer class
        songPlayer.chooseFiles(getStage());
        // After files are selected, you can process them as necessary
        this.output = songPlayer.setSongs(); // Add songs to the playlist
        System.out.println(this.output);
        displaySongs();

    }


    private void displaySongs(){

        if (songLabels.getText() != "null"){
            gridPane.getChildren().removeAll(songLabels);
        }
        songLabels = new Label(output);

        songLabels.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-text-fill: #ffdf00; " + // Text color
                        "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.7), 5, 0.0, 2, 2);"); // Shadow effect



        playButton.setOnAction(e -> {
            inputChoice = songNum.getText();
            songPlayer.chooseSong(Integer.parseInt(inputChoice));
            System.out.println(inputChoice);
        });
        pauseButton.setOnAction(e -> {
            songPaylist.pauseSong();
        });
        skipButton.setOnAction(e -> {
            songPaylist.skipSking();
        });




        gridPane.add(songLabels, 0, 1); // Add newLabel1 at rowIndex 1 in column 0
        playButton.setVisible(true);
        pauseButton.setVisible(true);
        skipButton.setVisible(true);
        songNum.setVisible(true);

    }

    private Stage getStage() {
        return (Stage) loadMusicButton.getScene().getWindow();
    }
}
