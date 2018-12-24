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
	 * refreshes the list so that the FilmNodes with the highest
	 * 	numTimesOpened is at the front of the list
	 */
	public void refactor() {
		//TODO
	}


	
	
	
	
}
