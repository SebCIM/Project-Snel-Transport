/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import model.Order;
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
public class OrderControllerTest {
    private Order order;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
    
    public OrderControllerTest() {        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query q = em.createNativeQuery("DELETE FROM public.\"Order\" ");
        q.executeUpdate();
        tx.commit();
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
        order = new Order();
        order.setName("Fietsbel");
        order.setPrice(24.99);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(order);
        tx.commit();
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addOrder method, of class OrderController.
     */
    @Test
    public void testAddOrder() {
        JsonObject obj = Json.createObjectBuilder().
                add("name", "Keyboard").
                add("customerId", 1).
                add("status", 1).
                add("price", "12.99").
                add("environment", "TEST").
                build();
        OrderController instance = new OrderController();
        String expResult = "{\"message\":\"Your order has been created.\","
                + "\"id\":2,"
                + "\"name\":\"Keyboard\""
                + "}";
      
        Response result = instance.addOrder(obj);
        
        JsonReader jsonReader = Json.createReader(new StringReader(result.getEntity().toString()));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();

        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        int id = object.getInt("id");
        List findWithName = em.createQuery(
            "SELECT u FROM Order u WHERE u.id = :id ")
            .setParameter("id", id)
            .getResultList();
        tx.commit();
        em.close();
        emf.close();

        Order foundOrder = new Order();
        foundOrder = (Order) findWithName.get(0);
        assertEquals("Keyboard", foundOrder.getName());  
        assertEquals(expResult, result.getEntity().toString());
    }
    
}
