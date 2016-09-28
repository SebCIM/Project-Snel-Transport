/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import model.Article;
import org.json.JSONObject;

/**
 *
 * @author Z.Huraibi
 */
	
@Stateless
@ApplicationPath("/api")
@Path("articles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArticleController extends Application {
//    @PersistenceContext
//    private EntityManager entityManager;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("snel-transport");
    EntityManager entityManager = emf.createEntityManager();

    @GET
    @Path("{id}")
    public Article getArticle(@PathParam("id") Long id) {
        return entityManager.find(Article.class, id);
    }
    
     @POST
    public String saveArticle(String data) {
         JSONObject request = new JSONObject(data);
         System.out.println(request.getString("name") + "  asd");
         Article articleToSave = new Article();
         articleToSave.setName("hans");
         entityManager.persist(articleToSave);



        return data;
    }
}