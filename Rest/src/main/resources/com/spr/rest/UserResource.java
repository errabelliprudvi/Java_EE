package com.spr.rest;


import com.spr.dao.UserDAO;
import com.spr.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserResource {

    private UserDAO userDAO = new UserDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        userDAO.saveUser(user);
        return user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
