package chamCore;

import java.util.ArrayList;

/*
 * FilmList is the abstract superclass for data structures containing FilmNodes;
 * head, tail 
 * 
 */
public abstract class AbstractFilmList {

	public ArrayList<FilmNode> list;
	
	public AbstractFilmList() {
		list = new ArrayList<FilmNode>();
	}
	
	/*
	 * refreshes the tree so that the FilmTreeNodes whose FilmData has the highest
	 * 	numTimesOpened is at the top of the tree
	 */
	public void refactor() {
		//TODO
	}


	
	
	
	
}
