package by.alex.allwayticket.dtos;

import by.alex.allwayticket.validators.PasswordMatches;
import by.alex.allwayticket.validators.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDTO {
    @NotNull
    @Size(min = 2,message = "It should be minimum 2 characters ")
    private String firstName;

    @NotNull
    @Size(min = 2,message = "It should be minimum 2 characters ")
    private String lastName;

    @NotNull
    @Size(min =6,max = 20,message = "It should be minimum 6 characters to maximum 20 characters long")
    private String password;

    @NotNull
    @Size(min = 6,message = "It should be minimum 6 characters to maximum 20 characters long")
    private String matchingPassword;

    @ValidEmail
    @NotNull
    private String email;

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    private Integer role;

    public Integer getRole() {
        return role;
    }

    public void setRole(final Integer role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [firstName=").append(firstName).append(", lastName=").append(lastName)
                .append(", password=").append(password).append(", matchingPassword=").append(matchingPassword)
                .append(", email=").append(email).append(", role=").append(role).append("]");
        return builder.toString();
    }

}
