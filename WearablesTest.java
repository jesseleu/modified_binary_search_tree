

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WearablesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WearablesTest {
    Wearables test = new Wearables();
    /**
     * Default constructor for test class WearablesTest
     */
    public WearablesTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        test.readFromFile("test");
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
    public void testReadFileAndGetWearable()
    {
        assertTrue( test.readFromFile("test"));
        assertEquals(test.getWearableAtIndex(0).getName(), "name0");
        assertEquals(test.getWearableAtIndex(1).getName(), "name1");
    }

    @Test
    public void testGetPositionData()
    {
        assertEquals( test.getCoNamePositionData()[0],0);
        assertEquals( test.getCoNamePositionData()[4],4);
        assertEquals( test.getCoNamePositionData()[5],5);
        assertEquals( test.getCoNamePositionData()[9],9);
        assertEquals( test.getPricePositionData()[0],0);
        assertEquals( test.getPricePositionData()[1],4);
        assertEquals( test.getPricePositionData()[4],7);
        assertEquals( test.getPricePositionData()[5],8);
        assertEquals( test.getPricePositionData()[9],2);
        assertEquals( test.getRankingPositionData()[0],0);
        assertEquals( test.getRankingPositionData()[4],4);
        assertEquals( test.getRankingPositionData()[5],5);
        assertEquals( test.getRankingPositionData()[9],9);
    }
    
    @Test
    public void testSearchRangeAndGenerateCsv()
    {
        assertTrue(test.generateCsv(test.searchRange("compName0", "compName4"),"testCoNameoutName0-4"));
        assertTrue(test.generateCsv(test.searchRange(2, 8),"testRanking2-8out"));
        assertTrue(test.generateCsv(test.searchRange(1.0, 5.0),"testPriceout1.0-5.0"));
    }
    
}



