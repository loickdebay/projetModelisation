package projet.vue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projet.modele.ControllerMisc;
import projet.modele.PlyReader;
import projet.modele.Sommet;
import projet.modele.ThreeDObject;
import projet.modele.Timer;
import projet.utils.Observer;
import projet.utils.Subject;

/**
 * contains every method used on the main window
 */
public class FirstWindowController implements Observer{
	/**
	 * file chooser
	 */
	final FileChooser fileChooser = new FileChooser();
	/**
	 * the file
	 */
	private File file = null;
	/**
	 * the stage
	 */
	@FXML protected Stage stage;
	/**
	 * first view canvas
	 */
	@FXML protected Canvas canvas;
	/**
	 * button to pick a file
	 */
	@FXML protected Button buttonouvre;
	/**
	 * button to rotate to zoom more
	 */
	@FXML protected Button zoomplus;
	/**
	 * button to zoom less
	 */
	@FXML protected Button zoommoins;
	/**
	 * button to rotate to the left
	 */
	@FXML protected Button rotationgauche;
	/**
	 * button to rotate to the right
	 */
	@FXML protected Button rotationdroite;
	/**
	 * button to move up
	 */
	@FXML protected Button translationhaut;
	/**
	 * button to move down
	 */
	@FXML protected Button translationbas;
	/**
	 * button to move to the left
	 */
	@FXML protected Button translationgauche;
	/**
	 * button to move to the right
	 */
	@FXML protected Button translationdroite;
	/**
	 * the resize button
	 */
	@FXML protected Button recadrage;
	/**
	 * the button to start the rotation
	 */
	@FXML protected Button playButton;
	/**
	 * the open file button (doesn't work)
	 */
	@FXML protected Button openButton;
	/**
	 * the list getting the file details
	 */
	@FXML protected TableView<Ply> tableListe;
	/**
	 * the column getting the file name
	 */
	@FXML protected TableColumn<Ply, String> colonneNom;
	/**
	 * the column getting the faces count
	 */
	@FXML protected TableColumn<Ply, String> colonneFaces;
	/**
	 * the column getting the file size
	 */
	@FXML protected TableColumn<Ply, String> colonneTaille;
	/**
	 * the column getting the vertexes count
	 */
	@FXML protected TableColumn<Ply, String> colonneSommet;
	/**
	 * the 3d object we're working on
	 */
	private ThreeDObject obj;
	/**
	 * the object used
	 */
	private ControllerMisc method = new ControllerMisc();
	/**
	 * the default face color
	 */
	protected Color defaultFaceColor = Color.rgb(102, 102, 153);
	/**
	 * the light source
	 */
	private Sommet lumiere = new Sommet(150, 0,0);
	/**
	 * the timer used for the rotation
	 */
	private Timer timer;

	/**
	 * sets the given model to the current display
	 * @param obj the new object to show
	 */
	public void setModel(ThreeDObject obj) {
		this.obj = obj;
		obj.attach(this);
		timer = new Timer(obj);
	}

	/**
	 * detects the mouse click and rotates the view according to it.
	 * @param event the mouse click
	 */
	public void rotation(MouseEvent event) {
		List<Sommet> pts = this.obj.getPoints();
		if(event.getSource() == rotationdroite) {
			pts = method.rotation(pts, false);
		}else if(event.getSource() == rotationgauche) {
			pts = method.rotation(pts, true);
		}
		method.Centrage(pts);
		this.obj.setPoints(pts);
	}

	/**
	 * detects the mouse click and zooms the model according to it
	 * @param event the mouse click
	 */
	public void zoom(MouseEvent event) {
		List<Sommet> pts = this.obj.getPoints();
		if(event.getSource() == zoomplus) {
			pts = method.zoom(pts, false);
		}
		if(event.getSource() == zoommoins) {
			pts = method.zoom(pts, true);
		}
		this.obj.setPoints(pts);
	}

	/**
	 * detects the mouse click and moves the model according to it
	 * @param event the mouse click
	 */
	public void translation(MouseEvent event) {
		List<Sommet> pts = this.obj.getPoints();
		int movement = -1;
		if(event.getSource() == translationhaut) {
			movement = 0;
		}
		if(event.getSource() == translationbas) {
			movement = 1;
		}
		if(event.getSource() == translationdroite) {
			movement = 2;
		}
		if(event.getSource() == translationgauche) {
			movement = 3;
		}
		pts = method.translation(pts, movement);
		this.obj.setPoints(pts);
	}

