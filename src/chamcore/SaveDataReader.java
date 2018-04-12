package chamcore;

/*
 * SaveDataReader is a file reader that contains implementations to help construct the CoreFilmList
 * It is utilized by CoreFilmList's primary constructor that is called on startup
 */
public class SaveDataReader {

	public SaveDataReader() {
		
	}
	
	/*
	 * converts a FilmNode's string representation into an actual FilmNode
	 * TODO: might be better to split()
	 */
	public FilmNode buildFilmNode(String nodeStr) {
		//|T|Title|Y|2000|G|Genre1>|W|Writer|D|Director|A|Actor1>|O|0|F|AVI|L|
		//TODO: parsing
	
		FilmNode ret = new FilmNode();
		
		//int barCount = numDelimiters(nodeStr, '|');
		String[] segmentData = nodeStr.split("[|]"); //brackets are required to ensure regex sees | as literal character
		
		ret.setTitle(segmentData[2]);
		ret.setYear(segmentData[4]);
		
		String[] genresParsed = segmentData[6].split(">");	//second parse later
		for(String gen : genresParsed) {
			ret.addGenre(gen);
		}
		
		ret.setWriter(segmentData[8]);
		ret.setDirector(segmentData[10]);
		
		String[] actorsParsed = segmentData[12].split(">");
		for(String act : actorsParsed) {
			ret.addActor(act);
		}
		
		ret.setNumTimesOpened(Integer.parseInt(segmentData[14]));
		ret.setFileFormat(segmentData[16]);
		ret.setLocation(segmentData[18]);
		
		return ret;
	}
	
	
	
	
	
	
	/*
	 * read from a file
	 * https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
	 */
	
}
