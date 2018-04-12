package chamCore;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * SaveDataWriter is a file writer that contains implementations to save the current CoreFilmList of the program
 * Note that FilmNode provides a method toStringSaveFormat() to convert it into the appropriate save format.
 * 	As a result, SaveDataWriter is much simpler than its counterpart, SaveDataReader
 */
public class SaveDataWriter {

	public SaveDataWriter() {
		
	}
	
	/*
	 * Prints a node's data to a provided save file
	 * @Throws NullPointerException if the referenced save path is not an existing .txt file
	 */
	public void writeNewNode(FilmNode node, Path path) throws NullPointerException {
		
//		if(!Files.exists(path) || !path.endsWith(".txt")) {
//			throw new NullPointerException();
//		}
//		
//		else {
//			File file = path.toFile();
//			
//			String nodeStr = node.toStringSaveFormat();
//			Files.write(file, nodeStr, Charset.forName("UTF-8"));
//			
//			//print to end of file
//			
//		}
	}

	
	
}
