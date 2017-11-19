/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers.webservice;

import java.util.ArrayList;
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
public class WebServiceHelperImplTest {
    WebServiceHelperImpl webHelper;
    public WebServiceHelperImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        webHelper = WebServiceHelperImpl.getInstance();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class WebServiceHelperImpl.
     */
    
    public void testGetInstance() {
        System.out.println("getInstance");
        WebServiceHelperImpl expResult = null;
        WebServiceHelperImpl result = WebServiceHelperImpl.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduto method, of class WebServiceHelperImpl.
     */
    
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto produto = null;
        WebServiceHelperImpl instance = null;
        instance.addProduto(produto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeProduto method, of class WebServiceHelperImpl.
     */
    
    public void testRemoveProduto() {
        System.out.println("removeProduto");
        Produto produto = null;
        WebServiceHelperImpl instance = null;
        instance.removeProduto(produto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of upadateProduto method, of class WebServiceHelperImpl.
     */
    
    public void testUpadateProduto() {
        System.out.println("upadateProduto");
        Produto produto = null;
        WebServiceHelperImpl instance = null;
        instance.upadateProduto(produto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdutoById method, of class WebServiceHelperImpl.
     */
    
    public void testGetProdutoById() {
        System.out.println("getProdutoById");
        long id = 0L;
        WebServiceHelperImpl instance = null;
        Produto expResult = null;
        Produto result = instance.getProdutoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preencherListaDeProdutos method, of class WebServiceHelperImpl.
     */
    @Test
    public void testPreencherListaDeProdutos() {
        webHelper.preencherListaDeProdutos();
    }

    /**
     * Test of getAllProdutos method, of class WebServiceHelperImpl.
     */
    
    public void testGetAllProdutos() {
        System.out.println("getAllProdutos");
        WebServiceHelperImpl instance = null;
        ArrayList<Produto> expResult = null;
        ArrayList<Produto> result = instance.getAllProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
