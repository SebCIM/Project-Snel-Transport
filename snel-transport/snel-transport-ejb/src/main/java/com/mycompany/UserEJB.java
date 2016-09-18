/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import entities.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author yomac_000
 */
//I will delete this class, because I'm not gonna use it..
@Stateless
@LocalBean
public class UserEJB {

    @PersistenceContext
    EntityManager em;

    public void saveUser(User user) {
        em.merge(user);
    }

    public void delteUser(User user) {
        em.remove(user);
    }

    public List<User> getAll() {
        Query q = em.createQuery("SELECT user FROM User user");
        return (List<User>) q.getResultList();
    }

}
