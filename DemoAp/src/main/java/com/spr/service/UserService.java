

package com.spr.service;

import java.util.List;

import com.spr.dao.UserDAO;
import com.spr.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO(); // DAO instance

    public List<User> getUsers() {
        return userDAO.getAllUsers(); // Fetching from DB
    }
}
