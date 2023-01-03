package projet.vue;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import projet.modele.ThreeDObject;

/**
 * main class
 *
 */
public class Main extends Application {
	
/**
 * launches the main window
 * @param args args
 */
	public static void main(String[] args) {
		Application.launch(args);	
	}
	
/**
 * starts the main stage
 */
	public void start(Stage stage) throws IOException {
		ThreeDObject obj = new ThreeDObject(null, null, null);
		new FirstWindow(obj);
		new SecondWindow(obj);
		new ThirdWindow(obj);
	}
}
