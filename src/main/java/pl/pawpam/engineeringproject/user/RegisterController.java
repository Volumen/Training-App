package pl.pawpam.engineeringproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawpam.engineeringproject.validator.UserRegisterValidator;

import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/register")
    public String registerForm(Model model)
    {
        User u = new User();
        model.addAttribute("user", u);
        return "register";
    }

    @PostMapping(value = "/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale)// A bindingResult - object so you can test for and retrieve validation errors.
    {
        String returnPage = null;

        User userExist = userServiceImpl.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validateEmailExist(userExist, result);
        new UserRegisterValidator().validate(user, result);

//        if (result.hasErrors()) {   //jesli formularz zawieta bledy, wracamy na strone register
//            System.out.println("Cos poszlo nie tak!");
//            returnPage = "register";
//        } else {    // jesli formularz nie zawiera błedów, zapisujemy uzytkownika i przekazujemy na strone dwa komunikaty
//            userService.saveUser(user);
//            //model.addAttribute("message", messageSource.getMessage("user.register.success", null,locale));//pierwszy komunikat, który informuje, ze rejestracja zakończyla sie pomyślnie
//            model.addAttribute("user", new User()); //przekazujemy nowego uzytkownika, bo model wymaga przekazania obiektu typu user
//            returnPage = "register";
//        }
//        if (userExist != null){
//            result.rejectValue("email", null, "There is already an account registered with that email");
//        }

        if (result.hasErrors()){
            System.out.println("Cos poszlo nie tak!");
            return "register";
        }
        else {
            userServiceImpl.saveUser(user);
            model.addAttribute("user", new User());
            System.out.println("Rejestracja przebiegła pomyślnie!");
            return "register";
        }
    }
}
