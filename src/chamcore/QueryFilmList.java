package chamcore;

/*
 * QueryFilmList is the list structure generated by querying the Core list or another list of FilmNodes
 * it builds itself from another list, but returning results with specified parameters
 */
public class QueryFilmList extends AbstractFilmList {

	public QueryFilmList() {
		// TODO Auto-generated constructor stub
	}

	public QueryFilmList(FilmNode headNode) {
		super(headNode);
		// TODO Auto-generated constructor stub
	}

	/////////////////////////////////////////////////////////
	/// Search Methods
	/////////////////////////////////////////////////////////
	
	public FilmNode[] searchAll(String query) {
		return null; //TODO
	}
	
	/////////////////////////////////////////////////////////
	/// Organized Tree Representation Getters
	/////////////////////////////////////////////////////////	
	
	public FilmNode[] getAllNodesAlphebeticalByTitle() {
		return null; //TODO
	}
	
	public FilmNode[] getAllNodesChronological() {
		return null; //TODO
	}
	
	public FilmNode [] getAllNodesRandom() {
		return null; //TODO
	}
	
}
