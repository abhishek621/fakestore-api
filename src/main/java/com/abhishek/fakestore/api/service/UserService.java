package com.abhishek.fakestore.api.service;
import java.util.List;

import com.abhishek.fakestore.api.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    List<User> getUsersLimited(int limit);
    List<User> getUsersSorted(String sort);
    User addUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
