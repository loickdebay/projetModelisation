package projet.modele;

import javafx.animation.AnimationTimer;

/**
 * This class controls the automatic rotation of the model
 *
 */
public class Timer extends AnimationTimer{

    /**
     * the model that we're using for the rotation
     */
    private ThreeDObject model;

    /**
     * Allows to know if the model is rotating
     */
    private boolean running;

    /**
     * constructor
     * @param model the rotating model
     */
    public Timer(ThreeDObject model) {
        this.model=model;
        this.running=false;
    }

    /**
     * allows to know if the timer is running
     * @return true if it is, false otherwise
     */
    public boolean isRunning() {
        return running;
    }

   /**
    * starts the timer
    */
    @Override
    public void start() {
        super.start();
        running = true;
    }

    /**
     * stops the timer
     */
    @Override
    public void stop() {
        super.stop();
        running = false;
    }

    /**
     * method used each rotation
     */
    @Override
    public void handle(long now) {
        model.rotationDroite(10);
    }
}