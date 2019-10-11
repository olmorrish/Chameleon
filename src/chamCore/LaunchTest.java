package chamCore;
//import chamCore.SaveDataManager;;

public class LaunchTest {

	public static void main(String[] args) {
		
		FilmList core = new FilmList();
		Film node1 = new Film("The Thing", 1982);
		node1.director = "John Carpenter";
		node1.location = "C:\\Users\\olive\\Desktop\\ChameleonTempSave\\The Thing [1982].mkv";
		core.list.add(node1);

		//write the data
		SaveDataManager.saveFilmList(core, "C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		//now read the data 
		FilmList core2;
		core2 = SaveDataManager.loadFilmList("C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		core2.list.get(0).launch();

	}
}
