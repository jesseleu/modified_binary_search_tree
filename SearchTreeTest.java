

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SearchTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SearchTreeTest {
    /**
     * Default constructor for test class SearchTreeTest
     */
    public SearchTreeTest() {
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
    public void testAddAndGet()
    {
        SearchTree<Integer> searchTr1 = new SearchTree<Integer>();
        searchTr1.add(1, 1);
        searchTr1.add(2, 2);
        searchTr1.add(3, 3);
        searchTr1.add(1, 4);
        assertEquals(searchTr1.getSize(),4);
        assertEquals(searchTr1.getList(4)[0] ,1);
        assertEquals(searchTr1.getList(4)[1] , 4);
        assertEquals(searchTr1.getList(4)[2] , 2);
    }
}

