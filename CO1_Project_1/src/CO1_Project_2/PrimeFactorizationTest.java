package CO1_Project_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationTest {

    @Test
    public void testPrimeFactorizationOf2() {
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected, PrimeFactorization.factorize(2));
    }

    @Test
    public void testPrimeFactorizationOf3() {
        List<Integer> expected = Arrays.asList(3);
        assertEquals(expected, PrimeFactorization.factorize(3));
    }

    @Test
    public void testPrimeFactorizationOf4() {
        List<Integer> expected = Arrays.asList(2, 2);
        assertEquals(expected, PrimeFactorization.factorize(4));
    }

    @Test
    public void testPrimeFactorizationOf12() {
        List<Integer> expected = Arrays.asList(2, 2, 3);
        assertEquals(expected, PrimeFactorization.factorize(12));
    }

    @Test
    public void testPrimeFactorizationOf30() {
        List<Integer> expected = Arrays.asList(2, 3, 5);
        assertEquals(expected, PrimeFactorization.factorize(30));
    }
}

