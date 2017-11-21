/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.xmlcontroller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import produto.Produto;

/**
 *
 * @author Vitor
 */
public class XMLControllerTest {
    private XMLController<Produto> xmlController;
    public XMLControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.xmlController = new XMLController<>();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toXML method, of class XMLController.
     */
    @Test
    public void testToXML() {
        Produto produto = new Produto("Teste", "Descrição", 2.5, true);
        System.out.println(this.xmlController.toXML(produto));
    }

    /**
     * Test of fromXML method, of class XMLController.
     */
    @Test
    public void testFromXML() {
        
    }
    
}
