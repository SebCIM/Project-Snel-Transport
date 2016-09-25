/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;

/**
 *
 * @author Z.Huraibi
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "snel-transport")
    private EntityManager em;

    @PersistenceContext(unitName = "snel-transport-test")
    private EntityManager testEm;

    @Override
    protected EntityManager getEntityManager() {
        return em;
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
}
