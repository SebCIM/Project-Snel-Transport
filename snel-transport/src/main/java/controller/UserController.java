/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.Environment;
import ejb.UserFacade;
import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import model.User;
import org.json.JSONObject;

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
    @Consumes({"application/json"})
    public JSONObject register(String data) {
        JSONObject request = new JSONObject(data);
        JSONObject obj = new JSONObject();
        obj.put("message", "Your account has been created.");

        // Register user
        User user = new User();
       
        user.setName(request.getString("name"));
//        userFacade = new UserFacade();
        System.out.println("user ctrl "+ user);
        System.out.println("userfacade ctrl "+ userFacade);
        if(request.has("environment")) {
            if(request.getString("environment") == "TEST"){
                userFacade.setEnv(Environment.TEST);
            }
        }
        userFacade.create(user);
        
        return obj;
    }
}
