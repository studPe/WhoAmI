package com.example.application.views.game;
import com.vaadin.flow.component.html.Image;
import com.example.application.views.about.AboutView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AboutViewTest {

    private AboutView aboutView;

    @BeforeEach
    void setUp() {
        aboutView = new AboutView();
    }

    @Test
    void aboutViewContainsCorrectComponents() {
        assertEquals(5, aboutView.getChildren().count(), "AboutView should contain 5 components.");

        assertTrue(aboutView.getChildren().anyMatch(component -> component instanceof Image), "AboutView should contain an Image.");
        assertTrue(aboutView.getChildren().anyMatch(component -> component instanceof H2 && ((H2) component).getText().equals("How to Play WhoAmI !")), "AboutView should contain an H2 header with correct text.");
        assertTrue(aboutView.getChildren().filter(component -> component instanceof Paragraph).count() == 3, "AboutView should contain 3 Paragraphs.");
    }

    @Test
    void aboutViewHasCorrectStyleSettings() {
        assertEquals("center", aboutView.getStyle().get("text-align"), "Text alignment shouldn't be centered.");
        assertFalse(aboutView.isSpacing(), "Spacing should be false.");
        assertEquals(VerticalLayout.Alignment.CENTER, aboutView.getDefaultHorizontalComponentAlignment(), "Default horizontal component alignment should be CENTER.");
        assertEquals(VerticalLayout.JustifyContentMode.CENTER, aboutView.getJustifyContentMode(), "Justify content mode should be CENTER.");
    }
}
