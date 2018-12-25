package chamCore;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * FilmNode Contains all abstracted information relating to a film. This class is removed from the usage of the 
 * video file itself; it simply contains information to be provided to actual implementation within Chameleon. 
 * 
 * FilmNode contains the following film information:
 * 		Title, Release Year. Genres, Writer, Director, Actors
 * Additionally, meta-data for file info is provided:
 * 		Number of times file has been opened, location in file system, and file format. 
 * 
 * Current supported file formats are AVI, FLV, WMV, MOV, and MP4. 
 * 
 * Getter and setter methods are provided for all data, including a reference for the "next" node in a list. 
 * Refer to AbstractFilmList for details on implementation.
 * 		FilmNode is not meant to be instantiated outside of a Chameleon list structure.
 */
@SuppressWarnings("serial")
public class FilmNode implements Serializable {

	/////////////////////////////////////////////////////////
	/// Instance Parameters
	/////////////////////////////////////////////////////////	
	
	public enum FileFormat{NOFORMAT, AVI, FLV, WMV, MOV, MP4}
	
	private String title;
	private int year;
	private ArrayList<String> genres;
	
	private String writer;
	private String director;
	private ArrayList<String> actors;
	
	//file data parameters
	private int numTimesOpened;
	private FileFormat format; 
	private String location;
	private String coverLocation;
	
	
	/////////////////////////////////////////////////////////
	/// Constructors
	/////////////////////////////////////////////////////////	
	
	/*
	 * Default constructor
	 */
	public FilmNode() {
		
		title = "";
		year = 0;
		genres = new ArrayList<String>();
		
		writer = "";
		director = "";
		actors = new ArrayList<String>(); //initialize empty string variable array
		
		numTimesOpened = 0;
		format = FileFormat.NOFORMAT;
		location = ("");
		coverLocation = ("");
			
	}
	
	/*
	 * Copy constructor
	 */
	public FilmNode(FilmNode f) {
		
		title = f.title;
		year = f.year;
		
		if(f.genres.size() == 0) {
			genres = new ArrayList<String>();	//blank array must be considered separately
		}
		else {
			genres = new ArrayList<String>();
			for(int i = 0; i<(f.genres.size()); i++) {
				genres.add(f.genres.get(i));	//if modifying, be sure to ADD, not direct access
			}
		}
		
		writer = f.writer;
		director = f.director;
		
		if(f.actors.size() == 0) {	
			actors = new ArrayList<String>();	//blank array must be considered separately
		}
		else {
			actors = new ArrayList<String>();
			for(int i = 0; i<(f.actors.size()); i++) {
				actors.add(f.actors.get(i));	//if modifying, be sure to ADD, not direct access
			}
		}
		
		numTimesOpened = f.numTimesOpened;
		format = f.format;
		location = f.location;
		coverLocation = f.coverLocation; 
		
	}	

	/*
	 * Film+Title Only Constructor
	 */
	public FilmNode(String ttl, int yr) {
		this();
		title = ttl;
		year = yr;
	}
	
	/*
	 * File location constructor
	 */
	public FilmNode(String loc) {
		this();
		File reference = new File(loc);		
		title = reference.getName();
		year = 0;
	}

	/////////////////////////////////////////////////////////
	/// Equality Checker, Ignores "next" Param
	/////////////////////////////////////////////////////////	
	
	/*
	 * Alternate equals comparator; ignores "next" parameter 
	 * compares content of the node only; this is a utility method to assist class testability
	 */
	public boolean equalsContentOf(FilmNode compare) {
		
		if(!(title.equals(compare.getTitle())))
			return false;
		if(year != compare.getYear())	
			return false;
		
		if(genres.size() == 0) {
			if(compare.getGenres().size() != 0)
				return false;
		}
		else {
			for(String genre : genres) {
				if(!compare.contains(genre))
					return false;
			}
		}
		
		if(!writer.equals(compare.getWriter()))
			return false;
		if(!director.equals(compare.getDirector()))
			return false;
		
		if(actors.size() == 0) {
			if(compare.getActors().size() != 0)
				return false;
		}
		else {
			for(String actor : actors) {
				if(!compare.contains(actor))
					return false;
			}
		}		
		
		if(numTimesOpened != compare.getNumTimesOpened())
			return false;
		if(format != compare.getFileFormat())
			return false;
		if(!location.equals(compare.getLocation()))
			return false;

		return true; //if all checks pass, true is returned instead of false
	}
	
	
	/////////////////////////////////////////////////////////
	/// Getters
	/////////////////////////////////////////////////////////
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getYearAsString() {
		return (Integer.toString(year));
	}
	
