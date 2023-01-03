package projet.vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 * class made to create an object that is used in the file list to show the details of it

 *
 */
public class Ply {
	/**
	 * the file used to create the object
	 */
	private File file;
	/**
	 * the name of the model
	 */
	private ObservableValue<String> name;
	/**
	 * the amount of faces in the model
	 */
	private ObservableValue<String> faces;
	/**
	 * the size of the model
	 */
	private ObservableValue<String> taille;
	/**
	 * the amount of vertexes in the model
	 */
	private ObservableValue<String> points;


	/**
	 * constructor using a file to get every detail from
	 * @param file the file 
	 * @throws IOException exception
	 */
	public Ply(File file) throws IOException {
		this.name=new SimpleStringProperty(file.getName());
		this.faces=new SimpleStringProperty(searchHeaderForFaces(file));
		this.taille=new SimpleStringProperty(getFileSize(file));
		this.points=new SimpleStringProperty(searchHeaderForPoints(file));
	}

	 /**
	  * returns the file's size in kilobytes in a string
	  * @param file the file
	  * @return the file's size
	  * @throws IOException exception
	  */
	public String getFileSize(File file) throws IOException {
		Path path = Paths.get(file.getPath());
		long bytes = Files.size(path);
		return(""+bytes/1024+" Kb");
	}
	/**
	 * scans the header to return the amount of faces the file has (works)
	 * @param file the file
	 * @return the amount of faces as a string 
	 * @throws IOException exception
	 */
	public String searchHeaderForFaces(File file) throws IOException {
		String line;
		String[] lineSplit = null;
		for(int cpt = 0;cpt<getLinesAmount(file);cpt++) {
			try (Stream<String> lines = Files.lines(Paths.get(file.getPath()))){
			line = lines.skip(cpt).findFirst().get();
			}
			if(line.startsWith("element face")){
				lineSplit = line.split(" ");
			}
		}
		return ""+lineSplit[lineSplit.length-1];
	}
	/**
	 * scans the header to return the amount of vertexes the file has (works)
	 * @param file the file
	 * @return the amount of vertexes as a string 
	 * @throws IOException exception
	 */
	public String searchHeaderForPoints(File file) throws IOException {
		String line;
		String[] lineSplit = null;
		for(int cpt = 0;cpt<getLinesAmount(file);cpt++) {
			try (Stream<String> lines = Files.lines(Paths.get(file.getPath()))){
			line = lines.skip(cpt).findFirst().get();
			}
			if(line.startsWith("element vertex")){
				lineSplit = line.split(" ");
			}
		}
		return ""+lineSplit[lineSplit.length-1];
		
	}
	/**
	 * gets the amount of lines in the header of a file (used to get short methods when searching the file)
	 * @param file the file
	 * @return the amount of lines in the header
	 * @throws IOException exception
	 */
	public int getLinesAmount (File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
		int lines = 0;
		while (!reader.readLine().equals("end_header")) {
			lines++;
		}
		reader.close();
		return lines;
	}
	/**
	 * gets the current file
	 * @return the current file
	 */
	public File getFile() {
		return file;
	}
/**
 * sets the current file to a given one
 * @param file the new file
 */
	public void setFile(File file) {
		this.file = file;
	}
/**
 * gets the name of the object
 * @return the name of the object
 */
	public ObservableValue<String> getName() {
		return name;
	}
/**
 * sets the name of the object
 * @param name the new name
 */
	public void setName(ObservableValue<String> name) {
		this.name = name;
	}
/**
 * gets the amount of faces the object has
 * @return the amount of faces
 */
	public ObservableValue<String> getFaces() {
		return faces;
	}
/**
 * gets the size of the object 
 * @return the size of the object
 */

	public ObservableValue<String> getTaille() {
		return taille;
	}
/**
 * gets the amount of vertexes the object has
 * @return the amount of vertexes
 */
	public ObservableValue<String> getPoints() {
		return points;
	}
	/**
	 * sets the amount of vertexes to a given one
	 * @param points the new amount of vertexes
	 */
	public void setPoints(ObservableValue<String> points) {
		this.points = points;
	}
	/**
	 * sets the amount of faces to a given one
	 * @param faces the new amount of faces
	 */
	public void setFaces(ObservableValue<String> faces) {
		this.faces = faces;
	}
	/**
	 * sets the size of the file to a given one
	 * @param taille the new size
	 */
	public void setTaille(ObservableValue<String> taille) {
		this.taille = taille;
	}

}
