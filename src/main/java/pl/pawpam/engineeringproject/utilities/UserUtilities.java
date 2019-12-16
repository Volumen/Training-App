package pl.pawpam.engineeringproject.utilities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilities {

    public static String getLoggedUser()
    {
        String username = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Jezeli w kontekscie nie jest przechowywany anonymous, to mamy pobrac nazwe zalogowanego uzytkownika
        //System.out.println("contex security: "+auth);
        if(!(auth instanceof AnonymousAuthenticationToken)) //nie jest instancja tej klasy
        {
            username = auth.getName();
            //System.out.println("Username: "+username);
        }

        return username;
    }
}
