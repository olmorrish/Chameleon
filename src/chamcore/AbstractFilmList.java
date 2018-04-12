package chamCore;

/*
 * FilmList is the abstract superclass for data structures containing FilmNodes;
 * 
 * head, tail 
 * 
 */
public abstract class AbstractFilmList {

	public FilmNode head;
	public FilmNode tail;
	
	
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
	public void refactor() {
		//TODO
	}


	
	
	
	
}
