/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;

/**
 *
 * @author Z.Huraibi
 */
@Path("/auth")
@ApplicationPath("/api")
public class AuthCtrl extends Application {

    com.mycompany.UserFacade userFacade = lookupUserFacadeBean();
    
    /**
     * 
     * @return 
     */
    @GET
    @Path("/user")
    public String getHelloMsg() {
        return "test";
    }

    /**
     * 
     * @param message
     * @return
     */
    @POST
    @Path("/register")
    public String register(String message) {
        // Register user
//        userFacade.create(entity);
        
        return "done registering";
    }

    private com.mycompany.UserFacade lookupUserFacadeBean() {
        try {
            Context c = new InitialContext();
            return (com.mycompany.UserFacade) c.lookup("java:global/com.mycompany_snel-transport-ear_ear_1.0-SNAPSHOT/com.mycompany_snel-transport-ejb_ejb_1.0-SNAPSHOT/UserFacade!com.mycompany.UserFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
