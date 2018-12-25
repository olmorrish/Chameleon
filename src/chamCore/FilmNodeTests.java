package chamCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chamCore.FilmNode.FileFormat;

public class FilmNodeTests {
	
	@Test
	public void testContentEqualityMethodOnSingleNode() {
		FilmNode node1 = new FilmNode();
		assertTrue(node1.equalsContentOf(node1));
	}	
	
	@Test
	public void testContentEqualityMethodForEqualNodes() {
		FilmNode node1 = new FilmNode();
		FilmNode node2 = new FilmNode();
		
		assertTrue(node1.equalsContentOf(node2));
	}
	
	@Test
	public void testContentEqualityMethodForNonEqualNodes() {
		FilmNode node1 = new FilmNode();
		node1.setTitle("Something");
		FilmNode node2 = new FilmNode();
		node2.setTitle("Something Else");
		
		assertFalse(node1.equalsContentOf(node2));
	}	
	
	@Test
	public void testAllDefaultValuesAreCorrectViaManualAccess() {
		
		FilmNode node = new FilmNode();
		
		assertTrue(node.getTitle().equals(""));
		assertTrue(node.getYear() == 0);
		assertTrue(node.getYearAsString().equals("0"));
		assertTrue(node.getGenres().size() == 0);
		
		assertTrue(node.getDirector().equals(""));
		assertTrue(node.getWriter().equals(""));
		assertTrue(node.getActors().size() == 0);
		
		assertTrue(node.getNumTimesOpened() == 0);
		assertTrue(node.getFileFormat() == FileFormat.NOFORMAT);
		assertTrue(node.getLocation().equals("")); 
		assertTrue(node.getCoverLocation().equals("")); 
	}
	
	@Test
	public void testSearchForFilmTitle() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		assertTrue(node.contains("SomeTitle"));
	}
	
	@Test
	public void testSearchForYear() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		assertTrue(node.contains("2000"));
	}
	
	@Test
	public void testSearchForWrongYear() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		assertFalse(node.contains("2001"));
	}
	
	@Test
	public void testSearchForFilmTitleSubstring() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		assertTrue(node.contains("SomeTi"));
	}
	
	@Test
	public void testSearchForFilmTitleSubstringLowerCase() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		assertTrue(node.contains("sometitl"));
	}
	
	@Test
	public void testSearchForInfoPresentInMultipleFields() {
		FilmNode node = new FilmNode("007", 2007);
		assertTrue(node.contains("00"));
	}
	
	@Test
	public void testSearchForActor() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		node.addActor("John Smith");
		assertTrue(node.contains("Smith"));
	}
	
	@Test
	public void testSearchForGenre() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		node.addGenre("Horror");
		assertTrue(node.contains("Horror"));
	}
	
	@Test
	public void testSearchInAllFields() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		node.setDirector("John Smith");
		node.addActor("Jane Smith");
		node.addActor("Jane Doe");
		node.addActor("John Doe");
		node.addGenre("Horror");
		node.setWriter("Charlie Kaufman");
		
		assertTrue(node.contains("John"));
		assertTrue(node.contains("doe"));
		assertTrue(node.contains("aufm"));
		assertFalse(node.contains("Nicholas"));
	}
	
	@Test
	public void testSearchDiscludesLocationReferences() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		node.setLocation("C:\\MyDocuments\\Movies");
		node.setCoverLocation("C:\\MyDocuments\\MovieCovers");
		
		assertFalse(node.contains("MyDocuments"));
		assertFalse(node.contains("Movie"));
	}
	
	@Test
	public void testSearchDiscludesFileFormat() {
		FilmNode node = new FilmNode("SomeTitle", 2000);
		node.setFileFormat("MP4");
		
		assertFalse(node.contains("MP4"));
	}
}








