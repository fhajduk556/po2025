import org.junit.Test;

import static org.junit.Assert.*;

public class CodingBatTest {
    CodingBat cb = new CodingBat();
    @Test
    public void lastDigit() {
        assertEquals(true, cb.lastDigit(1985, 5));
        assertEquals(true, cb.lastDigit(2025, 5));
        assertEquals(false, cb.lastDigit(33331, 3));
        assertEquals(true, cb.lastDigit(100, 0));
    }

    @Test
    public void or35() {
        assertEquals(true, cb.or35(15));
        assertEquals(true, cb.or35(33));
        assertEquals(false, cb.or35(11));
        assertEquals(false, cb.or35(13));
    }

    @Test
    public void countEvens() {
        assertEquals(1, cb.countEvens(new int[]{1,2}));
        assertEquals(1, cb.countEvens(new int[]{1,2,3}));
        assertEquals(2, cb.countEvens(new int[]{1,2,3,4}));
        assertEquals(2, cb.countEvens(new int[]{1,2,3,4,5}));
    }

    @Test
    public void firstHalf() {
        assertEquals("Hello", cb.firstHalf("HelloThere"));
        assertEquals("peace", cb.firstHalf("peacemaker"));
        assertEquals("abc", cb.firstHalf("abcdef"));
        assertEquals("kuku", cb.firstHalf("kukuryku"));
    }
}