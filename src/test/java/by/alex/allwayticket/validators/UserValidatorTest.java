package by.alex.allwayticket.validators;

import by.alex.allwayticket.dtos.UserDTO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class UserValidatorTest {

    @Autowired
    private Validator validator;

    private Set<ConstraintViolation<UserDTO>> violations;

    private UserDTO user;


    @BeforeClass
    public static void before() throws Exception {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Before
    public void setUp() throws Exception {
        user = new UserDTO();
        user.setEmail("qwerty@mal.by");
        user.setFirstName("Vas");
        user.setLastName("Pick");
        user.setPassword("123456");
        user.setMatchingPassword("123456");
    }


    @Test
    public void testHappyPathValidationForWholeObject() {

        violations = validator.validate(user);
        assertThat("validation failed: " + violations, violations.size(), is(0));
    }

    @Test
    public void shouldFailValidationWithNullInputValuesForFirstNameField() {
        violations = validator.validateValue(UserDTO.class, "firstName", null);
        assertThat("LastName field should have a validation error for null input", violations.size(), is(1));
        assertThat(violations.iterator().next().getMessage(), is("may not be null"));
    }

    @Test
    public void shouldFailValidationWithLessLongInputValuesForFirstNameField() {

        String inputValue = "a";
        violations = validator.validateValue(UserDTO.class, "firstName", inputValue);
        assertThat("Should  get validation errors - input: " + inputValue + " issues: " + violations,
                violations.size(), is(1));
    }

    @Test
    public void shouldPassLengthValidationPropertyInputValuesForFirstNameField() {
        String inputValue = "ba";
        violations = validator.validateValue(UserDTO.class, "firstName", inputValue);
        assertThat("Should not have got a validation error - input: " + inputValue, violations.size(), is(0));
    }


    @Test
    public void shouldFailValidationWithNullInputValuesForLastNameField() {
        violations = validator.validateValue(UserDTO.class, "lastName", null);
        assertThat("LastName field should have a validation error for null input", violations.size(), is(1));
        assertThat(violations.iterator().next().getMessage(), is("may not be null"));
    }

    @Test
    public void shouldFailValidationWithLessLongInputValuesForLastNameField() {

        String inputValue = "b";
        violations = validator.validateValue(UserDTO.class, "lastName", inputValue);
        assertThat("Should  get validation errors - input: " + inputValue + " issues: " + violations,
                violations.size(), is(1));
    }

    @Test
    public void shouldPassLengthValidationPropertyInputValuesForLastNameField() {
        String inputValue = "bal";
        violations = validator.validateValue(UserDTO.class, "lastName", inputValue);
        assertThat("Should not have got a validation error - input: " + inputValue, violations.size(), is(0));
    }

    @Test
    public void shouldFailValidationWithNullInputValuesForPasswordField() {
        violations = validator.validateValue(UserDTO.class, "password", null);
        assertThat("LastName field should  have a validation error for null input", violations.size(), is(1));
        assertThat(violations.iterator().next().getMessage(), is("may not be null"));
    }

    @Test
    public void shouldFailValidationWithLessLongInputValuesForPasswordField() {

        String inputValue = "balop";
        violations = validator.validateValue(UserDTO.class, "password", inputValue);
        assertThat("Should  get validation errors - input: " + inputValue + " issues: " + violations,
                violations.size(), is(1));
    }

    @Test
    public void shouldPassLengthValidationPropertyInputValuesForPasswordField() {
        String inputValue = "balablaqw";
        violations = validator.validateValue(UserDTO.class, "lastName", inputValue);
        assertThat("Should not have got a validation error - input: " + inputValue, violations.size(), is(0));
    }

    @Test
    public void shouldFailValidationWithMatchingInputValuesForPasswordFields() {
        String password = "123456";
        String matchingPassword = "1234567";
        user.setPassword(password);
        user.setMatchingPassword(matchingPassword);
        violations = validator.validate(user);
        assertThat("Should  get validation errors  password: " + password + " matching matchingPassword: "
                        + matchingPassword + " issues: " + violations,
                violations.size(), is(1));

    }

    @Test
    public void shouldFailValidationWithPatternInputValuesForEmailFields() {
        String email = "tut.by";
        user.setEmail(email);
        violations = validator.validate(user);
        assertThat("Should  get validation errors for wrong pattern email: " + email + " issues: " + violations,
                violations.size(), is(1));

    }


}
