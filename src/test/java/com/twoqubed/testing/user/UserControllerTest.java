package com.twoqubed.testing.user;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {

    private UserController controller;
    private User user;

    @Mock private UserRepository userRepository;

    @Before
    public void setUp() {
        initMocks(this);

        controller = new UserController(userRepository);

        user = new User("", "", "", "");
    }

    @Test
    public void shouldPutUserInModelIfFound() throws UserNotFoundException {
        when(userRepository.findUser("123")).thenReturn(user);

        ModelAndView modelAndView = controller.findUser("abc");

        assertEquals(user, modelAndView.getModel().get("user"));
    }

    @Test
    public void shouldSendToErrorPageIfUserNotFound() throws UserNotFoundException {
        when(userRepository.findUser("123")).thenThrow(new UserNotFoundException());

        ModelAndView modelAndView = controller.findUser("123");

        assertEquals("error", modelAndView.getViewName());
    }

    @Test
    public void shouldForwardToUserSavedPageOnSuccessfulUpdate() {
        ModelAndView modelAndView = controller.updateUser(user);

        assertEquals("userSaved", modelAndView.getViewName());

        verify(userRepository).updateUser(user);
    }

    @Test
    public void shouldForwardToErrorPageIfUserIsNull() {
        ModelAndView modelAndView = controller.updateUser(null);

        assertEquals("error", modelAndView.getViewName());

        verifyZeroInteractions(userRepository);
    }

    @Test
    public void shouldForwardToErrorPageIfErrorUpdatingUser() {
        doThrow(new IllegalStateException()).when(userRepository).updateUser(user);

        ModelAndView modelAndView = controller.updateUser(user);

        assertEquals("error", modelAndView.getViewName());
    }
}
