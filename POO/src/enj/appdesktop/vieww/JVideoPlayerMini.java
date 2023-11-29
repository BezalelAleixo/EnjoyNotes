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

public class JVideoPlayerMini {

    private final JFXPanel fxPanel = new JFXPanel();
    private final String videoPath;
    private final javafx.util.Duration startTime;

    public JVideoPlayerMini(String videoPath, javafx.util.Duration startTime) {
        this.videoPath = videoPath;
        this.startTime = startTime;
        initFX(fxPanel, 100,80);
    }

    private void initFX(JFXPanel fxPanel, int preferredWidth, int preferredHeight) {
        Platform.runLater(() -> {
            try {
                File file = new File(videoPath);
                String mediaUrl = file.toURI().toURL().toString();

                Media media = new Media(mediaUrl);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                
                mediaView.setFitWidth(preferredWidth);
                mediaView.setFitHeight(preferredHeight);

                Scene scene = new Scene(new javafx.scene.layout.StackPane(mediaView), preferredWidth, preferredHeight);
                fxPanel.setScene(scene);
                
                mediaPlayer.setOnReady(() -> {
                    // Define a posição inicial do vídeo
                    mediaPlayer.seek(startTime);
                });
                
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public JFXPanel getFxPanel() {
        return fxPanel;
    }
}
