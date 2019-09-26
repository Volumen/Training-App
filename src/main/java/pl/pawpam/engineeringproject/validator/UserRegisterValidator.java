package pl.pawpam.engineeringproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.pawpam.engineeringproject.constants.AppConstants;
import pl.pawpam.engineeringproject.user.User;
import pl.pawpam.engineeringproject.utilities.AppUtilities;

public class UserRegisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "puste imie");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "puste nazwisko");
        ValidationUtils.rejectIfEmpty(errors, "email", "puste emial");
        ValidationUtils.rejectIfEmpty(errors, "password", "puste haslo");

        if (!u.getEmail().equals(null)) {
            boolean isMatch = AppUtilities.checkEmailOrPassword(AppConstants.EMAIL_PATTERN, u.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "nie pasuje mail");
            }
        }
        if (!u.getPassword().equals(null)) {
            boolean isMatch = AppUtilities.checkEmailOrPassword(AppConstants.PASSWORD_PATTERN, u.getPassword());
            if (!isMatch) {
                errors.rejectValue("password", "nie pasuje haslo");
                }
            }
        }
        public void validateEmailExist(User user, Errors errors) {
            if (user != null) {
                errors.rejectValue("email", "mail juz istnieje");
            }
        }


}
