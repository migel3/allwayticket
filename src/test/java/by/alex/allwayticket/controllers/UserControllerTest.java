package by.alex.allwayticket.controllers;

import by.alex.allwayticket.daos.RoleRepository;
import by.alex.allwayticket.daos.UserRepository;
import by.alex.allwayticket.dtos.UserDTO;
import by.alex.allwayticket.entities.User;
import by.alex.allwayticket.services.UserService;
import by.alex.allwayticket.services.impl.UserServiceImpl;
import by.alex.allwayticket.validators.EmailExistsException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-DispatcherServlet-context.xml")
@WebAppConfiguration

public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private UserService userServiceMock;

    private UserRepository repositoryMock;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        RoleRepository roleRepository = mock(RoleRepository.class);
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        repositoryMock = mock(UserRepository.class);
        userServiceMock = new UserServiceImpl(repositoryMock, roleRepository, passwordEncoder);

    }


    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(get("/user/register"))
                .andExpect(model().attributeExists("newUser"));
    }

    @Test
    public void add_UserWithEmailNotMatchPattern_ShouldRenderFormViewAndReturnValidationErrors() throws Exception {

        UserDTO user = new UserDTO();
        user.setEmail("qwert@mal");
        user.setFirstName("Vas");
        user.setLastName("Pick");
        user.setPassword("123456");
        user.setMatchingPassword("123456");

        mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", user.getFirstName())
                .param("lastName", user.getLastName())
                .param("password", user.getPassword())
                .param("matchingPassword", user.getMatchingPassword())
                .param("email", user.getEmail())

        )

                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/register.jsp"))
                .andExpect(model().attributeHasFieldErrors("newUser", "email"))
                .andExpect(model().attribute("newUser", hasProperty("email", is(user.getEmail()))))
                .andExpect(model().attribute("newUser", hasProperty("password", is(user.getPassword()))))
                .andExpect(model().attribute("newUser", hasProperty("matchingPassword", is(user.getMatchingPassword()))))
                .andExpect(model().attribute("newUser", hasProperty("firstName", is(user.getFirstName()))))
                .andExpect(model().attribute("newUser", hasProperty("lastName", is(user.getLastName()))));

        /*verifyZeroInteractions(userServiceMock);*/
    }

    @Ignore
    @Test
    public void add_UserEntry_ShouldAddUserEntryAndRenderViewTodoEntryView() throws EmailExistsException, Exception {


        UserDTO user = new UserDTO();
        user.setEmail("qwert@mal.ru");
        user.setFirstName("Vas");
        user.setLastName("Pick");
        user.setPassword("123456");
        user.setMatchingPassword("123456");

        userServiceMock.registerNewUserAccount(user);

        mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "Vas")
                .param("lastName", "Pick")
                .param("password", "1234567")
                .param("matchingPassword", "1234567")
                .param("email", "qwert@mal.ru")
        )
                .andDo(print())
                .andExpect(view().name("redirect:login"));


        ArgumentCaptor<User> formObjectArgument = ArgumentCaptor.forClass(User.class);
        verify(repositoryMock, times(1)).saveAndFlush(formObjectArgument.capture());


        User formObject = formObjectArgument.getValue();

        assertThat(formObject.getEmail(), is("qwert@mal.ru"));
        assertThat(formObject.getFirstName(), is("Vas"));
    }


}
