/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.StringReader;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;
//import org.json.JSONObject;
import javax.json.*;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Z.Huraibi
 */
@ApplicationPath("/api")
@Path("/auth")
public class UserController extends Application {
    
    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloMsg(){
        
        return "test";
    }

    public JsonObject user(String name){
        
        return Json.createObjectBuilder().add("name", name).build();
    }
    /**
     *
     * @param message
     * @return 
     */
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(JsonObject data) {

        System.out.println("json obj " + data);
        
        // Register user
        User user = new User();
        user.setName(data.getString("name"));
        String dbName = "snel-transport";
        
        if(data.containsKey("environment")) {
            System.out.println("yes1");
            if(data.getString("environment").equals("TEST") ){
                System.out.println("yes1");
                dbName = "snel-transport-test";
            }
        }
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(dbName);
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        em.close();
        emf.close();
        
         JsonObject obj = Json.createObjectBuilder().add("message", "Your account has been created.").build();
       
        return Response.status(Response.Status.CREATED).entity(obj).build();
//        return "Your account has been created.";
    }

}
