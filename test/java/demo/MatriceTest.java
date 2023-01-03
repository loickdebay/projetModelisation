package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import projet.modele.GeometryAffine;
import projet.modele.Matrice;

/**
 * matrix tests
 *
 */
class MatriceTest {

	/**
	 * tests the multiplication between two 3x3 matrixes
	 */
	@Test
	void Matrice3x3et3x3() {
		double[][] contenuM = new double[][] {{1.0,1.0,1.0},
			{2.0,2.0,2.0},
			{3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM);
		Matrice matrice2 = new Matrice(contenuM);
		double[][] resultat = new double[][] {{6.0,6.0,6.0},
			{12.0,12.0,12.0},
			{18.0,18.0,18.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(matrice2).toString());
	}

	/**
	 * tests the multiplication between a 4x3 and a 3x5 matrix
	 */
	@Test
	void Matrice4x3et3x5() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
			{2.0,2.0,2.0},
			{3.0,3.0,3.0},
			{4.0,4.0,4.0}};
		double[][] contenuM2 = new double[][] {{1.0,1.0,1.0,1.0,1.0},
			{2.0,2.0,2.0,2.0,2.0},
			{3.0,3.0,3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		Matrice matrice2 = new Matrice(contenuM2);
		double[][] resultat = new double[][] {{6.0,6.0,6.0,6.0,6.0},
			{12.0,12.0,12.0,12.0,12.0},
			{18.0,18.0,18.0,18.0,18.0},
			{24.0,24.0,24.0,24.0,24.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(matrice2).toString());
	}
	
	/**
	 * tests the vector product for 3x1
	 */
	@Test
	void ProduitVectoriel3x1() {
		double[][] contenu1 = new double[][] {{1.0},
			{2.0},
			{3.0}};
		Matrice matrice1 = new Matrice(contenu1);
		double[][] contenu2 = new double[][] {{1.0},
			{2.0},
			{3.0}};
		Matrice matrice2 = new Matrice(contenu2);
		double[][] resultat = new double[][] {{0.0},
			{0.0},
			{0.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.produitVectoriel(matrice2).toString());
		

		contenu2 = new double[][] {{8.0},
			{2.0},
			{-6.0}};
		matrice2 = new Matrice(contenu2);
		resultat = new double[][] {{-18.0},
			{30.0},
			{-14.0}};
		resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.produitVectoriel(matrice2).toString());
	}
	
	/**
	 * tests the matrix movement to the right
	 */
	@Test
	void MatriceTranslationDroite() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,21.0},
											  {2.0,2.0,42.0},
											  {3.0,3.0,63.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.translationdroite.getMatrice()).toString());
	}
	/**
	 * tests the matrix movement to the left
	 */
	@Test
	void MatriceTranslationGauche() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,-19.0},
											  {2.0,2.0,-38.0},
											  {3.0,3.0,-57.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.translationgauche.getMatrice()).toString());
	}
	/**
	 * tests the matrix movement upward
	 */
	@Test
	void MatriceTranslationHaut() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,-19.0},
											  {2.0,2.0,-38.0},
											  {3.0,3.0,-57.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.translationhaut.getMatrice()).toString());
	}
	/**
	 * tests the matrix movement downward
	 */
	@Test
	void MatriceTranslationBas() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,21.0},
											  {2.0,2.0,42.0},
											  {3.0,3.0,63.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.translationbas.getMatrice()).toString());
	}
	/**
	 * tests the matrix symmetry from up to down
	 */
	@Test
	void MatriceSymetrieX1() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,-1.0,1.0},
											  {2.0,-2.0,2.0},
											  {3.0,-3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.symetrieX1.getMatrice()).toString());
	}
	/**
	 * tests the matrix symmetry from down to up
	 */
	@Test
	void MatriceSymetrieX2() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{-1.0,1.0,1.0},
											  {-2.0,2.0,2.0},
											  {-3.0,3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.symetrieX2.getMatrice()).toString());
	}
	/**
	 * tests the matrix symmetry from the origin
	 */
	@Test
	void MatriceSymetrieOrigine() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{-1.0,-1.0,1.0},
											  {-2.0,-2.0,2.0},
											  {-3.0,-3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.symetrieOrigine.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation with 4 pi distance
	 */
	@Test
	void MatriceRotationPI4() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.4142135623730951,0.0,1.0},
											  {2.8284271247461903,0.0,2.0},
											  {4.242640687119286,0.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationPI4.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation with 2 pi distance
	 */
	@Test
	void MatriceRotationPI2() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,-1.0,1.0},
											  {2.0,-2.0,2.0},
											  {3.0,-3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationPI2.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation to the right
	 */
	@Test
	void MatriceRotationDroite() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{0.8111595753452777,1.1584559306791384,1.0},
											  {1.6223191506905554,2.316911861358277,2.0},
											  {2.433478726035833,3.475367792037415,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationdroite.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation to the left
	 */
	@Test
	void MatriceRotationGauche() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.1584559306791384,0.8111595753452777,1.0},
											  {2.316911861358277,1.6223191506905554,2.0},
											  {3.475367792037415,2.433478726035833,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationgauche.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation around the y axis
	 */
	@Test
	void MatriceRotationY() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{-0.9999999999999999,1.0,1.0},
											  {-1.9999999999999998,2.0,2.0},
											  {-3.0,3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationY.getMatrice()).toString());
	}
	/**
	 * tests the matrix rotation around the x axis
	 */
	@Test
	void MatriceRotationX() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,-0.9999999999999999},
											  {2.0,2.0,-1.9999999999999998},
											  {3.0,3.0,-3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationX.getMatrice()).toString());
	}
	
	
	/**
	 * tests the matrix rotations
	 */
	@Test
	void MatriceHomothetie() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,1.0,1.0},
											  {2.0,2.0,2.0},
											  {3.0,3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.homothetie.getMatrice()).toString());
	}
	/**
	 * tests to crop a matrix
	 */
	@Test
	void MatriceCadrage1_2() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{1.0,2.0,1.0},
											  {2.0,4.0,2.0},
											  {3.0,6.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.cadrage1_2.getMatrice()).toString());
	}
	/**
	 * tests to stretch a matrix 
	 */
	@Test
	void MatriceShear180() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{2.3386902103511544,1.0,1.0},
											  {4.677380420702309,2.0,2.0},
											  {7.016070631053463,3.0,3.0}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.shear180.getMatrice()).toString());
	}
	/**
	 * tests the rotation at 180 degrees of a matrix
	 */
	@Test
	void MatriceRotationAngle1803D() {
		double[][] contenuM1 = new double[][] {{1.0,1.0,1.0},
											   {2.0,2.0,2.0},
											   {3.0,3.0,3.0}};
		Matrice matrice1 = new Matrice(contenuM1);
		
		double[][] resultat = new double[][] {{0.8786055659390843,0.0,2.108175193505459},
											  {1.7572111318781687,0.0,4.216350387010918},
											  {2.635816697817253,0.0,6.324525580516377}};
		Matrice resM = new Matrice(resultat);
		assertEquals(resM.toString(),matrice1.multiplication(GeometryAffine.rotationAngle1803D.getMatrice()).toString());
	}
}
