package chamCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilmListTests {
	
	@Test
	public void testSingleNodeCopy() {
		FilmList core = new FilmList();
		Film node = new Film("SomeTitle", 2000);
		core.list.add(node);
		FilmList query = new FilmList(core, "SomeTitle");
		
		assertTrue(query.list.get(0).title.equals("SomeTitle"));
		assertTrue(query.list.get(0).year == 2000);		
	}
	
	@Test
	public void testQueryDiscludesIrrelevantFirstNode() {
		FilmList core = new FilmList();
		Film node1 = new Film("SomeTitle", 2000);
		Film node2 = new Film("SecondTitle", 2002);
		core.list.add(node1);
		core.list.add(node2);
		FilmList query = new FilmList(core, "2002");
		
		assertTrue(query.list.get(0).title.equals("SecondTitle"));
	}
	
	@Test
	public void testQueryCopiesTwoNodes() {
		FilmList core = new FilmList();
		Film node1 = new Film("Title", 2000);
		Film node2 = new Film("Title 2", 2002);
		core.list.add(node1);
		core.list.add(node2);
		FilmList query = new FilmList(core, "Title");
		
		assertTrue(query.list.get(0).title.equals("Title"));
		assertTrue(query.list.get(1).title.equals("Title 2"));
	}
	
	@Test
	public void testQueryBuildForNoResults() {
		FilmList core = new FilmList();
		Film node = new Film("SomeTitle", 2000);
		core.list.add(node);
		FilmList query = new FilmList(core, "SomeOtherTitle");
		
		assertFalse(query.list.get(0).title.equals("SomeTitle"));
		assertTrue(query.list.equals(null));
	}
	
	@Test
	public void testQueryBuildForEmptyCore() {
		FilmList core = new FilmList();
		FilmList query = new FilmList(core, "Anything");
		
		assertTrue(query.list.equals(null));
	}
	
}