	public ArrayList<String> getGenres() {
		return genres;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getDirector() {
		return director;
	}
	
	public ArrayList<String> getActors() {
		return actors;
	}
	
	public int getNumTimesOpened() {
		return numTimesOpened;
	}
	
	public FileFormat getFileFormat() {
		return format;
	}
	
	public String getLocation() {
		return location;
	}

	public String getCoverLocation() {
		return coverLocation;
	}
	
	/////////////////////////////////////////////////////////
	/// Setters 
	/////////////////////////////////////////////////////////	
	
	public void setTitle(String ttl) {
		title = ttl;
	}
	
	public void setYear(int yr) {
		year = yr;
	}
	
	public void setYear(String yr) {
		year = Integer.parseInt(yr);
	}
	
	public void setGenres(ArrayList<String> gen) {
		for(int i = 0; i<gen.size(); i++) {
			genres.add(i, gen.get(i));
		}
	}
	
	public void setWriter(String wri) {
		writer = wri;
	}
	
	public void setDirector(String dir) {
		director = dir;
	}
	
	public void setActors(ArrayList<String> acts) {
		for(int i = 0; i<acts.size();i++) {
			actors.add(i, acts.get(i));
		}
	}
	
	public void setNumTimesOpened(int num) {
		numTimesOpened = num;
	}
	
	public void setFileFormat(String ext) {
		switch (ext) {
		case "AVI": format = FileFormat.AVI;
			break;
		case "FLV": format = FileFormat.FLV;
			break;
		case "MOV": format = FileFormat.MOV;
			break;
		case "MP4": format = FileFormat.MP4;
			break;
		case "WMV": format = FileFormat.WMV;
			break;
		default: format = FileFormat.NOFORMAT;
			break;
		}
	}
	
	public void setLocation(String loc) {
		location = loc;		
	}
	
	public void setCoverLocation(String loc) {
		coverLocation = loc;
	}
	
	/////////////////////////////////////////////////////////
	/// List Adders and Removers
	/////////////////////////////////////////////////////////	
	
	public void addGenre(String gen) {
		genres.add(gen);
	}
	
	public void addActor(String act) {
		actors.add(act);
	}
	
	public void removeGenre(String gen) {
		genres.remove(gen);
	}
	
	public void removeActor(String act) {
		actors.remove(act);
	}
	

	/////////////////////////////////////////////////////////
	/// Core Function Methods
	/////////////////////////////////////////////////////////	
	
	/*
	 * attempts to open the film associated with this node
	 * this should increment numTimesOened:int in the data of the film 
	 */
	public void launch() {
		
		try {
			Desktop.getDesktop().open(new File(location));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.err.println("Error finding file to open. Location error.");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error opening file.");
			return;
		}
		
		numTimesOpened++;	//only increments on successful open
       
	}
	
	/*
	 * Creates a string array of all user-search-able parameters to allow for easy text search
	 * 
	 */
	public ArrayList<String> toSearchableArray() {
		ArrayList<String> ret = new ArrayList<String>();
		
		ret.add(title);
		ret.add(Integer.toString(year));
		
		for(String genre : genres) {
			ret.add(genre);
		}
		
		ret.add(writer);
		ret.add(director);
		
		for(String actor : actors) {
			ret.add(actor);
		}
		
		//make each entry lowercase
		for(int i=0; i<ret.size(); i++) {
			ret.add(ret.get(i).toLowerCase());
		}
		
		for(int i=0; i<ret.size()/2; i++) {
			ret.remove(0);
		}
		
		return ret;
	}
	
	/*
	 * Searches to see if a query exists in the user-available data
	 */
	public boolean contains(String searchFor) {
		ArrayList<String> data = this.toSearchableArray();
		for(String part : data) {
			if (part.contains(searchFor)) {
				return true;
			}
		}
		
		return false; //TODO
	}


	
	
	
//	public boolean searchLiteral() {
//		numTimesOpened++;
//		return true; //TODO
//	}
	
}
