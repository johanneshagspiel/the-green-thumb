package com.luv2code.springdemo.test.service;

import com.luv2code.springdemo.dao.UserDAO;
import com.luv2code.springdemo.entity.User;
import com.luv2code.springdemo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceImplTest {

    @Mock
    private UserDAO mockUserDAO;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetUsers() {
        // Setup
        final List<User> expectedResult = Arrays.asList();

        // Run the test
        final List<User> result = userServiceImplUnderTest.getUsers();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSaveUser() {
        // Setup
        final User theUser = null;

        // Run the test
        userServiceImplUnderTest.saveUser(theUser);

        // Verify the results
    }

    @Test
    public void testGetUser() {
        // Setup
        final int theId = 0;
        final User expectedResult = null;

        // Run the test
        final User result = userServiceImplUnderTest.getUser(theId);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDeleteUser() {
        // Setup
        final int theId = 0;

        // Run the test
        userServiceImplUnderTest.deleteUser(theId);

        // Verify the results
    }

    @Test
    public void testGetUser2() {
        // Setup
        final String user_name = "user_name";
        final String password = "password";
        final User expectedResult = null;

        // Run the test
        final User result = userServiceImplUnderTest.getUser2(user_name, password);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetUser3() {
        // Setup
        final String user_name = "user_name";
        final User expectedResult = null;

        // Run the test
        final User result = userServiceImplUnderTest.getUser3(user_name);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
