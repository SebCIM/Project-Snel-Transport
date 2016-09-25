/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.Environment;
import ejb.UserFacade;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yomac_000
 */
public class UserControllerTest {
    @EJB
    private UserFacade userFacade;
    private User user;
    
    public UserControllerTest() {
   
        
    }
    
    @BeforeClass
    public static void setUpClass() {       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        long id = 1;
        user = new User();
        user.setId(id);
        user.setName("JohnDoe");
        userFacade = new UserFacade();
        userFacade.setEnv(Environment.TEST);
        
        userFacade.create(user);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHelloMsg method, of class UserController.
     */
    @Test
    public void testGetHelloMsg() {
//        System.out.println("getHelloMsg");
//        UserController instance = new UserController();
//        String expResult = "";
//        String result = instance.getHelloMsg();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class UserController.
     */
    @Test
    public void testRegister() {
//        System.out.println("register");
//        String message = "";
//        UserController instance = new UserController();
//        String expResult = "";
//        String result = instance.register(message);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
