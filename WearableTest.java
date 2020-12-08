

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WearableTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WearableTest {
    /**
     * Default constructor for test class WearableTest
     */
    public WearableTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    @Test
    public void testConStAndGet()
    {
        Wearable wearable1 = new Wearable(10, "A", 10.0, "head", "fitness", "Apple", "www", "location", "city1", "WA", "US");
        assertEquals("head", wearable1.getBodyLocation());
        assertEquals("fitness", wearable1.getCategory());
        assertEquals("city1", wearable1.getCity());
        assertEquals("Apple", wearable1.getCompany());
        assertEquals("US", wearable1.getCountry());
        assertEquals("location", wearable1.getMapLocation());
        assertEquals("A", wearable1.getName());
        assertEquals(10.0, wearable1.getPrice(), 0.1);
        assertEquals(10, wearable1.getRanking());
        assertEquals("WA", wearable1.getState());
        assertEquals("www", wearable1.getUrl());
        
    }
}

