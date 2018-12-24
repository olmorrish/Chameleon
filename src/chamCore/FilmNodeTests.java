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
}








