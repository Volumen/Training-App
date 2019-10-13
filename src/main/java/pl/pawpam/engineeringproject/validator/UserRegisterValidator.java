package pl.pawpam.engineeringproject.validator;

import org.springframework.validation.Errors;
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
        System.out.println("Errors: " +errors);
        User u = (User) obj;

//        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
//        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
//        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
//        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (!u.getEmail().equals(null)) {
            boolean isMatch = AppUtilities.checkEmailOrPassword(AppConstants.EMAIL_PATTERN, u.getEmail());
            if (!isMatch) {
                System.out.println("email nie pasuje");
                //errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }
        if (!u.getPassword().equals(null)) {
            boolean isMatch = AppUtilities.checkEmailOrPassword(AppConstants.PASSWORD_PATTERN, u.getPassword());
            if (!isMatch) {
                System.out.println("nie pasuje haslo");
                //errors.rejectValue("password", "error.userPasswordIsNotMatch");
                }
            }
        }
        public void validateEmailExist(User user, Errors errors) {
            if (user != null) {
                //errors.rejectValue("email", "error.userEmailExist");

            }
        }


}