	/**
	 * detects the mouse click and crops the view according to it
	 * @param event the mouse click
	 */
	public void recadrage(MouseEvent event) {
		List<Sommet> pts = method.Centrage(this.obj.getPoints());
		this.obj.setPoints(pts);
	}

	/**
	 * detects the mouse click and resets the view according to it
	 * @param event the mouse click
	 */
	public void reset(MouseEvent event) {
		new PlyReader(file,obj);
		List<Sommet> pts = method.Centrage(method.MatriceModifier(this.obj));
		this.obj.setFacesOnly(false);
		this.obj.setSegmentsOnly(false);
		this.obj.setPoints(pts);
	}
	/**
	 * controls the automatic rotation 
	 * @param event the mouse event that starts the method
	 */
	public void controleurHorloge(MouseEvent event) {
		if (!timer.isRunning()) {
            timer.start();
            playButton.setText("Stop");
        }else {
            timer.stop();
            playButton.setText("Start");
        }
	}
/**
 * allows to only show the faces of the model
 * @param event the mouse event that starts the method
 */
	public void facesSeulement(MouseEvent event) {
		this.obj.setFacesOnly(true);
		this.obj.setSegmentsOnly(false);
		this.obj.setPoints(this.obj.getPoints());
	}
	/**
	 * allows to only show the segments of the model
	 * @param event the mouse event that starts the method
	 */
	public void segmentsSeulement(MouseEvent event) {
		this.obj.setFacesOnly(false);
		this.obj.setSegmentsOnly(true);
		this.obj.setPoints(this.obj.getPoints());
	}

	/**
	 * detects the mouse click and opens a file chooser if triggered
	 * @param test the mouse click
	 * @throws IOException .
	 */
	public void FileChooserButton(MouseEvent test) throws IOException {
		GraphicsContext graphicContext = canvas.getGraphicsContext2D();
		graphicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		file = fileChooser.showOpenDialog(stage);
		PlyReader reader = new PlyReader(file,this.obj);
		if(!reader.getError()) {
			showAlertWithoutHeaderText();
		}
		List<Sommet> pts = method.Centrage(method.MatriceModifier(this.obj));
		this.obj.setPoints(pts);
	}

	/**
	 * shows an error whenever a non Ply file is selected
	 */
	private void showAlertWithoutHeaderText() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning alert");
		alert.setHeaderText(null);
		alert.setContentText("The file is not in the Ply format!");
		alert.showAndWait();
	}

	/**
	 * updates the view according to any modification
	 */
	@Override
	public void update(Subject subj) {
		if(this.obj.getFaces() != null && this.obj.getPoints() != null) {
			GraphicsContext graphicContext = this.canvas.getGraphicsContext2D();
			graphicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			graphicContext.strokeLine(0, 0, 500, 0);
			graphicContext.strokeLine(0, 0, 0, 500);
			graphicContext.strokeLine(500, 0, 500, 500);
			graphicContext.strokeLine(0, 500, 500, 500);
			if(this.obj.isSegmentsOnly()) {
				affichageSegments(obj);
			}else if(this.obj.isFacesOnly()) {
				affichageFaces(obj);
			}else {
				affichage(obj);
			}
		}
	}
	/**
	 * shows a 3d object on the canvas
	 * @param obj the 3d object
	 */
	public void affichage(ThreeDObject obj) {
		GraphicsContext graphicContext = this.canvas.getGraphicsContext2D();
		graphicContext.setFill(defaultFaceColor);
		double alpha = 1;
		for (int i = 0; i < this.obj.getFaces().size(); i++) {
			alpha = method.calculCouleur(this.obj.getFaces().get(i), lumiere);
			if (alpha<1) {
				graphicContext.setFill(new Color(defaultFaceColor.getRed()*Math.abs(alpha), defaultFaceColor.getGreen()*Math.abs(alpha), defaultFaceColor.getBlue()*Math.abs(alpha), 1));
			}else {
				graphicContext.setFill(defaultFaceColor);
			}
			graphicContext.fillPolygon(this.obj.getFaces().get(i).getAllX(),this.obj.getFaces().get(i).getAllY(),this.obj.getFaces().get(i).getNb_points());
			graphicContext.strokePolygon(this.obj.getFaces().get(i).getAllX(),this.obj.getFaces().get(i).getAllY(),this.obj.getFaces().get(i).getNb_points());
		}
	}
