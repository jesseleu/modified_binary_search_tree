
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BSTTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BSTTest {
    /**
     * Default constructor for test class BSTTest
     */
    public BSTTest() {
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
        BST<Integer> searchTr1 = new BST<Integer>();
        searchTr1.add(1, 1);
        searchTr1.add(2, 2);
        searchTr1.add(3, 3);
        searchTr1.add(1, 4);
        assertEquals(searchTr1.getSize(),4);
        assertEquals(searchTr1.getList(4)[0] , 4);
        assertEquals(searchTr1.getList(4)[1] , 1);
        assertEquals(searchTr1.getList(4)[2] , 2);
    }

    @Test
    public void testIsBalanced()
    {
        BST<Integer> bST1 = new BST<Integer>();
        assertTrue( bST1.isBalanced());
        bST1.add(10, 10);
        assertTrue( bST1.isBalanced());
        bST1.add(5, 5);
        assertTrue( bST1.isBalanced());
        bST1.add(3, 3);
        //
        assertFalse( bST1.isBalanced());
        bST1.add(11, 11);
        assertTrue( bST1.isBalanced());
        bST1.add(12, 12);
        assertTrue( bST1.isBalanced());
        bST1.add(13, 13);
        //
        assertFalse( bST1.isBalanced());
        bST1.add(11, 11);
        assertTrue( bST1.isBalanced());        
    }
    
    @Test
    public void testBalanceTree()
    {
        BST<Integer> bST1 = new BST<Integer>();
        assertTrue( bST1.isBalanced());
        bST1.add(10, 10);
        assertTrue( bST1.isBalanced());
        bST1.add(5, 5);
        assertTrue( bST1.isBalanced());
        bST1.add(3, 3);
        assertFalse( bST1.isBalanced());
        //balance
        bST1.balanceTree();
        
        assertTrue( bST1.isBalanced());
        bST1.add(11, 11);
        assertTrue( bST1.isBalanced());
        bST1.add(12, 12);
        assertFalse( bST1.isBalanced());
        bST1.add(13, 13);
        assertFalse( bST1.isBalanced()); 
        //balance
        bST1.balanceTree();
        assertTrue( bST1.isBalanced());
    }
}



