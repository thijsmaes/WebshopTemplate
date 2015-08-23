package be.webshop.templateshop.frontend.util;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;

import java.util.Locale;

public class UIHelper {
    /**
     * Creates a component to put at the top of the page to switch to a specific
     * language. The onClick of the component is defined to let the UI switch to
     * the selected language.
     *
     * @param language 2-char language code: nl, fr
     * @return Component ready to put on the view.
     */
    @SuppressWarnings("serial")
    public static Component languageSwitcher(final String language) {
        final Button lngButton = new Button(language);
        lngButton.setPrimaryStyleName("m-language-button");
        if (language.equals(UI.getCurrent().getLocale().getLanguage())){
            lngButton.addStyleName("m-selected");
        }
        lngButton.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                UI.getCurrent().setLocale(new Locale(language));
                UI.getCurrent().getNavigator().navigateTo("home");
            }
        });
        return lngButton;
    }

    /**
     * Looks for the image defined in resourcePath for the requested language.
     * Example:
     * <p/>
     * <pre>
     * resourcePath = "images/logo.png"
     * language = "nl"
     * </pre>
     * <p/>
     * it will search for "images/logo_nl.png". if not found : "images/logo.png"
     *
     * @param caption
     * @param resourcePath
     * @return
     */
    public static Image getTranslatedImage(String caption, String resourcePath) {
        String[] resourceParts = resourcePath.split("\\.");
        Resource img = new ThemeResource(resourceParts[0] + "_" + getCurrentLanguage() + "." + resourceParts[1]);
        return new Image(caption, img);
    }

    public static String getCurrentLanguage() {
        return UI.getCurrent().getLocale().getLanguage();
    }
}
