/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Order;
import model.User;
import org.json.JSONObject;

/**
 *
 * @author Z.Huraibi
 */
	
@Stateless
@ApplicationPath("/api")
@Path("orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController extends Application {
//    @PersistenceContext
//    private EntityManager entityManager;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport-test");
    EntityManager entityManager = emf.createEntityManager();
 
    
    
    @GET
    @Path("{id}")
    public Order getOrder(@PathParam("id") Long id) {
        return entityManager.find(Order.class, id);
    }
    
     @POST
    public String saveOrder(String data) {
         JSONObject request = new JSONObject(data);
         System.out.println(request.getString("name") + "  asd");
         Order orderToSave = new Order();
         orderToSave.setName(request.getString("name"));
         entityManager.persist(orderToSave);

//        if (order.getId() == null) {
//            Order orderToSave = new Order();
//            orderToSave.setName(order.getName());
//            entityManager.persist(order);
//        } else {
//            Order orderToUpdate = getOrder(order.getId());
//            orderToUpdate.setName(orderToUpdate.getName());
//            order = entityManager.merge(orderToUpdate);
//        }

        return data;
    }

}