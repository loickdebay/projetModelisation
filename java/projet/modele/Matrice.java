package projet.modele;

/**
 * Matrix related methods
 * these are mostly used for the calculations
 *
 */
public class Matrice {
	/**
	 * the values of the matrix
	 */
	private double[][]contenu;
	/**
	 * the amount of rows
	 */
	private int row;
	/**
	 * the amount of columns
	 */
	private int column;
	
/**
 * simple constructor, creates a table with the specified amount of columns and rows
 * @param row amount of row in the matrix
 * @param column amount of columns in the matrix
 */
	public Matrice(int row, int column) {
		contenu = new double[row][column];
		this.row = row;
		this.column = column;
	}
	
/**
 * sets the class values from a given matrix 
 * @param tab the matrix to base the current one on
 */
	public Matrice(double[][] tab) {
		contenu = tab;
		this.row = tab.length;
		this.column = tab[0].length;
	}
	
/**
 * multiplies the current matrix with a given one
 * @param other the matrix to multiply the current one with
 * @return the result of the multiplication
 */
	public Matrice multiplication(Matrice other) {
		Matrice res = new Matrice(this.row, other.column);
		if(!verifMultiplication(other)) {
			return null;
		}
		for(int i=0;i<this.row;i++){    
			for(int j=0;j<other.column;j++){    
				res.contenu[i][j] = 0;      
				for(int k=0;k<this.column;k++)      
				{      
					res.contenu[i][j]+=this.contenu[i][k]*other.contenu[k][j];      
				}
			}
		}	
		return res;
	}
	/**
	 * adds a matrix to another
	 * @param other the matrix to add
	 * @return the result of the addition
	 */
	public Matrice addition(Matrice other) {
	Matrice res = new Matrice(this.row, this.column);
	if(!verifIdems(other)) {
		return null;
	}
	for(int i=0;i<this.row;i++){    
		for(int j=0;j<this.column;j++){    
			res.contenu[i][j] = this.contenu[i][j] + other.contenu[i][j];
			
		}
	}	
	return res;
}
	/**
	 * calculates the vector product from two matrixes
	 * @param other the second matrix
	 * @return the result of the product
	 */
	public Matrice produitVectoriel(Matrice other) {
		Matrice res = new Matrice(this.row, this.column);
		if(!verifIdems(other)) {
			return null;
		}
		res.contenu[0][0] = this.contenu[1][0]*other.contenu[2][0] - this.contenu[2][0]*other.contenu[1][0];
		res.contenu[1][0] = this.contenu[2][0]*other.contenu[0][0] - this.contenu[0][0]*other.contenu[2][0];
		res.contenu[2][0] = this.contenu[0][0]*other.contenu[1][0] - this.contenu[1][0]*other.contenu[0][0];
		return res;	
	}
	/**
	 * calculates the scalar product from two matrixes
	 * @param other the second matrix
	 * @return the result of the product
	 */
	public Matrice produitScalaire(Matrice other) {
		Matrice res = new Matrice(this.row, this.column);
		if(!verifIdems(other)) {
			return null;
		}
		res.contenu[0][0] = this.contenu[1][0]*other.contenu[2][0] - this.contenu[2][0]*other.contenu[1][0];
		res.contenu[1][0] = this.contenu[2][0]*other.contenu[0][0] - this.contenu[0][0]*other.contenu[2][0];
		res.contenu[2][0] = this.contenu[0][0]*other.contenu[1][0] - this.contenu[1][0]*other.contenu[0][0];
		return res;
	}
	/**
	 * gets the norm of a vector
	 * @return the result
	 */
	public double normeVecteur() {
		double res = 0;
		res = Math.pow(contenu[0][0], 2) + Math.pow(contenu[1][0], 2) + Math.pow(contenu[2][0], 2);
		res = Math.sqrt(res);
		return res;
	}
	

/**
 * checks if the size of the new matrix matches the one that we're supposed to get with the multiplication
 * @param other the matrix used to check
 * @return true if it matches, false otherwise
 */
	private boolean verifMultiplication(Matrice other) {
		if(this.contenu[0].length == other.contenu.length) {
			return true;
		}
		return false;
	}

	/**
	 * tests if both matrixes are able to get multiplied
	 * @param other the second matrix
	 * @return true if they are, false otherwise
	 */
	private boolean verifIdems(Matrice other) {//faut tester que les vecteurs soit tous les deux 3x1
		if(this.contenu[0].length == other.contenu[0].length && other.contenu[0].length == 1 && this.contenu.length == other.contenu.length && other.contenu.length == 3) {
			return true;
		}
		return false;
	}
	/**
	 * gets the values of a matrix
	 * @return the values table
	 */
	public double[][] getContenu() {
		return contenu;
	}
	
/**
 * sets the matrix to the given values
 * @param contenu the new values
 */
	public void setContenu(double[][] contenu) {
		this.contenu = contenu;
	}
	
/**
 * returns the amount of rows in the matrix
 * @return the row count
 */
	public int getRow() {
		return row;
	}
	
/**
 * sets the amount of rows in the matrix to a given number
 * @param row the new amount of rows
 */
	public void setRow(int row) {
		this.row = row;
	}
	
/**
 * returns the amount of columns in the matrix
 * @return the column count
 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * sets the amount of columns in the matrix to a given number
	 * @param column the new amount of columns
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
/**
 * prints the matrix
 */
	@Override
	public String toString() {
		String sommet = "";
		for(int i = 0; i<this.row; i++) {
			for(int j = 0; j<this.column; j++) {
				sommet = sommet + this.contenu[i][j] + ", ";
			}
		}
		return sommet.substring(0, sommet.length()-2);
	}
}