package chamCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * SaveDataReader is a file reader that contains implementations to help construct the CoreFilmList
 */
public class SaveDataManager {

	public SaveDataManager() {
		
	}
	
	/*
	 * @params the CoreFilmList and directory to save to
	 */
	public void saveCoreFilmList(FilmList coreToSave, String saveDirectory) {
		FileOutputStream writer = null;
		ObjectOutputStream objWriter = null;
		try {
			writer = new FileOutputStream(saveDirectory);
			objWriter = new ObjectOutputStream(writer);

			objWriter.writeObject(coreToSave.list);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("CoreFilmList save-state could not be located.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Object writing for CoreFilmList failed.");
		}
		finally {
			try {
				writer.close();
				objWriter.close();
			} catch(IOException e){
				e.printStackTrace();
				System.err.println("Error closing CoreFilmList saving streams.");
			}
		}
	}
	
	/*
	 * @param directory location of file of serialized core list
	 * @returns CoreFilmList instance to be used
	 */
	@SuppressWarnings("unchecked")
	public FilmList restoreCoreFilmList(String saveDirectory) {
		
		FilmList recovery = new FilmList();
		
		FileInputStream reader = null;
		ObjectInputStream objReader = null;
		try {
			reader = new FileInputStream(saveDirectory);
			objReader = new ObjectInputStream(reader);
			
			recovery.list = (ArrayList<FilmNode>) objReader.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("CoreFilmList save-state could not be located.");		
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Object reader setup for CoreFilmList recovery failed.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("CoreFilmList object definition could not be located.");
		} 
		finally {
			try {
				reader.close();
				objReader.close();
			} catch(IOException e){
				e.printStackTrace();
				System.err.println("Error closing CoreFilmList loading streams.");
			}
		}
		
		return recovery;
	}
}
