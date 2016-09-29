/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Z.Huraibi
 */
public class UserControllerTest {
    
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
        
        System.out.println("register");
        String data = "{'name' : 'Peter', 'environment' : 'TEST'}";
        UserController instance = new UserController();
        String expResult = "Your account has been created.";
        String result = instance.register(data);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        em.persist(user);
        String name = "Peter";
        List findWithName = em.createQuery(
            "SELECT u FROM User u WHERE u.name = :name ")
            .setParameter("name", name)
            .getResultList();
        tx.commit();
        em.close();
        emf.close();

        User foundUser = new User();
        System.out.println("list " + findWithName);
        foundUser = (User) findWithName.get(0);
        assertEquals("Peter", foundUser.getName());  
        
        assertEquals(expResult, result);
    }
    
}
