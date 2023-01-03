package projet.modele;

import java.util.ArrayList;
import java.util.List;
import projet.utils.Subject;

/**
 * creates a 3d object
 *
 */
public class ThreeDObject extends Subject{
	/**
	 * vertex list
	 */
	private List<Sommet> points = new ArrayList<>();
	/**
	 * color table
	 */
	private float[] colors = null;
	//private Face[] faces = null;
	/**
	 * faces list
	 */
	private List<Face> faces = new ArrayList<>();
	/**
	 * test value for a button
	 */
	private boolean facesOnly = false;
	/**
	 * test value for a button
	 */
	private boolean segmentsOnly = false;
	/**
	 * index 
	 */
	int idx = -1;
	/**
	 * new controllermisc object
	 */
	private ControllerMisc cMisc = new ControllerMisc();
	
	/**
	 * shows if the model is shown only by the faces
	 * @return true if it is, false otherwise
	 */
	public boolean isFacesOnly() {
		return facesOnly;
	}
	/**
	 * sets the faces only value to a given boolean
	 * @param facesOnly the given boolean
	 */
	public void setFacesOnly(boolean facesOnly) {
		this.facesOnly = facesOnly;
	}
	/**
	 * shows if the model is shown only by the segments
	 * @return true if it is, false otherwise
	 */
	public boolean isSegmentsOnly() {
		return segmentsOnly;
	}
	/**
	 * sets the segments only value to a given boolean
	 * @param segmentsOnly the given boolean
	 */
	public void setSegmentsOnly(boolean segmentsOnly) {
		this.segmentsOnly = segmentsOnly;
	}
	
/**
 * creates a 3d object
 * @param points vertexes of the object
 * @param colors colors of the object
 * @param faces faces of the object
 */
	public ThreeDObject(List<Sommet> points, float[] colors, List<Face> faces) {
		this.points = points;
		this.colors = colors;
		this.faces = faces;
	}
	
/**
 * creates a 3d object from a given one
 * @param obj the given object
 */
	public ThreeDObject(ThreeDObject obj) {
		this.points = new ArrayList<>();
		this.faces = new ArrayList<>();
		for (int i = 0; i < obj.points.size(); i++) {
			this.points.add(obj.points.get(i).getCopy());
		}
		for (int i = 0; i < obj.faces.size(); i++) {
			this.faces.add(obj.faces.get(i).getCopy());
		}
	}
	
/**
 * gets the vertexes from the object
 * @return a list that contains every vertex 
 */
	public List<Sommet> getPoints() {
		return points;
	}
	
/**
 * sets every vertex of the object from a given list
 * @param points the vertex list
 */
	public void setPoints(List<Sommet> points) {
		this.points = points;
		if(this.points != null && this.faces != null) {
			this.notifyObservers();
		}
	}

/**
 * sets the current object vertexes to a given list
 * @param points the new vertex list
 */
	public void setPointsNoNotify(List<Sommet> points) {
		this.points = points;
	}
	
/**
 * gets the colors of the object
 * @return a float table of the RGB values
 */
	public float[] getColors() {
		return colors;
	}
	
/**
 * sets the object colors to the given RGB values
 * @param colors the RGB values table
 */
	public void setColors(float[] colors) {
		this.colors = colors;
		this.notifyObservers();
	}
	
/**
 * gets the List of every faces in the object
 * @return the object faces list
 */
	public List<Face> getFaces() {
		return faces;
	}
	
/**
 * sets the object faces to a given list
 * @param faces the new face list
 */
	public void setFaces(List<Face> faces) {
		this.faces = faces;
		if(this.points != null && this.faces != null) {
			this.notifyObservers();
		}
	}
	/**
	 * rotates the 3d object to the right
	 * @param degres the degrees of the rotation
	 */
	public void rotationDroite(double degres) {
		for (int i = 0; i < points.size(); i++) {
            double[][] contenu = new double[][] {{points.get(i).getX(),points.get(i).getY(),points.get(i).getZ()}};
            Matrice matrice = new Matrice(contenu);
            points.get(i).setX((float)matrice.multiplication(new Matrice(new double[][] {{Math.cos(Math.toRadians(degres)),Math.sin(Math.toRadians(degres)),0.0},
			  	 {-Math.sin(Math.toRadians(degres)),Math.cos(Math.toRadians(degres)),0.0},
			  	 {0.0,0.0,1.0}})).getContenu()[0][0]);
            points.get(i).setY((float)matrice.multiplication(new Matrice(new double[][] {{Math.cos(Math.toRadians(degres)),Math.sin(Math.toRadians(degres)),0.0},
			  	 {-Math.sin(Math.toRadians(degres)),Math.cos(Math.toRadians(degres)),0.0},
			  	 {0.0,0.0,1.0}})).getContenu()[0][1]);
        }
		points = cMisc.Centrage(points);
		this.notifyObservers();
	}

/**
 * gets a new 3d object based on the current one
 * @return the new object
 */
	public ThreeDObject getCopy() {
		List<Face> newFaces = new ArrayList<>();
		List<Sommet> tmp =  new ArrayList<>();
		for (int i = 0; i < this.getFaces().size(); i++) {
			for (int j = 0; j < 3; j++) {
				tmp.add(this.getFaces().get(i).getPts().get(j).getCopy());
			}
			newFaces.add(new Face(tmp));
			tmp.removeAll(tmp);
		}
		
		List<Sommet> newPoints = new ArrayList<>();
		for (int i = 0; i < newFaces.size(); i++) {
			for (int j = 0; j < 3; j++) {
				try {
				newPoints.add(newFaces.get(i).getPts().get(j));
				}catch(Exception e) {
					
				}
			}
		}
		ThreeDObject newObj = new ThreeDObject(newPoints,null,newFaces);
		newObj.setSegmentsOnly(this.segmentsOnly);
		newObj.setFacesOnly(this.facesOnly);
		return newObj;
	}
}
