package chamCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chamCore.Film.FileFormat;

public class FilmTests {
	
	@Test
	public void testContentEqualityMethodOnSingleNode() {
		Film node1 = new Film();
		assertTrue(node1.equalsContentOf(node1));
	}	
	
	@Test
	public void testContentEqualityMethodForEqualNodes() {
		Film node1 = new Film();
		Film node2 = new Film();
		
		assertTrue(node1.equalsContentOf(node2));
	}
	
	@Test
	public void testContentEqualityMethodForNonEqualNodes() {
		Film node1 = new Film();
		node1.title = "Something";
		Film node2 = new Film();
		node2.title = "Something Else";
		
		assertFalse(node1.equalsContentOf(node2));
	}	
	
	@Test
	public void testAllDefaultValuesAreCorrectViaManualAccess() {
		
		Film node = new Film();
		
		assertTrue(node.title.equals(""));
		assertTrue(node.year == 0);
		//assertTrue(node.getYearAsString().equals("0"));
		assertTrue(node.getGenres().size() == 0);
		
		assertTrue(node.director.equals(""));
		assertTrue(node.writer.equals(""));
		assertTrue(node.getActors().size() == 0);
		
		assertTrue(node.numTimesOpened == 0);
		assertTrue(node.getFileFormat() == FileFormat.NOFORMAT);
		assertTrue(node.location.equals("")); 
		assertTrue(node.coverLocation.equals("")); 
	}
	
	@Test
	public void testSearchForFilmTitle() {
		Film node = new Film("SomeTitle", 2000);
		assertTrue(node.contains("SomeTitle"));
	}
	
	@Test
	public void testSearchForYear() {
		Film node = new Film("SomeTitle", 2000);
		assertTrue(node.contains("2000"));
	}
	
	@Test
	public void testSearchForWrongYear() {
		Film node = new Film("SomeTitle", 2000);
		assertFalse(node.contains("2001"));
	}
	
	@Test
	public void testSearchForFilmTitleSubstring() {
		Film node = new Film("SomeTitle", 2000);
		assertTrue(node.contains("SomeTi"));
	}
	
	@Test
	public void testSearchForFilmTitleSubstringLowerCase() {
		Film node = new Film("SomeTitle", 2000);
		assertTrue(node.contains("sometitl"));
	}
	
	@Test
	public void testSearchForInfoPresentInMultipleFields() {
		Film node = new Film("007", 2007);
		assertTrue(node.contains("00"));
	}
	
	@Test
	public void testSearchForActor() {
		Film node = new Film("SomeTitle", 2000);
		node.addActor("John Smith");
		assertTrue(node.contains("Smith"));
	}
	
	@Test
	public void testSearchForGenre() {
		Film node = new Film("SomeTitle", 2000);
		node.addGenre("Horror");
		assertTrue(node.contains("Horror"));
	}
	
	@Test
	public void testSearchInAllFields() {
		Film node = new Film("SomeTitle", 2000);
		node.director = "John Smith";
		node.addActor("Jane Smith");
		node.addActor("Jane Doe");
		node.addActor("John Doe");
		node.addGenre("Horror");
		node.writer = "Charlie Kaufman";
		
		assertTrue(node.contains("John"));
		assertTrue(node.contains("doe"));
		assertTrue(node.contains("aufm"));
		assertFalse(node.contains("Nicholas"));
	}
	
	@Test
	public void testSearchDiscludesLocationReferences() {
		Film node = new Film("SomeTitle", 2000);
		node.location = "C:\\MyDocuments\\Movies";
		node.coverLocation = "C:\\MyDocuments\\MovieCovers";
		
		assertFalse(node.contains("MyDocuments"));
		assertFalse(node.contains("Movie"));
	}
	
	@Test
	public void testSearchDiscludesFileFormat() {
		Film node = new Film("SomeTitle", 2000);
		node.setFileFormat("MP4");
		
		assertFalse(node.contains("MP4"));
	}
}








