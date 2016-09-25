/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
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
public class UserFacadeTest {
    
    public UserFacadeTest() {
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
     * Test of create method, of class UserFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        User entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UserFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        User entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UserFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        User entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UserFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        User expResult = null;
        User result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class UserFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        List<User> expResult = null;
        List<User> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class UserFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnv method, of class UserFacade.
     */
    @Test
    public void testSetEnv() throws Exception {
        System.out.println("setEnv");
        Environment env = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        instance.setEnv(env);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnv method, of class UserFacade.
     */
    @Test
    public void testGetEnv() throws Exception {
        System.out.println("getEnv");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserFacade instance = (UserFacade)container.getContext().lookup("java:global/classes/UserFacade");
        Environment expResult = null;
        Environment result = instance.getEnv();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
