package demo;
import static org.junit.Assert.*;
import java.util.*;
import java.util.function.BiPredicate;
import org.junit.Test;
import static demo.ValidatorFactory.PieceType.*;
import static demo.ValidatorFactory.makeValidators;
import static demo.Coordinate.makeCoordinate;

public class ValidatorTestCases
{
	
	@Test
	public void validRookMove()
	{
		final List<BiPredicate<Coordinate, Coordinate>> rookValidators = 
				makeValidators(R);
		for (BiPredicate<Coordinate, Coordinate> p : rookValidators) {
			assertTrue(p.test(makeCoordinate(1, 1), makeCoordinate(1, 5)));
		}
	}

	@Test
	public void invalidKingMove()
	{
		final List<BiPredicate<Coordinate, Coordinate>> kingValidators = 
				makeValidators(K);
		boolean result = true;
		Iterator<BiPredicate<Coordinate, Coordinate>> iter = kingValidators.iterator();
		while (result && iter.hasNext()) {
			result = iter.next().test(makeCoordinate(1, 4), makeCoordinate(1, 7));
		}
		assertFalse(result);
	}
}
