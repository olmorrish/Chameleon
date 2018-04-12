package chamCore;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class SaveDataReaderTests {

	//declared to be accessible
	SaveDataReader reader;
	
	@Before	//reminder: runs once for all tests
	public void setUp() {
		reader = new SaveDataReader(); //initialize the reader
	}
	
	
	/////////////////////////////////////////////////////////
	/// Node-Building Tests
	/////////////////////////////////////////////////////////	
	
	@Test
	public void testDefaultNodeBuildsFromString() {
		String emptyTest = "|T||Y|0|G||W||D||A||O|0|F|NOFORMAT|L|\\|C|\\|";
		
		FilmNode nodeFromString = reader.buildFilmNode(emptyTest);
		FilmNode standardNode = new FilmNode();
		
		//TODO: remove the lazy print debug below when released
		System.out.println("Actual\n" + nodeFromString.toStringSaveFormat());		
		System.out.println("Expected\n" + "|T||Y|0|G||W||D||A||O|0|F|NOFORMAT|L|\\|C|\\|");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testTitleOfNodeBuildsFromString() {
		String titleTest = "|T|TitleHere|Y|0|G||W||D||A||O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(titleTest);
		FilmNode standardNode = new FilmNode();
		standardNode.setTitle("TitleHere");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testYearOfNodeBuildsFromString() {
		String yearTest = "|T||Y|2002|G||W||D||A||O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(yearTest);
		FilmNode standardNode = new FilmNode();
		standardNode.setYear(2002);

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testGrenresOfNodeBuildsFromString() {
		String genreTest = "|T||Y|0|G|Horror>Comedy>Horror-Comedy>|W||D||A||O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(genreTest);
		FilmNode standardNode = new FilmNode();
		standardNode.addGenre("Horror");
		standardNode.addGenre("Comedy");
		standardNode.addGenre("Horror-Comedy");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testWriterOfNodeBuildsFromString() {
		String writerTest = "|T||Y|0|G||W|Writer Name|D||A||O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(writerTest);
		FilmNode standardNode = new FilmNode();
		standardNode.setWriter("Writer Name");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testDirectorOfNodeBuildsFromString() {
		String directorTest = "|T||Y|0|G||W||D|Director Name|A||O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(directorTest);
		FilmNode standardNode = new FilmNode();
		standardNode.setDirector("Director Name");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testActorsOfNodeBuildsFromString() {
		String actorTest = "|T||Y|0|G||W||D||A|Bob Tim>Tim Bob>|O|0|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(actorTest);
		FilmNode standardNode = new FilmNode();
		standardNode.addActor("Bob Tim");
		standardNode.addActor("Tim Bob");

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	@Test
	public void testOpenCountOfNodeBuildsFromString() {
		String openCountTest = "|T||Y|0|G||W||D||A||O|77|F|NOFORMAT|L|\\|C|\\|";

		FilmNode nodeFromString = reader.buildFilmNode(openCountTest);
		FilmNode standardNode = new FilmNode();
		standardNode.setNumTimesOpened(77);

		assertTrue(nodeFromString.equalsContentOf(standardNode));
	}

	// public void testFileFormatOfNodeBuildsFromString
	// public void testLocationOfNodeBuildsFromString

}
