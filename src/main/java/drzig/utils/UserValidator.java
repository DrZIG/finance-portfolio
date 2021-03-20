package drzig.utils;

import drzig.dao.UserDAO;
import drzig.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Dr.ZIG
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userDAO.findUserByEmail(user.getEmail()) != null)
            errors.rejectValue("email", "", "User with specified email is already exists.");

        if (userDAO.findUserByLogin(user.getLogin()) != null)
            errors.rejectValue("login", "", "User with specified login is already exists.");
    }
}
