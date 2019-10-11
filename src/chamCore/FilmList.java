package chamCore;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * CoreFilmList is the singleton list that stores all loaded film data on startup
 * Utilizes reader to load the Core from a text file
 * The CoreFilmList may only be instantiated by using the file loading TODO: enforce
 */
@SuppressWarnings("serial")
public class FilmList implements Serializable{

	public ArrayList<Film> list;
	
	public FilmList() {
		list = new ArrayList<Film>();
	}
	
	/*
	 * Builds a "Query" FilmList by copying all nodes of the core list that contain the provided parameter
	 * This is the typical use case for Query List builds; a return for search function
	 */
	public FilmList(FilmList core, String searchParameter) {
		int len = core.list.size();
		for(int i=0; i<len; i++) {
			if(core.list.get(i).contains(searchParameter)) {	//TODO: contains() is not correct!
				list.add(new Film(core.list.get(i)));
			}
		}
	}
}
