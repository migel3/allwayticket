package by.alex.allwayticket.services;

import by.alex.allwayticket.dtos.UserDTO;
import by.alex.allwayticket.entities.User;
import by.alex.allwayticket.validators.EmailExistsException;


public interface UserService {
    User registerNewUserAccount(UserDTO accountDto)throws EmailExistsException;
}
