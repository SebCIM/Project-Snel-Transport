/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.User;

/**
 *
 * @author Z.Huraibi
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "snel-transport")
    private EntityManager em;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
    EntityManager testEm = emf.createEntityManager();
    
    private Environment env;

    @Override
    protected EntityManager getEntityManager() {
        if(getEnv() == null) {
            return em;
        }
        switch (getEnv()) {
            case DEV:
                return em;
            case TEST:
                return testEm;
            default:
                return em;
        }
    }
    
    public void setEnv(Environment env) {
        this.env = env;
    }
    public Environment getEnv() {
        return env;
    }
        
    @Override
    protected EntityManager getEntityManager(Environment env) {
        switch (env) {
            case DEV:
                return em;
            case TEST:
                return testEm;
            default:
                return em;
        }
    }

    public UserFacade() {
        super(User.class);
    }
    
    public List findWithName(String name) {
        return getEntityManager().createQuery(
            "SELECT u FROM User u WHERE u.name = :name ")
            .setParameter("name", name)
            .getResultList();
    }
}
