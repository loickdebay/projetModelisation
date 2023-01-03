package projet.vue;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet.modele.ThreeDObject;

/**
 * setups the third window (the front view)
 */
public class ThirdWindow extends Stage{
	
	/**
	 * launches the third window
	 * @param obj the 3d object displayed
	 * @throws IOException exception
	 */
	public ThirdWindow(ThreeDObject obj) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vuedeface.fxml"));
		Parent root = loader.load();
		ThirdWindowController controller = loader.getController();
		Scene scene = new Scene(root);
		controller.setModel(obj);
		this.setScene(scene);
		this.setTitle("Vue de Face");
		this.show();
	}
}