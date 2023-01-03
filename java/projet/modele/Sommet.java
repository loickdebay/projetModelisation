package projet.modele;

/** 
 * this class contains every vertex related method
 *
 */

public class Sommet {
	/**
	 * X coordinate
	 */
	private float pointX;
	/**
	 * Y coordinate
	 */
	private float pointY;
	/**
	 * Z coordinate
	 */
	private float pointZ;

	/**
	 * basic constructor for an vertex
	 * @param pointX X coordinate
	 * @param pointY Y coordinate
	 * @param pointZ Z coordinate
	 */	
	public Sommet(float pointX, float pointY, float pointZ) {
		this.pointX = pointX;
		this.pointY = pointY;
		this.pointZ = pointZ;
	}
/**
 * constructs a vertex from given coordinates
 * @param coordonne the given coordinates
 */
	public Sommet(float[] coordonne) {
		pointX = coordonne[0];
		pointY = coordonne[1];
		pointZ = coordonne[2];
	}
/**
 * constructs a vertex from another one
 * @param sommet the vertex to copy
 */
	public Sommet(Sommet sommet) {
		this.pointX = sommet.pointX;
		this.pointY = sommet.pointY;
		this.pointZ = sommet.pointZ;
	}
	
	/**
	 * returns a copy of the current vertex
	 * @return a copy of the current vertex
	 */
	public Sommet getCopy() {//TODO wip
		return new Sommet(pointX,pointY,pointZ);
	}

/**
 * allows to get a table that contains the vertex values
 * @return the vertex values
 */
	public float[] getValues() {
		float res[] = new float[3];
		res[0] = pointX;res[1] = pointY;res[2] = pointZ;
		return res;
	}
	/**
	 * allows to construct a matrix from the current vertex
	 * @return the matrix
	 */
	public Matrice getMatrice() {
		double[][] res = new double[3][1];
		res[0][0] = pointX;res[1][0] = pointY;res[2][0] = pointZ;
		return new Matrice(res);
	}
	/**
	 * prints the informations of a vertex
	 */
	@Override
	public String toString() {
		return "Sommet [x=" + pointX + ", y=" + pointY + ", z=" + pointZ + "]";
	}
	
/**
 * gets the X coordinate of the vertex
 * @return the X coordinate
 */
	public float getX() {
		return pointX;
	}
	
	/**
	 * gets the Y coordinate of the vertex
	 * @return the Y coordinate
	 */
	public float getY() {
		return pointY;
	}
	
	/**
	 * gets the Z coordinate of the vertex
	 * @return the Z coordinate
	 */
	public float getZ() {
		return pointZ;
	}
	
/**
 * sets the X coordinate of the vertex
 * @param pointX the new X 
 */
	public void setX(float pointX) {
		this.pointX = pointX;
	}
	
	/**
	 * sets the Y coordinate of the vertex
	 * @param pointY the new Y
	 */
	public void setY(float pointY) {
		this.pointY = pointY;
	}
	
	/**
	 * sets the Z coordinate of the vertex
	 * @param pointZ new Z coordinate
	 */
	public void setZ(float pointZ) {
		this.pointZ = pointZ;
	}
	
	/**
	 * returns the hash value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(pointX);
		result = prime * result + Float.floatToIntBits(pointY);
		result = prime * result + Float.floatToIntBits(pointZ);
		return result;
	}
	
/**
 * tests if a given object is equal to the current vertex
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sommet other = (Sommet) obj;
		if (Float.floatToIntBits(pointX) != Float.floatToIntBits(other.pointX))
			return false;
		if (Float.floatToIntBits(pointY) != Float.floatToIntBits(other.pointY))
			return false;
		if (Float.floatToIntBits(pointZ) != Float.floatToIntBits(other.pointZ))
			return false;
		return true;
	}
}