/**
 * shows the model with the segment only view
 * @param obj the 3d object
 */
	public void affichageSegments(ThreeDObject obj) {
		GraphicsContext graphicContext = this.canvas.getGraphicsContext2D();
		graphicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphicContext.strokeLine(0, 0, 500, 0);
		graphicContext.strokeLine(0, 0, 0, 500);
		graphicContext.strokeLine(500, 0, 500, 500);
		graphicContext.strokeLine(0, 500, 500, 500);
		for (int i = 0; i < this.obj.getFaces().size(); i++) {
			graphicContext.strokePolygon(this.obj.getFaces().get(i).getAllX(),this.obj.getFaces().get(i).getAllY(),this.obj.getFaces().get(i).getNb_points());
		}
	}
	/**
	 * shows the model with the faces only view
	 * @param obj the 3d object
	 */
	public void affichageFaces(ThreeDObject obj) {
		GraphicsContext graphicContext = this.canvas.getGraphicsContext2D();
		graphicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		graphicContext.strokeLine(0, 0, 500, 0);
		graphicContext.strokeLine(0, 0, 0, 500);
		graphicContext.strokeLine(500, 0, 500, 500);
		graphicContext.strokeLine(0, 500, 500, 500);
		graphicContext.setFill(defaultFaceColor);
		double alpha = 1;
		for (int i = 0; i < this.obj.getFaces().size(); i++) {
			alpha = method.calculCouleur(this.obj.getFaces().get(i), lumiere);
			if (alpha<1) {
				graphicContext.setFill(new Color(defaultFaceColor.getRed()*Math.abs(alpha), defaultFaceColor.getGreen()*Math.abs(alpha), defaultFaceColor.getBlue()*Math.abs(alpha), 1));
			}else {
				graphicContext.setFill(defaultFaceColor);
			}
			graphicContext.fillPolygon(this.obj.getFaces().get(i).getAllX(),this.obj.getFaces().get(i).getAllY(),this.obj.getFaces().get(i).getNb_points());
		}
	}

	/**
	 * updates the view according to any modification
	 */
	@Override
	public void update(Subject subj, Object data) {
		//useless
	}	

	/**
	 * displays every file contained into the Ply folder into a tableView on the main window (doesn't work apparently)
	 * @throws IOException exception
	 */
	public void listFilesForFolder() throws IOException {
		
		ObservableList<Ply> itemsList = FXCollections.observableArrayList();
		File folder = null;
		String path = System.getProperty("user.dir");
		if(path.contains("target")) {
			 folder = new File(System.getProperty("user.dir") + File.separator + "classes");
		}else {
			 folder = new File(System.getProperty("user.dir")+ File.separator + "target" +File.separator + "classes");
		}
		File[] listOfFiles = folder.listFiles();
		int cpt =0;
		try {
		for (File file : listOfFiles) {
			colonneNom.setCellValueFactory(features -> features.getValue().getName());
			colonneTaille.setCellValueFactory(features -> features.getValue().getTaille());
			colonneSommet.setCellValueFactory(features -> features.getValue().getPoints());
			colonneFaces.setCellValueFactory(features -> features.getValue().getFaces());
			
			if (file.isFile()) {		
				FileInputStream fis = new FileInputStream(file);
			    Scanner scanner = new Scanner(fis);
			    String firstLine = scanner.nextLine();
			    
				if (firstLine.equals("ply")&&file.getName().substring(file.getName().length()-1,file.getName().length()).equals("y")) {
					itemsList.add(cpt, new Ply(file));					
					cpt++;
				}
				scanner.close();
			}	
		}	
		tableListe.setItems(itemsList);	
		}catch(Exception e) {
			System.out.println("Une erreur est survenue lors de la recherche du fichier où sont situés les fichier ply.");
		}
	}
}




