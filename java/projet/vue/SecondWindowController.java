package projet.vue;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import projet.modele.ControllerMisc;
import projet.modele.GeometryAffine;
import projet.modele.Matrice;
import projet.modele.Sommet;
import projet.modele.ThreeDObject;
import projet.utils.Observer;
import projet.utils.Subject;

/**
 * every second window related method (the top view)
 */
public class SecondWindowController extends Stage implements Observer{
	/**
	 * the current canvas
	 */
	@FXML  Canvas canvas;
	/**
	 * the 3d object
	 */
	private ThreeDObject obj;
	/**
	 * the new method
	 */
	private ControllerMisc method = new ControllerMisc();
	/**
	 * the default face color
	 */
	protected Color defaultFaceColor = Color.rgb(102, 102, 153);
	/**
	 * the light source
	 */
	Sommet lumiere = new Sommet(150, -250,0);

	/**
	 * sets the model of the window to a given one
	 * @param obj the given model
	 */
	public void setModel(ThreeDObject obj) {
		this.obj = obj;
		obj.attach(this);
	}

	/**
	 * updates the view
	 */
	@Override
	public void update(Subject subj) {
		ThreeDObject newObj = obj.getCopy();
		GraphicsContext grahpicContext = canvas.getGraphicsContext2D();
		grahpicContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		List<Sommet> pts = newObj.getPoints();

		for (int i = 0; i < pts.size(); i++) {
			double[][] contenu = new double[][] {{pts.get(i).getX()},
				{pts.get(i).getY()},
				{pts.get(i).getZ()},};
				Matrice matrice = new Matrice(contenu);
				Matrice res = new Matrice(GeometryAffine.rotationX.getMatrice().multiplication(matrice).getContenu());
				pts.get(i).setX((float)res.getContenu()[0][0]);
				pts.get(i).setY((float)res.getContenu()[1][0]);
				pts.get(i).setZ((float)res.getContenu()[2][0]);
		}

		Sommet middle = method.GetMidSommet(pts);
		for(Sommet s : pts) {
			s.setX(s.getX()-middle.getX());
			s.setY(s.getY()-middle.getY());
		}
		for(Sommet s: pts) {
			s.setX(s.getX()+250);
			s.setY(s.getY()+250);
		}

		if(newObj.isFacesOnly()) {
			grahpicContext.setFill(defaultFaceColor);
			double alpha = 1;
			for (int i = 0; i < newObj.getFaces().size(); i++) {
				alpha = method.calculCouleur(newObj.getFaces().get(i),lumiere);

				if (Math.abs(alpha)<1) {
					grahpicContext.setFill(new Color(defaultFaceColor.getRed()*Math.abs(alpha), defaultFaceColor.getGreen()*Math.abs(alpha), defaultFaceColor.getBlue()*Math.abs(alpha), 1));
				}else {
					grahpicContext.setFill(defaultFaceColor);
				}
				grahpicContext.fillPolygon(newObj.getFaces().get(i).getAllX(),newObj.getFaces().get(i).getAllY(),newObj.getFaces().get(i).getNb_points());
			}
		}else if(newObj.isSegmentsOnly()) {
			for (int i = 0; i < newObj.getFaces().size(); i++) {
				grahpicContext.strokePolygon(newObj.getFaces().get(i).getAllX(),newObj.getFaces().get(i).getAllY(),newObj.getFaces().get(i).getNb_points());
			}
		}else {
			grahpicContext.setFill(defaultFaceColor);
			double alpha = 1;
			for (int i = 0; i < newObj.getFaces().size(); i++) {
				alpha = method.calculCouleur(newObj.getFaces().get(i), lumiere);
				
				if (Math.abs(alpha)<1) {
					grahpicContext.setFill(new Color(defaultFaceColor.getRed()*Math.abs(alpha), defaultFaceColor.getGreen()*Math.abs(alpha), defaultFaceColor.getBlue()*Math.abs(alpha), 1));
				}else {
					grahpicContext.setFill(defaultFaceColor);
				}
			}
			for (int i = 0; i < newObj.getFaces().size(); i++) {
				grahpicContext.fillPolygon(newObj.getFaces().get(i).getAllX(),newObj.getFaces().get(i).getAllY(),newObj.getFaces().get(i).getNb_points());
				grahpicContext.strokePolygon(newObj.getFaces().get(i).getAllX(),newObj.getFaces().get(i).getAllY(),newObj.getFaces().get(i).getNb_points());
			}
		}
	}

	/**
	 * updates the view
	 */
	@Override
	public void update(Subject subj, Object data) {
	}
}
