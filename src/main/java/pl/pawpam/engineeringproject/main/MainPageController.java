package pl.pawpam.engineeringproject.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @GetMapping({"/","/index"})
    public String showMainPage()
    {
        LOG.info("**** WYWOŁANO > showMainPage()");
        return "index";
    }
}
