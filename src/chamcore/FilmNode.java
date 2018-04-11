package chamcore;

import java.io.File; //TODO: reference info @ https:docs.oracle.com/javase/7/docs/api/java/io/File.html
import java.util.ArrayList;

/*
 * TODO: Path is a locator, File is the reference;may require rewriting segments
 * TODO: implement cover image reference
 */

/*
 * FilmNode Contains all abstracted information relating to a film or movie This class is removed from the usage of the file 
 * itself; it simply contains information to be provided to actual implementation within Chameleon. 
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
public class FilmNode {

	/////////////////////////////////////////////////////////
	/// Instance Parameters
	/////////////////////////////////////////////////////////	
	
	public enum FileFormat{NOFORMAT, AVI, FLV, WMV, MOV, MP4}
	private FilmNode next;
	
	private String title;
	private int year;
	private ArrayList<String> genres;
	
	private String writer;
	private String director;
	private ArrayList<String> actors;
	
	//file data parameters
	private int numTimesOpened;
	private FileFormat format; 
	private File location;
	//TODO: cover image reference to be added
	
	
	/////////////////////////////////////////////////////////
	/// Constructors
	/////////////////////////////////////////////////////////	
	
	/*
	 * Default constructor
	 */
	public FilmNode() {
		next = null;
		
		title = "";
		year = 0;
		genres = new ArrayList<String>();
		
		writer = "";
		director = "";
		actors = new ArrayList<String>(); //initialize empty string variable array
		
		numTimesOpened = 0;
		format = FileFormat.NOFORMAT;
		location = new File("");
			
	}
	
	/*
	 * Copy constructor
	 */
	public FilmNode(FilmNode f) {
		next = null;
		
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
		
	}	

	/*
	 * Film+Title Only Constructor
	 */
	public FilmNode(String ttl, int yr) {
		this();
		title = ttl;
		year = yr;
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
	/// Linked List Get/Set
	/////////////////////////////////////////////////////////	
	
	public FilmNode getNext() {
		return next;
	}
	
	public void setNext(FilmNode node) {
		next = node;
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
	
	public File getLocation() {
		return location;
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
	
	public void setLocation(File loc) {location = loc;}
	
	
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
		//TODO: need some API to launch, depends on file format
	}
	
	/*
	 * toString() method for Saving to external files
	 * for unpacker/loader see File-Load constructor
	 */
	public String toStringSaveFormat() {
		//Note that 
		
		String titleFrag = "|T|" + title; 
		String yearFrag = "|Y|" + (Integer.toString(year));
		
		String genreFrag = "|G|";
		for (String genre : genres) {
			genreFrag += (genre + '>');
		}
		
		String writerFrag = "|W|" + writer;
		String directorFrag = "|D|" + director;
		
		String actorFrag = "|A|";
		for (String actor : actors) {
			actorFrag += (actor + '>');
		}
		
		String openFrag = "|O|" + (Integer.toString(numTimesOpened));
		String formatFrag = "|F|" + format.toString();
		String locationFrag = "|L|" + (location.toString());
		
		String ret = titleFrag + yearFrag + genreFrag + writerFrag;
		ret = ret + directorFrag + actorFrag + openFrag + formatFrag + locationFrag;
		return ret;
	}
	
	/*
	 * Creates a string array of all user-search-able parameters to allow for easy text search
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
