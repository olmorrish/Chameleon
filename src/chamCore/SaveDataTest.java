package chamCore;

public class SaveDataTest {
	
	public static void main(String[] args) {
		
		CoreFilmList core = new CoreFilmList();
		FilmNode node1 = new FilmNode("movie1", 1991);
		FilmNode node2 = new FilmNode("movie2", 2008);
		core.list.add(node1);
		core.list.add(node2);
		
		//write the data
		SaveDataManager rwSaver = new SaveDataManager();
		rwSaver.saveCoreFilmList(core, "C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		//now read the data 
		CoreFilmList core2;
		core2 = rwSaver.restoreCoreFilmList("C:\\Users\\olive\\Desktop\\ChameleonTempSave\\core.txt");
		
		System.out.println(core.list.get(0).getTitle());
		System.out.println(core2.list.get(0).getTitle());
		System.out.println(core.list.get(1).getTitle());
		System.out.println(core2.list.get(1).getTitle());
		
	}
}
