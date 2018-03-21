package chamcore;
/*
 * FilmNodePath is the data structure containing all FilmNodes;
 * It is designed to be optimized for faster searching of all categories within any FilmData
 */
public class FilmList {

	public FilmNode head;
	public FilmNode tail;
	
	/*
	 * Empty constructor
	 */
	public FilmList() {
		head = null;
		tail = head;
	}
	
	/*
	 * Head node constructor
	 */
	public FilmList(FilmNode headNode) {
		head = headNode;
		tail = head;
	}
	
	
	/////////////////////////////////////////////////////////
	/// Organizational Methods
	/////////////////////////////////////////////////////////	
	
	public void append(FilmNode node) {
		if(head == null) {
			head = node;
			tail = head;
		}
		else {
		tail.setNext(node);
		tail = tail.getNext();
		}
	}
	
	/*
	 * refreshes the tree so that the FilmTreeNodes whose FilmData has the highest
	 * 	numTimesOpened is at the top of the tree
	 */
	public void refactorPath() {
		//TODO
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
