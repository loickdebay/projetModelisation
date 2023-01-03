package projet.modele;

import java.util.List;

/**
 * Class made for multiple controller related methods
 *
 */
public class ControllerMisc {
	
/**
 * Rotates a 3d model
 * @param pts every model vertex
 * @param left the direction of the rotation
 * @return the vertex list of the processed model
 */
	public List<Sommet> rotation(List<Sommet> pts, boolean left) {
		if(!left) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX(),pts.get(i).getY(),pts.get(i).getZ()}};
				Matrice matrice = new Matrice(contenu);
				pts.get(i).setX((float)matrice.multiplication(GeometryAffine.rotationdroite.getMatrice()).getContenu()[0][0]);
				pts.get(i).setY((float)matrice.multiplication(GeometryAffine.rotationdroite.getMatrice()).getContenu()[0][1]);
			}
		}else if(left) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX(),pts.get(i).getY(),pts.get(i).getZ()}};
				Matrice matrice = new Matrice(contenu);
				pts.get(i).setX((float)matrice.multiplication(GeometryAffine.rotationgauche.getMatrice()).getContenu()[0][0]);
				pts.get(i).setY((float)matrice.multiplication(GeometryAffine.rotationgauche.getMatrice()).getContenu()[0][1]);
			}
		}
		return pts;
	}
	
/**
 * allows to zoom on the model
 * @param pts every model vertex
 * @param moins the value we're zooming by
 * @return the vertex list of the zoomed render
 */
	public List<Sommet> zoom(List<Sommet> pts, boolean moins){
		if(!moins) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX(),pts.get(i).getY(),pts.get(i).getZ()}};
				Matrice matrice = new Matrice(contenu);
				pts.get(i).setX((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][0]*2);
				pts.get(i).setY((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][1]*2);
			}
		}else if(moins) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX(),pts.get(i).getY(),pts.get(i).getZ()}};
				Matrice matrice = new Matrice(contenu);
				pts.get(i).setX((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][0]/2);
				pts.get(i).setY((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][1]/2);
			}
		}
		return pts;
	}
	
