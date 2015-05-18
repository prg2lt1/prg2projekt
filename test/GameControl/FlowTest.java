/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControl;

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
public class FlowTest {

    public FlowTest() {
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
     * Test of setUserTurn method, of class Flow.
     */
    @Test
    public void testLoop() {
        Flow instance = new Flow();
        assertEquals(true, instance.isUserTurn());
    }

    /**
     * Test of setUserTurn method, of class Flow.
     */
    @Test
    public void testSetUserTurn() {
        Flow instance = new Flow();
        instance.setUserTurn();
        assertEquals(true, instance.isUserTurn());
    }

    /**
     * Test of setOpponentTurn method, of class Flow.
     */
    @Test
    public void testSetOpponentTurn() {
        Flow instance = new Flow();
        instance.setOpponentTurn();
        assertEquals(true, instance.isOpponentTurn());
    }

    /**
     * Test of setUserTurn method, of class Flow.
     */
    @Test
    public void testSetNotUserTurn() {
        Flow instance = new Flow();
        instance.setUserTurn();
        assertEquals(false, instance.isOpponentTurn());
    }

    /**
     * Test of setOpponentTurn method, of class Flow.
     */
    @Test
    public void testSetNotOpponentTurn() {
        Flow instance = new Flow();
        instance.setOpponentTurn();
        assertEquals(false, instance.isUserTurn());
    }

    /**
     * Test of setOpponentTurn method, of class Flow.
     */
    @Test
    public void testSetMultipleTurns() {
        Flow instance = new Flow();
        instance.setOpponentTurn();
        instance.setUserTurn();
        assertEquals(true, instance.isUserTurn());
        instance.setOpponentTurn();
        instance.setUserTurn();
        assertEquals(true, instance.isUserTurn());
    }

    /**
     * Test of setOpponentTurn method, of class Flow.
     */
    @Test
    public void testGameOver() {
        Flow instance = new Flow();
        instance.setGameOver();
        assertEquals(false, instance.flow.isAlive());
    }

}
