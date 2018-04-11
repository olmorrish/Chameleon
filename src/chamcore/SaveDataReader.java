package chamcore;

/*
 * SaveDataReader is a file reader that contains implementations to help construct the CoreFilmList
 * It is utilized by CoreFilmList's primary constructor that is called on startup
 */
public class SaveDataReader {

	public SaveDataReader() {
		// TODO Auto-generated constructor stub
	}

	
	
	/*
	 * converts a FilmNode's string representation into an actual FilmNode
	 */
	public FilmNode buildFilmNode(String nodeStr) {
		//|T|Title|Y|2000|G|Genre1>|W|Writer|D|Director|A|Actor1>|O|0|F|AVI|L|
		//TODO: parsing
		FilmNode ret = new FilmNode();
		int bar;	//tracker index for '|' delimiters
		int arr;	//tracker index for '>' delimiters
		
		nodeStr = (nodeStr.substring(3));	//cut |T|
		bar = nodeStr.indexOf('|');
		ret.setTitle(nodeStr.substring(0, bar)); //gather title
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |Y|
		bar = nodeStr.indexOf('|');
		ret.setYear(nodeStr.substring(0, bar));	//gather year
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |G|
		while(nodeStr.indexOf('>') < nodeStr.indexOf('|')) {	//provided an arrow delimiter precedes a bar, we can cut a genre
			arr = nodeStr.indexOf('>');
			ret.addGenre(nodeStr.substring(0, arr));	//gather a genre
			nodeStr = nodeStr.substring(arr + 1);	//cut the now-read genre and it's '>' delimiter 
		}
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |W|
		bar = nodeStr.indexOf('|');
		ret.setWriter(nodeStr.substring(0, bar));	//gather writer
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |D|
		bar = nodeStr.indexOf('|');
		ret.setDirector(nodeStr.substring(0, bar));	//gather director
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |A|
		while(nodeStr.indexOf('>') < nodeStr.indexOf('|')) {	
			arr = nodeStr.indexOf('>');
			ret.addActor(nodeStr.substring(0, arr));	
			nodeStr = nodeStr.substring(arr + 1);	
		}
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |O|
		bar = nodeStr.indexOf('|');
		ret.setNumTimesOpened(Integer.parseInt(nodeStr.substring(0, bar)));	//gather open count
		
		nodeStr = nodeStr.substring(bar + 3);	//cut |F|
		bar = nodeStr.indexOf('|');
		ret.setFileFormat(nodeStr.substring(0, bar));	//gather file format
		
		//TODO: decrypt location from file representation
//		nodeStr = nodeStr.substring(bar + 3);	//cut |L|
//		bar = nodeStr.indexOf('|');
//		ret.setFileFormat(nodeStr.substring(0, bar));	//gather file format
		
		return ret;
	}
	
	
	
	
	
	
	/*
	 * read from a file
	 * https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
	 */
	
}
