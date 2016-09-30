/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
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
    private User user;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
    
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
      
        EntityManager em = emf.createEntityManager();
        user = new User();
        user.setName("JohnDoe");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHelloMsg method, of class UserController.
     */
    @Test
    public void testGetHelloMsg() {

    }

    /**
     * Test of register method, of class UserController.
     */
    @Test
    public void testRegister() {
        
        JsonObject obj = Json.createObjectBuilder().add("name", "Peter")
                .add("environment", "TEST")
                .build();
        UserController instance = new UserController();
        String expResult = "{\"message\":\"Your account has been created.\"}";
      
        Response result = instance.register(obj);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        String name = "Peter";
        List findWithName = em.createQuery(
            "SELECT u FROM User u WHERE u.name = :name ")
            .setParameter("name", name)
            .getResultList();
        tx.commit();
        em.close();
        emf.close();

        User foundUser = new User();
        foundUser = (User) findWithName.get(0);
        assertEquals("Peter", foundUser.getName());  
        assertEquals(expResult, result.getEntity().toString());
       
    }
    
}
