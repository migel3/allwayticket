package by.alex.allwayticket.services.impl;

import by.alex.allwayticket.daos.RoleRepository;
import by.alex.allwayticket.daos.UserRepository;
import by.alex.allwayticket.dtos.UserDTO;
import by.alex.allwayticket.entities.User;
import by.alex.allwayticket.services.UserService;
import by.alex.allwayticket.validators.EmailExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;

@Service

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(rollbackFor = {EmailExistsException.class})
    public User registerNewUserAccount(UserDTO accountDto)
            throws EmailExistsException {
        LOGGER.debug("Adding a new user entry with information: {}", accountDto);
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + accountDto.getEmail());
        }
        final User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        return userRepository.saveAndFlush(user);
    }

    private boolean emailExist(String email) {
        LOGGER.debug("Finding a user entry with email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}

