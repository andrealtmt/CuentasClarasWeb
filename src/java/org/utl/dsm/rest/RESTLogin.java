package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.controller.ControllerLogin;

import org.utl.dsm.model.Usuario;

@Path("login")
public class RESTLogin {
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response login(Usuario usuario) throws SQLException {
        ControllerLogin loginController = new ControllerLogin();
        Usuario user = null;
        System.out.println("usuario" + usuario);
        try {
            user = loginController.log(usuario);
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error en la autenticación").build();
        }
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create")
    @POST
    public Response create(Usuario usuario) throws SQLException {
        ControllerLogin loginController = new ControllerLogin();
        System.out.println(usuario);
        int idGenerado = -1;
        try {
            idGenerado = loginController.insert(usuario);
            return Response.status(Response.Status.OK).entity(idGenerado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(idGenerado).build();
        }
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll() {
        ControllerLogin loginController = new ControllerLogin();
        List<Usuario> users = new ArrayList<>();
        try {
            users = loginController.getAll();
            return Response.status(Response.Status.OK).entity(users).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("User not found").build();
        }
    }
}