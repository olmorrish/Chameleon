package chamCore;

/*
 * QueryFilmList is the list structure generated by querying the Core list or another list of FilmNodes
 * it builds itself from another list, but returning results with specified parameters
 */
public class QueryFilmList extends AbstractFilmList {

	/*
	 * Empty constructor
	 */
	public QueryFilmList() {
		
	}

	/*
	 * Head node constructor
	 */
	public QueryFilmList(FilmNode headNode) {
		
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