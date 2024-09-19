package com.service.authapi.service;

import com.service.authapi.model.User;
import com.service.authapi.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnAllUsers() {
        List<User> expectedUsers = new ArrayList<>();
        // Add sample users to the expected list
        expectedUsers.add(new User("user1", "password1"));
        expectedUsers.add(new User("user2", "password2"));

        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.allUsers();

        assertEquals(expectedUsers, actualUsers);
    }
}
