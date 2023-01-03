package projet.vue;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet.modele.ThreeDObject;

/**
 *class used to setup the main window
 *
 */
public class FirstWindow extends Stage{
	
	/**
	 * setups the main window and displays it
	 * @param obj the object displayed
	 * @throws IOException .
	 */
	public FirstWindow(ThreeDObject obj) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Fenetreprincipale.fxml"));
		Parent root = loader.load();
		FirstWindowController controller = loader.getController();
		Scene scene = new Scene(root);
		controller.setModel(obj);
		controller.listFilesForFolder();
		this.setScene(scene);
		this.setTitle("Fenetre principale");
		this.show();
	}
}