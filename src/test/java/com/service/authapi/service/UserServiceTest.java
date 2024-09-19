package com.service.authapi.service;

import com.service.authapi.model.User;
import com.service.authapi.repository.UserRepository;
import com.service.authapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        // Create a mock repository
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findAll()).thenReturn(expectedUsers);

        // Create UserService with the mock repository
        UserService userService = new UserService(mockRepository);

        List<User> actualUsers = userService.allUsers();

        assertEquals(expectedUsers, actualUsers);
    }
}
