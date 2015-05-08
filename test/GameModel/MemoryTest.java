/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lorenz
 */
public class MemoryTest {
    
    public MemoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBox method, of class Memory.
     */
    @Test
    public void testAddBox() {
        Box newBox = null;
        Memory instance = new Memory();
        instance.addBox(newBox);

    }

    /**
     * Test of getBox method, of class Memory.
     */
    @Test
    public void testGetBox() {
        int index = 0;
        Memory instance = new Memory();
        Box result = instance.getBox(index);
        assertEquals(null, result);

    }

    /**
     * Test of getSize method, of class Memory.
     */
    @Test
    public void testGetSize() {
        Memory instance = new Memory();
        int result = instance.getSize();
        assertEquals(0, result);
    }

    /**
     * Test of isEmpty method, of class Memory.
     */
    @Test
    public void testIsEmpty() {
        Memory instance = new Memory();
        boolean result = instance.isEmpty();
        assertEquals(true, result);
    }

    /**
     * Test of clearAllBoxes method, of class Memory.
     */
    @Test
    public void testClearAllBoxes() {
        Memory instance = new Memory();
        instance.clearAllBoxes();
    }
    
}
