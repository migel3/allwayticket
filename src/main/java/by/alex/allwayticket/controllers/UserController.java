package by.alex.allwayticket.controllers;

import by.alex.allwayticket.dtos.UserDTO;
import by.alex.allwayticket.entities.User;
import by.alex.allwayticket.services.UserService;
import by.alex.allwayticket.validators.EmailExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("newUser") UserDTO user) {
        LOGGER.debug("Rendering add user entry form.");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addBasicUser(@ModelAttribute("newUser") @Valid UserDTO accountDto, BindingResult result,
                                     WebRequest request, Errors errors) {
        LOGGER.debug("Adding a new user entry with information: {}", accountDto);
        User registered = new User();
        if (!result.hasErrors()) {

            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "","User with such email exists!");
        }

        if (result.hasErrors()) {
            LOGGER.debug("Add user form was submitted with binding errors. Rendering form view.");
            return new ModelAndView("register", "newUser", accountDto);
        }

        else {
            LOGGER.debug("Added a user entry with information: {}", accountDto);
            return new ModelAndView("redirect:login", "newUser", accountDto);
        }

    }
    private User createUserAccount(UserDTO accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }

}


