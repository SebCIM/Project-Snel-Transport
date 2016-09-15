/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;

/**
 *
 * @author Z.Huraibi
 */
@Path("/api/auth")
public class AuthCtrl {

    /**
     *
     * @param message
     */
    @POST
    @Path("/register")
    public Response.ResponseBuilder register(String message) {
        // Register user
        return Response.ok(this, "yesyeszz");
    }

    @GET
    public Response getUser() {
        return Response.status(200).entity("getUser is called").build();

    }
}
