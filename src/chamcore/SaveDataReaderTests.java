package chamcore;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SaveDataReaderTests {

	@Test
	public void testDefaultNodeBuildsFromString() {
		String emptyTest = "|T||Y|0|G||W||D||A||O|0|F|NOFORMAT|L|";
		
		FilmNode nodeFromString = buildFilmNode(emptyTest);
    FilmNode standardNode = new FilmNode();

		assertEquals(nodeFromString, standardNode);
	}
  
  @Test
  public void testTitleOfNodeBuildsFromString() {
    String titleTest = "|T|TitleHere|Y|0|G||W||D||A||O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(titleTest);
    FilmNode standardNode = new FilmNode();
    standardNode.setTitle("TitleHere");
    
    assertEquals(nodeFromString, standardNode);
  }
  
  @Test
  public void testYearOfNodeBuildsFromString() {
    String yearTest = "|T||Y|2002|G||W||D||A||O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(yearTest);
    FilmNode standardNode = new FilmNode();
    standardNode.setTitle(2002);
    
    assertEquals(nodeFromString, standardNode);
  }  
  
  @Test
  public void testGrenresOfNodeBuildsFromString() {
    String genreTest = "|T||Y|0|G|Horror>Comedy>Horror-Comedy>|W||D||A||O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(genreTest);
    FilmNode standardNode = new FilmNode();
    standardNode.addGenre("Horror");
    standardNode.addGenre("Comedy");
    standardNode.addGenre("Horror-Comedy");
    
    assertEquals(nodeFromString, standardNode);
  }     
  
  @Test
  public void testWriterOfNodeBuildsFromString() {
    String writerTest = "|T||Y|0|G||W|Writer Name|D||A||O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(writerTest);
    FilmNode standardNode = new FilmNode();
    standardNode.setWriter("Writer Name");
    
    assertEquals(nodeFromString, standardNode);
  }    
  
  @Test
  public void testDirectorOfNodeBuildsFromString() {
    String directorTest = "|T||Y|0|G||W||D|Director Name|A||O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(directorTest);
    FilmNode standardNode = new FilmNode();
    standardNode.setDirector("Director Name");
    
    assertEquals(nodeFromString, standardNode);
  } 
  
  @Test
  public void testActorsOfNodeBuildsFromString() {
    String actorTest = "|T||Y|0|G||W||D||A|Bob Tim>Tim Bob>|O|0|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(actorTest);
    FilmNode standardNode = new FilmNode();
    standardNode.addActor("Bob Tim");
    standardNode.addActor("Tim Bob");
    
    assertEquals(nodeFromString, standardNode);
  }  
  
  @Test
  public void testOpenCountOfNodeBuildsFromString() {
    String openCountTest = "|T||Y|0|G||W||D||A||O|77|F|NOFORMAT|L|";
    
    FilmNode nodeFromString = buildFilmNode(openCountTest);
    FilmNode standardNode = new FilmNode();
    standardNode.setNumTimesOpened(77);
    
    assertEquals(nodeFromString, standardNode);
  }   
  
  // public void testFileFormatOfNodeBuildsFromString
  // public void testLocationOfNodeBuildsFromString
  
  
  
  
 
  
}
