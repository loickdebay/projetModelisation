package projet.modele;
/**
 * 
 * this class consists in a way to keep the matrixes that we need for the calculations
 */
public enum GeometryAffine {
	/**
	 * creates a symmetry up to down
	 */
	
	symetrieX1(new Matrice(new double[][] {{1.0,0.0,0.0},
		                                   {0.0,-1.0,0.0},
							               {0.0,0.0,1.0}})),
	/**
	 * creates a symmetry down to up
	 */
	symetrieX2(new Matrice(new double[][] {{-1.0,0.0,0.0},
                                           {0.0,1.0,0.0},
                                           {0.0,0.0,1.0}})),
	/**
	 * creates a symmetry around the origin point
	 */
	symetrieOrigine(new Matrice(new double[][] {{-1.0,0.0,0.0},
		                                        {0.0,-1.0,0.0},
		                                        {0.0,0.0,1.0}})),
	/**
	 * rotates with a distance of 4 pi
	 */
	rotationPI4(new Matrice(new double[][] {{Math.sqrt(2)/2,-Math.sqrt(2)/2,0.0},
											{Math.sqrt(2)/2,Math.sqrt(2)/2,0.0},
											{0.0,0.0,1.0}})),
	/**
	 * rotates with a distance of 2 pi
	 */
	rotationPI2(new Matrice(new double[][] {{0.0,-1.0,0.0},
											{1.0,0.0,0.0},
											{0.0,0.0,1.0}})),
	/**
	 * used to rotate right
	 */
	rotationdroite(new Matrice(new double[][] {{Math.cos(Math.toRadians(10.0)),Math.sin(Math.toRadians(10.0)),0.0},
											  	 {-Math.sin(Math.toRadians(10.0)),Math.cos(Math.toRadians(10.0)),0.0},
											  	 {0.0,0.0,1.0}})),
	/**
	 * used to rotate left
	 */
	rotationgauche(new Matrice(new double[][] {{Math.cos(Math.toRadians(10.0)),-Math.sin(Math.toRadians(10.0)),0.0},
											   {Math.sin(Math.toRadians(10.0)),Math.cos(Math.toRadians(10.0)),0.0},
	  	 									   {0.0,0.0,1.0}})),
	/**
	 * used to rotate around the Y axis
	 */
	rotationY(new Matrice(new double[][] {{Math.cos(Math.toRadians(90.0)),0.0,Math.sin(Math.toRadians(90.0))},
		   									{0.0,1.0,0.0},
		   									{-Math.sin(Math.toRadians(90.0)),0.0,Math.cos(Math.toRadians(90.0))},})),
	/**
	 * used to rotate around the X axis
	 */
	rotationX(new Matrice(new double[][] {{1,0,0},
			{0.0,Math.cos(Math.toRadians(90.0)),-Math.sin(Math.toRadians(90.0))},
			{0,Math.sin(Math.toRadians(90.0)),Math.cos(Math.toRadians(90.0))},})),
	/**
	 * used to move right
	 */
	translationdroite(new Matrice(new double[][] {{1.0,0.0,20.0},
												      {0.0,1.0,0},
												      {0.0,0.0,1.0}})),
	/**
	 * used to move left
	 */
	
	translationgauche(new Matrice(new double[][] {{1.0,0.0,-20.0},
											   {0.0,1.0,0.0},
											   {0.0,0.0,1.0}})), 
	/**
	 * used to move up
	 */
	translationhaut(new Matrice(new double[][] {{1.0,0.0,0},
		   										{0.0,1.0,-20.0},
		   										{0.0,0.0,1.0}})), 
	/**
	 * used to move down
	 */
	translationbas(new Matrice(new double[][] {{1.0,0.0,0},
		  										{0.0,1.0,20.0},
		  										{0.0,0.0,1.0}})), 
	/**
	 * used to rotate the matrix
	 */
	homothetie(new Matrice(new double[][] {{1.0,0.0,0.0},
											 {0.0,1.0,0.0},
											 {0.0,0.0,1.0}})),
	/**
	 * used to crop the view
	 */
	cadrage1_2(new Matrice(new double[][] {{1.0,0.0,0.0},
										   {0.0,2.0,0.0},
										   {0.0,0.0,1.0}})),
	/**
	 * shear matrix
	 */
	shear180(new Matrice(new double[][] {{1.0,0.0,0.0},
										 {Math.tan(180),1.0,0.0},
		                                 {0.0,0.0,1.0}})),
	/**
	 * used the rotate 180 degres 
	 */
	rotationAngle1803D(new Matrice(new double[][] {{Math.cos(69.0),0.0,-Math.sin(69.0)},
												   {Math.sin(69.0),0.0,Math.cos(69.0)},
												   {0.0,0.0,1.0}}));
	/**
	 * the current matrix
	 */
	private Matrice matrice;
	
	/**
	 * simple constructor, simply initiates a matrix
	 * @param matrice matrix to set as the current one
	 */
	GeometryAffine(Matrice matrice) {
		this.matrice = matrice;
	}
	
/**
 * returns the current matrix
 * @return the current matrix
 */
	public Matrice getMatrice() {
		return matrice;
	}
	
/**
 * sets the current matrix to a given one
 * @param matrice the new matrix
 */
	public void setMatrice(Matrice matrice) {
		this.matrice = matrice;
	}
}
