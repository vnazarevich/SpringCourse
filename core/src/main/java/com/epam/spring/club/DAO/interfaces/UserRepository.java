package com.epam.spring.club.DAO.interfaces;

import com.epam.spring.club.models.User;

public interface UserRepository {
    String registerUser(String name, String email);

    User removeUser(User User);

    User getUserById(String id);

    User getUserByEmail(String email);

    User getUserByName(String name);
}
