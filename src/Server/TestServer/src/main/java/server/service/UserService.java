package server.service;

import java.util.List;

import server.entity.User;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Gets users.
     *
     * @return the users
     */
    List<User> getUsers();

    /**
     * Save user user.
     *
     * @param theUser the the user
     * @return the user
     */
    User saveUser(User theUser);

    /**
     * Gets user.
     *
     * @param theId the the id
     * @return the user
     */
    User getUser(int theId);

    /**
     * Delete user int.
     *
     * @param theId the the id
     * @return the int
     */
    int deleteUser(int theId);

    /**
     * Gets user 2.
     *
     * @param userName the user name
     * @param password  the password
     * @return the user 2
     */
    User getUser2(String userName, String password);

    /**
     * Gets user 3.
     *
     * @param userName the user name
     * @return the user 3
     */
    User getUser3(String userName);

    /**
     * Gets user safe.
     *
     * @param theUser the the user
     * @return the user safe
     */
    User getUserSafe(User theUser);
}