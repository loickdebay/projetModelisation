package projet.modele;

import java.util.ArrayList;
import java.util.List;

/**
 * every method related to the Faces
 *
 */
public class Face {
	/**
	 * the amount of vertex
	 */
	private int nb_points;
	/**
	 * the vertex list
	 */
	private List<Sommet> pts;

	/**
	 * basic constructor
	 * @param listeSommet vertex list
	 */
	public Face(List<Sommet> listeSommet) {
		pts = new ArrayList<>();
		for (int i = 0; i < listeSommet.size(); i++) {
			pts.add(listeSommet.get(i));
		}
		nb_points = listeSommet.size();
	}

	/**
	 * basic constructor
	 * @param face face to use
	 */
	public Face(Face face) {
		this.pts = face.pts;
		this.nb_points = face.nb_points;
	}

	/**
	 * returns the vertex count
	 * @return the vertex count
	 */
	public int getNb_points() {
		return nb_points;
	}

	/**
	 * gets every vertex into a list
	 * @return the vertex list
	 */
	public List<Sommet> getPts() {
		return pts;
	}

	/**
	 * returns every X coordinate of each vertex
	 * @return a double table that contains the X coordinates
	 */
	public double[]getAllX(){
		double[] pointX = new double[nb_points];
		for (int i = 0; i < nb_points; i++) {
			pointX[i] = pts.get(i).getX();
		}
		return pointX;
	}

	/**
	 * returns every Y coordinate of each vertex
	 * @return a double table that contains the Y coordinates
	 */
	public double[]getAllY(){
		double[] pointY = new double[nb_points];
		for (int i = 0; i < nb_points; i++) {
			pointY[i] = pts.get(i).getY();
		}
		return pointY;
	}

	/**
	 * returns every Z coordinate of each vertex
	 * @return a double table that contains the Z coordinates
	 */
	public double[] getAllZ() {
		double[]pointZ = new double[nb_points];
		for (int i = 0; i < nb_points; i++) {
			pointZ[i] = pts.get(i).getZ();
		}
		return pointZ;
	}

	/**
	 * returns a copy of the current face
	 * @return a Face
	 */
	public Face getCopy() {
		return new Face(pts);
	}
	/**
	 * gets the center of a face
	 * @return the center vertex
	 */
	public Sommet getCentre() {
		double[]pointX = this.getAllX();
		float xmoy = 0;
		for (int i = 0; i < pointX.length; i++) {
			xmoy+=pointX[i];
		}
		xmoy = xmoy/pointX.length;

		double[]pointY = this.getAllY();
		float ymoy = 0;
		for (int i = 0; i < pointY.length; i++) {
			ymoy+=pointX[i];
		}
		ymoy = ymoy/pointY.length;

		double[]pointZ = this.getAllZ();
		float zmoy = 0;
		for (int i = 0; i < pointZ.length; i++) {
			zmoy+=pointX[i];
		}
		zmoy = zmoy/pointZ.length;
		return new Sommet(xmoy, ymoy, zmoy);
	}
	/**
	 * gets the vector standard
	 * @return the vector matrix
	 */
	public Matrice getVecNorm() {
		Matrice matriceU = new Matrice(new double[][] {{pts.get(nb_points-1).getX() - pts.get(nb_points-2).getX()},
			{pts.get(nb_points-1).getY() - pts.get(nb_points-2).getY()},
			{pts.get(nb_points-1).getZ() - pts.get(nb_points-2).getZ()}});
		Matrice matriceV = new Matrice(new double[][] {{pts.get(nb_points-2).getX() - pts.get(nb_points-3).getX()},
			{pts.get(nb_points-2).getY() - pts.get(nb_points-3).getY()},
			{pts.get(nb_points-2).getZ() - pts.get(nb_points-3).getZ()}});
		return matriceU.produitVectoriel(matriceV);

	}

	/**
	 * allows to print the informations of a face
	 */
	@Override
	public String toString() {
		return "Face [nb_points=" + nb_points + ", pts=" + pts + "]";
	}

	/**
	 * returns the hash value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nb_points;
		result = prime * result + ((pts == null) ? 0 : pts.hashCode());
		return result;
	}

	/**
	 * tests the equality between an object and the current Face
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Face other = (Face) obj;
		if (nb_points != other.nb_points)
			return false;
		if (pts == null) {
			if (other.pts != null)
				return false;
		} else if (!pts.equals(other.pts))
			return false;
		return true;
	}

	/**
	 * Sets X at a given value
	 * @param pointX the new value
	 * @param idx the index of the modified value
	 */
	public void setXAt(float pointX,int idx) {
		pts.get(idx).setX(pointX);
	}

	/**
	 * Sets Y at a given value
	 * @param pointY the new value
	 * @param idx the index of the modified value
	 */
	public void setYAt(float pointY,int idx) {
		pts.get(idx).setY(pointY);
	}

	/**
	 * Sets Z at a given value
	 * @param pointZ the new value
	 * @param idx the index of the modified value
	 */
	public void setZAt(float pointZ,int idx) {
		pts.get(idx).setZ(pointZ);
	}
}
