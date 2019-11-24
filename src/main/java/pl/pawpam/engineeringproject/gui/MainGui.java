package pl.pawpam.engineeringproject.gui;

import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.pawpam.engineeringproject.gui.menu.Menu;
import pl.pawpam.engineeringproject.user.UserService;

import java.util.List;


@Route("")
public class MainGui extends VerticalLayout {
    private Menu mainMenu;
        private MenuBar menuBar;
        UserService userService;
        private Button button;
        private Image image;
        private Label label;

        @Autowired
    public MainGui(UserService userService) {
        this.userService = userService;
        mainMenu = new Menu(userService);
            setAlignItems(Alignment.CENTER);
            image = new Image();
            label = new Label("Random image for MOTIVATION!");
            String[] images;
            RestTemplate restTemplate = new RestTemplate();
            JsonNode trainingPictures = restTemplate.getForObject("https://wallhaven.cc/api/v1/search?q=workout&categories=111&purity=100&apikey=9geHJ194PJCPeVlHtWZSibzRUdwW2kLu",
                    JsonNode.class).get("data");
            images = separateLinks(String.valueOf(trainingPictures));
            int random = (int) (Math.random()* images.length-1)+1;
            image.setSrc(images[random]);
            image.setAlt("image");
            image.setVisible(true);
            image.setHeight("500px");

        add(mainMenu,label,image);
    }
    public String[] separateLinks(String str)
    {
        String[] strings;
        strings = str.split("path\":\"");
        for(int i = 1;i<strings.length;i++)
        {
            strings[i] = strings[i].substring(strings[i].indexOf("https://w.wall"),strings[i].indexOf("thumbs")-3);
            System.out.println("S["+i+"]="+ strings[i]);
        }
        System.out.println(str);
        return strings;
    }
}
