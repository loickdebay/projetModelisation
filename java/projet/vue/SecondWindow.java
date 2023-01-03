package projet.vue;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet.modele.ThreeDObject;

/**
 * setups the second window (the top view)
 *
 */
public class SecondWindow extends Stage{
	
	/**
	 * setups the second window with every element used on it
	 * @param obj the 3d object
	 * @throws IOException exception
	 */
	public SecondWindow(ThreeDObject obj) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vuedehaut.fxml"));
		Parent root = loader.load();
		SecondWindowController controller = loader.getController();
		Scene scene = new Scene(root);
		controller.setModel(obj);
		this.setScene(scene);
		this.setTitle("Vue de Haut");
		this.show();
	}
}