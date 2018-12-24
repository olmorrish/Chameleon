package chamCore;

public class LaunchTest {

	public static void main(String[] args) {
		
		CoreFilmList core = new CoreFilmList();
		FilmNode node1 = new FilmNode("The Thing", 1982);
		node1.setDirector("John Carpenter");
		node1.setLocation("C:\\Users\\olive\\Desktop\\ChameleonTempSave\\The Thing [1982].mkv");
		core.list.add(node1);

		
		//write the data
		SaveDataManager rwSaver = new SaveDataManager();
		rwSaver.saveCoreFilmList(core, "C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		//now read the data 
		CoreFilmList core2;
		core2 = rwSaver.restoreCoreFilmList("C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		core2.list.get(0).launch();

	}
	
}
