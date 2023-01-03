package projet.modele;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this class is made to open the Ply files and read their values.
 *
 */

public class PlyReader{
	/**
	 * the current 3d object
	 */
	ThreeDObject obj;
	/**
	 * error
	 */
	boolean error;

/**
 * returns the current 3d object 
 * @return the current 3d object
 */
	public ThreeDObject getObj() {
		return this.obj;
	}
	
/**
 * sets the current 3d object to a given one
 * @param obj the new 3d object
 */
	public void setObj(ThreeDObject obj) {
		this.obj = obj;
	}
	
/**
 * reads a ply file
 * @param file the file to read
 * @param obj the new 3d object
 */
	public PlyReader(File file, ThreeDObject obj){
		this.obj = obj;
		this.error = Read(file);
	}
	
/**
 * empty reader
 */
	public PlyReader(){
		this.error = Read(null);
	}
/**
 * gets if there's an error in the file
 * @return true if there's one, false otherwise
 */
	public boolean getError() {
		return error;
	}
/**
 * sets the error
 * @param error the detected error
 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * reads a given file and keep it's informations
	 * @param file the file to read
	 * @return true
	 */
	public boolean Read(File file) {
		List<Sommet> points;
		List<Face> faces = null;
		int nbPoints = 0;
		File myObj;
		try {
			if(file != null) {
				myObj = file;
			}else {
				myObj = new File("src/main/resources/empty.ply");
			}
			Scanner myReader = new Scanner(myObj);
			String data = myReader.nextLine();
			if (!data.equals("ply")) {
				myReader.close();
				return false;
			}
			while (!data.contains("vertex")) {
				data = myReader.nextLine();
			}
			nbPoints = Integer.parseInt(data.replaceAll("[^0-9]", ""));
			points = new ArrayList<>();
			while (!data.contains("face")) {
				data = myReader.nextLine();
			}

			faces = new ArrayList<>();

			while (!data.equals("end_header")) {
				data = myReader.nextLine();
			}
			for (int i = 0; i < nbPoints; i++) {
				data = myReader.nextLine();
				if (!(data.length()==0)) {
					points.add(toSommet(data));
				}else {
					i--;
				}
			}
			this.obj.setPoints(points);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				faces.add(toFace(data));
			}
			for (int i = 0; i < 5; i++) {
			}
			myReader.close();
			this.obj.setFaces(faces);
		} catch (Exception e) {
			System.out.println("error = "+e);
		}
		return true;
	}
	
/**
 * uses a string that contains vertex coordinates to create an actual vertex
 * @param line the string
 * @return the created vertex
 */
	public Sommet toSommet(String line) {
		Sommet res;
		String[] nums = line.split(" ");
		float pointX = Float.parseFloat(nums[0]);
		float pointY = Float.parseFloat(nums[1]);
		float pointZ = Float.parseFloat(nums[2]);
		if (nums.length > 3) {//on a des couleurs sur les points
			res = new Sommet(pointX,pointY,pointZ);
		}else {
			res = new Sommet(pointX,pointY,pointZ);
		}
		return res;
	}
	
/**
 * used a string that contains a face informations to create a face based on it
 * @param line the string
 * @return the created face
 */
	public Face toFace(String line) {
		Face res;
		String[] nums = line.split(" ");
		int nbp = Integer.parseInt(nums[0]);
		List<Sommet> tmp = new ArrayList<>();
		for (int i = 1; i < nbp+1; i++) {
			tmp.add(this.obj.getPoints().get(Integer.parseInt(nums[i])));
		}
		res = new Face(tmp);
		return res;
	}
}
