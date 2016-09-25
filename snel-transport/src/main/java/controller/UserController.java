/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.UserFacade;
import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import model.User;

/**
 *
 * @author Z.Huraibi
 */
@ApplicationPath("/api")
@Path("/auth")
public class UserController extends Application {

    @EJB
    private UserFacade userFacade;

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloMsg(){
        
        return "test";
    }

    /**
     *
     * @param message
     * @return 
     */
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(String message) {
        // Register user
        User user = new User();
        user.setName("timmy");
        userFacade.create(user);
        return "registered user";
    }

}
