package chamCore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueryFilmListTests {
	
	@Test
	public void testSingleNodeCopy() {
		CoreFilmList core = new CoreFilmList();
		FilmNode node = new FilmNode("SomeTitle", 2000);
		core.list.add(node);
		QueryFilmList query = new QueryFilmList(core, "SomeTitle");
		
		assertTrue(query.list.get(0).getTitle().equals("SomeTitle"));
		assertTrue(query.list.get(0).getYearAsString().equals("2000"));
	}
	
	@Test
	public void testQueryDiscludesIrrelevantFirstNode() {
		CoreFilmList core = new CoreFilmList();
		FilmNode node1 = new FilmNode("SomeTitle", 2000);
		FilmNode node2 = new FilmNode("SecondTitle", 2002);
		core.list.add(node1);
		core.list.add(node2);
		QueryFilmList query = new QueryFilmList(core, "2002");
		
		assertTrue(query.list.get(0).getTitle().equals("SecondTitle"));
	}
	
	@Test
	public void testQueryCopiesTwoNodes() {
		CoreFilmList core = new CoreFilmList();
		FilmNode node1 = new FilmNode("Title", 2000);
		FilmNode node2 = new FilmNode("Title 2", 2002);
		core.list.add(node1);
		core.list.add(node2);
		QueryFilmList query = new QueryFilmList(core, "Title");
		
		assertTrue(query.list.get(0).getTitle().equals("Title"));
		assertTrue(query.list.get(1).getTitle().equals("Title 2"));
	}
	
	@Test
	public void testQueryBuildForNoResults() {
		CoreFilmList core = new CoreFilmList();
		FilmNode node = new FilmNode("SomeTitle", 2000);
		core.list.add(node);
		QueryFilmList query = new QueryFilmList(core, "SomeOtherTitle");
		
		assertFalse(query.list.get(0).getTitle().equals("SomeTitle"));
		assertTrue(query.list.equals(null));
	}
	
	@Test
	public void testQueryBuildForEmptyCore() {
		CoreFilmList core = new CoreFilmList();
		QueryFilmList query = new QueryFilmList(core, "Anything");
		
		assertTrue(query.list.equals(null));
	}
	
}
