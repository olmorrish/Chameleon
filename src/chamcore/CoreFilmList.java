package chamcore;

/*
 * CoreFilmList is the singleton list that stores all loaded film data on startup
 * Utilizes reader to load the Core from a text file
 * The CoreFilmList may only be instantiated by using the file loading TODO: enforce
 */
public class CoreFilmList extends AbstractFilmList {

	public CoreFilmList() {
		// TODO Auto-generated constructor stub
	}

	public CoreFilmList(FilmNode headNode) {
		super(headNode);
		// TODO Auto-generated constructor stub
	}

}
