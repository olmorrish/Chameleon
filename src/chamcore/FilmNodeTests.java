package chamcore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import chamcore.FilmNode.FileFormat;

public class FilmNodeTests {

	@Test
	public void testNodeNextStructure() {
		FilmNode node1 = new FilmNode();
		FilmNode node2 = new FilmNode();
		FilmNode node3 = new FilmNode();
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node1);
		
		assertTrue(node1.getNext().equalsContentOf(node2));
		assertTrue(node2.getNext().equalsContentOf(node3));
		assertTrue(node3.getNext().equalsContentOf(node1));
		
	}
	
	@Test
	public void testContentEqualityMethodOnSingleNode() {
		FilmNode node1 = new FilmNode();
		assertTrue(node1.equalsContentOf(node1));
	}	
	
	@Test
	public void testContentEqualityMethodForEqualNodes() {
		FilmNode node1 = new FilmNode();
		FilmNode node2 = new FilmNode();
		
		node1.setNext(node2);
		
		assertTrue(node1.equalsContentOf(node2));
	}
	
	@Test
	public void testContentEqualityMethodForNonEqualNodes() {
		FilmNode node1 = new FilmNode();
		node1.setTitle("Something");
		FilmNode node2 = new FilmNode();
		node2.setTitle("Something Else");
		
		node1.setNext(node2);
		
		assertFalse(node1.equalsContentOf(node2));
	}	
	
//	@Test
//	public void testCopyOfNodeDoesNotOverlapOriginalMemory() {
//		
//	}
	
	@Test
	public void testAllDefaultValuesAreCorrectViaManualAccess() {
		
		FilmNode node = new FilmNode();
		
		assertTrue(node.getNext() == null);
		assertTrue(node.getTitle().equals(""));
		assertTrue(node.getYear() == 0);
		assertTrue(node.getYearAsString().equals("0"));
		assertTrue(node.getGenres().size() == 0);
		
		assertTrue(node.getDirector().equals(""));
		assertTrue(node.getWriter().equals(""));
		assertTrue(node.getActors().size() == 0);
		
		assertTrue(node.getNumTimesOpened() == 0);
		assertTrue(node.getFileFormat() == FileFormat.NOFORMAT);
		assertTrue(node.getLocationAsString().equals("/")); //relative path

	}

	
	/////////////////////////////////////////////////////////
	/// toStringSaveFormat() tests
	/////////////////////////////////////////////////////////		
	
	@Test
	public void testBasicNodeToStringFormat() {
		
		FilmNode node = new FilmNode();
		node.setTitle("Title");
		node.setYear(2000);
		node.setDirector("Director");
		node.setWriter("Writer");
		node.setFileFormat("AVI");
		//location blank
		
		ArrayList<String> genres = new ArrayList<String>();
		genres.add("Genre1");
		node.setGenres(genres);
		
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Actor1");
		node.setActors(actors);
		
		String actual = node.toStringSaveFormat();
		String expected = "|T|Title|Y|2000|G|Genre1>|W|Writer|D|Director|A|Actor1>|O|0|F|AVI|L|";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testDefaultEmptyNodeToStringFormat() {
		
		FilmNode node = new FilmNode();
		String actual = node.toStringSaveFormat();
		String expected = "|T||Y|0|G||W||D||A||O|0|F|NOFORMAT|L|";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testMultipleGenresNodeToString() {
		
		FilmNode node = new FilmNode();
		
		ArrayList<String> genres = new ArrayList<String>();
		genres.add("Action");
		genres.add("Comedy");
		genres.add("Romance");
		
		node.setGenres(genres);
		
		String actual = node.toStringSaveFormat();
		String expected = "|T||Y|0|G|Action>Comedy>Romance>|W||D||A||O|0|F|NOFORMAT|L|";
		
		assertEquals(actual, expected);
	}

	
	@Test
	public void testMultipleActorsNodeToString() {
		
		FilmNode node = new FilmNode();
		
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Tom Cruise");
		actors.add("Johnny Depp");
		actors.add("Harrison Ford");
		
		node.setActors(actors);
		
		String actual = node.toStringSaveFormat();
		String expected = "|T||Y|0|G||W||D||A|Tom Cruise>Johnny Depp>Harrison Ford>|O|0|F|NOFORMAT|L|";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testCopiedBlankNodeHasSameToString() {
		FilmNode node1 = new FilmNode();
		FilmNode node2 = new FilmNode(node1);
		
		String n1Str = node1.toStringSaveFormat();
		String n2Str = node2.toStringSaveFormat();
		
		assertEquals(n1Str, n2Str);
		
	}
	
	@Test
	public void testCopiedNodeHasSameToString() {
		FilmNode node = new FilmNode();
		node.setTitle("Title");
		node.setYear(2000);
		node.setDirector("Director");
		node.setWriter("Writer");
		node.setFileFormat("AVI");
		//location blank
		
		ArrayList<String> genres = new ArrayList<String>();
		genres.add("Genre1");
		node.setGenres(genres);
		
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Actor1");
		node.setActors(actors);
		
		//now copy
		FilmNode nodeCopy = new FilmNode(node);
		
		String str = node.toStringSaveFormat();
		String copyStr = nodeCopy.toStringSaveFormat();
		
		assertEquals(str, copyStr);
		
	}	
}








