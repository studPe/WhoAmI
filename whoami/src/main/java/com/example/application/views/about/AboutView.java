package com.example.application.views.about;

import com.example.application.MainView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("About")
@Route(value = "about", layout = MainView.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(false);

        Image img = new Image("images/WhoAmI.png", "Logo");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("How to Play WhoAmI !");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Welcome to the WhoAmI game in the style of the German game \"Wer bin ich?\"! This guide will help you understand the rules and how to play.\n"));
        add(new Paragraph("With corresponding button start a new game. Every player than has to enter the same Game ID and choose different one of the four characters. Now the game can begin as usual. At any time users can check there guesses, and find out if they have won."));
        add(new Paragraph("Enjoy playing the Twenty Questions game in the \"Wer bin ich?\" style and have fun guessing! 🤗"));
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}