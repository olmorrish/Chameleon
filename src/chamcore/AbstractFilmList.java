package chamcore;

/*
 * FilmList is the abstract superclass for data structures containing FilmNodes;
 */
public abstract class AbstractFilmList {

	public FilmNode head;
	public FilmNode tail;
	
	/*
	 * Empty constructor
	 */
	public AbstractFilmList() {
		head = null;
		tail = head;
	}
	
	/*
	 * Head node constructor
	 */
	public AbstractFilmList(FilmNode headNode) {
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


	
	
	
	
}
