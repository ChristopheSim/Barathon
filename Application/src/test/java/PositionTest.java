import org.junit.Assert.*;
import org.junit.*;


public class PositionTest {

	@Test
	public void TestIsEqual() {

		Position p = new Position(42.6, 63.5);
		Position q = new Position(21.3, 78.1124);

		assertFalse(p.isEqual(q));
		assertFalse(q.isEqual(p));

		assertTrue(p.isEqual(new Position(42.6, 63.5)));
		assertFalse(p.isEqual(new Position(42.6, 0.0)));
		assertFalse(p.isEqual(new Position(0.0, 63.5)));
		assertFalse(p.isEqual(new Position(0.0, 0.0)));

		assertTrue(q.isEqual(new Position(21.3, 78.1124)));
		assertFalse(q.isEqual(new Position(21.3, 0.0)));
		assertFalse(q.isEqual(new Position(0.0, 78.1124)));
		assertFalse(q.isEqual(new Position(0.0, 0.0)));
	}
}
