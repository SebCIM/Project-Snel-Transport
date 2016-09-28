///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import ejb.Environment;
//import ejb.UserFacade;
//import java.util.List;
//import javax.ejb.EJB;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import model.User;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author yomac_000
// */
//public class UserControllerTest {
//    @EJB
//    private UserFacade userFacade;
//    private User user;
//    
//    public UserControllerTest() {
//        userFacade = new UserFacade();
//        userFacade.setEnv(Environment.TEST);
//        userFacade.emptyTable();
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {       
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {   
//    }
//    
//    @Before
//    public void setUp() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
//        EntityManager em = emf.createEntityManager();
//        user = new User();
//        user.setName("JohnDoe");
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.persist(user);
//        tx.commit();
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getHelloMsg method, of class UserController.
//     */
//    @Test
//    public void testGetHelloMsg() {
//        userFacade = new UserFacade();
//        userFacade.setEnv(Environment.TEST);
//        List findWithName = userFacade.findWithName("JohnDoe");
//        User foundUser = new User();
//        foundUser = (User) findWithName.get(0);
//        assertEquals("JohnDoe", foundUser.getName());  
//    }
//
//    /**
//     * Test of register method, of class UserController.
//     */
//    @Test
//    public void testRegister() {
//
//    }
//    
//}