/**
 * translates a 3d model to move it in any direction
 * @param pts every vertex of the figure
 * @param movement the direction of the movement 
 * @return the figure's vertex list after being moved
 */
	public List<Sommet> translation(List<Sommet> pts, int movement){
		if(movement == 0) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX()},
					{pts.get(i).getY()},
					{1.0}};
					Matrice matrice = new Matrice(contenu);
					Matrice res = new Matrice(GeometryAffine.translationhaut.getMatrice().multiplication(matrice).getContenu());
					pts.get(i).setX((float)res.getContenu()[0][0]);
					pts.get(i).setY((float)res.getContenu()[1][0]);
			}
		}else if(movement == 1) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX()},
					{pts.get(i).getY()},
					{1.0}};
					Matrice matrice = new Matrice(contenu);
					Matrice res = new Matrice(GeometryAffine.translationbas.getMatrice().multiplication(matrice).getContenu());
					pts.get(i).setX((float)res.getContenu()[0][0]);
					pts.get(i).setY((float)res.getContenu()[1][0]);
			}
		}else if(movement == 2) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX()},
					{pts.get(i).getY()},
					{1.0}};
					Matrice matrice = new Matrice(contenu);
					Matrice res = new Matrice(GeometryAffine.translationdroite.getMatrice().multiplication(matrice).getContenu());
					pts.get(i).setX((float)res.getContenu()[0][0]);
					pts.get(i).setY((float)res.getContenu()[1][0]);
			}
		}else if(movement == 3) {
			for (int i = 0; i < pts.size(); i++) {
				double[][] contenu = new double[][] {{pts.get(i).getX()},
					{pts.get(i).getY()},
					{1.0}};
					Matrice matrice = new Matrice(contenu);
					Matrice res = new Matrice(GeometryAffine.translationgauche.getMatrice().multiplication(matrice).getContenu());
					pts.get(i).setX((float)res.getContenu()[0][0]);
					pts.get(i).setY((float)res.getContenu()[1][0]);
			}
		}
		return pts;
	}
	
	/**
	 * gets the middle point of the model and use it to move the whole figure and be able to display it properly on the canvas
	 * @param sommets the vertex list
	 * @return the middle of the model
	 */
	public Sommet GetMidSommet(List<Sommet> sommets) {//pour avoir un affichage de depart correct
		float maxX=0;
		float maxY=0;
		float maxZ=0;
		List<Sommet> pts = sommets;
		for (int counterX = 0; counterX < pts.size(); counterX++)
		{
			if (pts.get(counterX).getX() > maxX)
			{
				maxX = pts.get(counterX).getX();
			}
		}
		for (int counterY = 0; counterY < pts.size(); counterY++)
		{
			if (pts.get(counterY).getY() > maxY)
			{
				maxY = pts.get(counterY).getY();
			}
		}
		for (int counterZ = 0; counterZ < pts.size(); counterZ++)
		{
			if (pts.get(counterZ).getZ() > maxZ)
			{
				maxZ = pts.get(counterZ).getZ();
			}
		}
		float minX=0;
		float minY=0;
		float minZ=0;
		for (int counterX = 0; counterX < pts.size(); counterX++)
		{
			if (pts.get(counterX).getX() < minX)
			{
				minX = pts.get(counterX).getX();
			}
		}
		for (int counterY = 0; counterY < pts.size(); counterY++)
		{
			if (pts.get(counterY).getY() < minY)
			{
				minY = pts.get(counterY).getY();
			}
		}
		for (int counterZ = 0; counterZ < pts.size(); counterZ++)
		{
			if (pts.get(counterZ).getZ() < minZ)
			{
				minZ = pts.get(counterZ).getZ();
			}
		}
		Sommet sommet = new Sommet((minX+maxX)/2,(minY+maxY)/2,(minZ+maxZ)/2);
		return sommet;
	}
	
	/**
	 * allows to center the model on the canvas
	 * @param sommets the model's vertexes
	 * @return the moved vertex list
	 */
	public List<Sommet> Centrage(List<Sommet> sommets) {
		List<Sommet> pts = sommets;
		Sommet middle = this.GetMidSommet(pts);
		for(Sommet s : pts) {
			s.setX(s.getX()-middle.getX());
			s.setY(s.getY()-middle.getY());
		}
		for(Sommet s: pts) {
			s.setX(s.getX()+250);
			s.setY(s.getY()+250);
		}
		return pts;
	}
	
	/**
	 * allows the first display to be shown properly
	 * @param obj the 3d object used
	 * @return the vertexes used to display
	 */
	public List<Sommet> MatriceModifier(ThreeDObject obj) {//pour avoir un affichage de depart correct
		List<Sommet> pts = obj.getPoints();
		Sommet zoom = AutoZoom(pts);
		for (int i = 0; i < pts.size(); i++) {
			double[][] contenu = new double[][] {{pts.get(i).getX(),pts.get(i).getY(),pts.get(i).getZ()}};
			Matrice matrice = new Matrice(contenu);
			matrice = matrice.multiplication(GeometryAffine.symetrieX1.getMatrice());
			pts.get(i).setX((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][0]*zoom.getX());
			pts.get(i).setY((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][1]*zoom.getY());
			pts.get(i).setZ((float)matrice.multiplication(GeometryAffine.homothetie.getMatrice()).getContenu()[0][2]*zoom.getZ());
		}
		return pts;
	}
	
	/**
	 * allows the first display to be zoomed properly on the model so it's not too small or too big for the canvas
	 * @param points the model's vertexes
	 * @return the scaled vertexes
	 */
	public static Sommet AutoZoom(List<Sommet> points) {
		float maxX=0;
		float maxY=0;
		float maxZ=0;
		List<Sommet> pts = points;
		for (int counterX = 0; counterX < pts.size(); counterX++)
		{
			if (pts.get(counterX).getX() > maxX)
			{
				maxX = pts.get(counterX).getX();
			}
		}
		for (int counterY = 0; counterY < pts.size(); counterY++)
		{
			if (pts.get(counterY).getY() > maxY)
			{
				maxY = pts.get(counterY).getY();
			}
		}
		for (int counterZ = 0; counterZ < pts.size(); counterZ++)
		{
			if (pts.get(counterZ).getZ() > maxZ)
			{
				maxZ = pts.get(counterZ).getZ();
			}
		}
		float minX=0;
		float minY=0;
		float minZ=0;
		for (int counterX = 0; counterX < pts.size(); counterX++)
		{
			if (pts.get(counterX).getX() < minX)
			{
				minX = pts.get(counterX).getX();
			}
		}
		for (int counterY = 0; counterY < pts.size(); counterY++)
		{
			if (pts.get(counterY).getY() < minY)
			{
				minY = pts.get(counterY).getY();
			}
		}
		for (int counterZ = 0; counterZ < pts.size(); counterZ++)
		{
			if (pts.get(counterZ).getZ() < minZ)
			{
				minZ = pts.get(counterZ).getZ();
			}
		}
		float pointX = 0;
		float pointY = 0;
		float pointZ = 0;
		if(maxX <= 0) {
			minX = Math.abs(minX);
			pointX=250/minX;
		}else {
			pointX=250/maxX;
		}
		if(maxY <= 0) {
			minY = Math.abs(minY);
			pointY=250/minY;
		}else {
			pointY=250/maxY;
		}
		if(maxZ <= 0) {
			minZ = Math.abs(minZ);
			pointZ=250/minZ;
		}else {
			pointZ=250/maxZ;
		}
		return new Sommet(pointX,pointY,pointZ);
	}
	/**
	 * gets the shadowing of a face from the light source
	 * @param face the face where we want to apply the shadow
	 * @param lumiere the light source
	 * @return the color value
	 */
	public double calculCouleur(Face face, Sommet lumiere) {
		double alpha = 0;
		Matrice matriceAddition = face.getVecNorm().addition(face.getCentre().getMatrice());
		Matrice pointLumiere = lumiere.getMatrice().addition(face.getCentre().getMatrice());
		Matrice matriceScalaire = matriceAddition.produitScalaire(pointLumiere);
		alpha = matriceScalaire.getContenu()[0][0] + matriceScalaire.getContenu()[1][0] + matriceScalaire.getContenu()[2][0];//〈u|v〉 = ‖u‖‖v‖ cos θ, je veux cos θ
		alpha = alpha/matriceAddition.normeVecteur()/pointLumiere.normeVecteur();
		return alpha;
	}
}
