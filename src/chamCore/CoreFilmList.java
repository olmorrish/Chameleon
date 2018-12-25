package chamCore;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * CoreFilmList is the singleton list that stores all loaded film data on startup
 * Utilizes reader to load the Core from a text file
 * The CoreFilmList may only be instantiated by using the file loading TODO: enforce
 */
@SuppressWarnings("serial")
public class CoreFilmList extends AbstractFilmList implements Serializable{

	public CoreFilmList() {
		list = new ArrayList<FilmNode>();
	}

	/*
	 * Constructor from file
	 */
//	public CoreFilmList() {
//		// TODO Auto-generated constructor stub
//	}

}
