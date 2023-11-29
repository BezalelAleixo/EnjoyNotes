package enj.appdesktop.vieww;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.Duration;

public class VideoPlayer {

    private final JFXPanel fxPanel = new JFXPanel();
    private final String videoPath;
    MediaPlayer mediaPlayer;

    public VideoPlayer(String videoPath) {
        this.videoPath = videoPath;
        initFX(fxPanel, 600,300);
    }

    private void initFX(JFXPanel fxPanel, int preferredWidth, int preferredHeight) {
        Platform.runLater(() -> {
            try {
                File file = new File(videoPath);
                String mediaUrl = file.toURI().toURL().toString();

                Media media = new Media(mediaUrl);
                mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                
                mediaView.setFitWidth(preferredWidth);
                mediaView.setFitHeight(preferredHeight);

                Scene scene = new Scene(new javafx.scene.layout.StackPane(mediaView), preferredWidth, preferredHeight);
                fxPanel.setScene(scene);
                
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public JFXPanel getFxPanel() {
        return fxPanel;
    }
    public void pause() {
    	mediaPlayer.pause();
    }
    public void reproduzir() {
    	mediaPlayer.play();
    }
}
