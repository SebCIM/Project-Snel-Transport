/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

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
@ApplicationPath("/api")
@Path("/auth")
public class AuthCtrl extends Application{

    @GET
    @Path("/user")
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
    public Response.ResponseBuilder register(String message) {
        // Register user
        return Response.ok(this, "yesyeszz");
    }
}
