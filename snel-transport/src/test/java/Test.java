
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Z.Huraibi
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
        EntityManager em = emf.createEntityManager();
        User u = new User();
        u.setName("Test Name");
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit();
        System.out.println("User saved successfully");
    }
}
