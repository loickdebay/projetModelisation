package projet.vue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import projet.modele.ThreeDObject;
import projet.modele.Timer;

/**
 * 
 * interface for the automatic rotation
 *
 */
public class TimerIHM extends VBox{
    /**
     * timer that applies the rotation to the model 
     */
    private Timer timer;
    /**
     * the button used to launch the rotation 
     */
    @FXML Button playButton;

    /**
     * section creation
     * @param model the model that rotates
     */
    public TimerIHM(ThreeDObject model) {
    	super();
        this.timer=new Timer(model);
        Label titleTimer=new Label("Timer : ");
        titleTimer.setFont(new Font(15));
        titleTimer.setStyle("-fx-font-weight: bold");
        this.getChildren().addAll(titleTimer,new Separator());
        playButton.setOnAction(e->{
            if (!timer.isRunning()) {
                timer.start();
                playButton.setText("Stop");
            }else {
                timer.stop();
                playButton.setText("Start");
            }
        });
        this.getChildren().add(playButton);
    }
    
    /**
     * stops the timer
     */
    public void stopTimer() {
        timer.stop();
    }
}
