package be.webshop.templateshop.frontend.menu;


import be.webshop.templateshop.frontend.component.ComponentBuilder;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;



public class SubMenuItem {
//    private static final MatchitLogger logger = MatchitLoggerFactory
//            .getLogger(SubMenuItem.class);
/**
 * Code to be used to fetch the translated label for this menu item.
 */



    private String captionCode;

    /**
     *   ComponentBuilder to be used to build the body part of the page when this menu item is selected.
     */



    private Class<? extends ComponentBuilder> componentBuilderClazz;
    private ComponentBuilder componentBuilder;

    public String getCaptionCode() {
        return captionCode;
    }

    public void setCaptionCode(String captionCode) {
        this.captionCode = captionCode;
    }

   /* public void setComponentBuilderClazz(Class<? extends ComponentBuilder> componentBuilderClazz) {
        this.componentBuilderClazz = componentBuilderClazz;
    }*/

    public ComponentBuilder getComponentBuilder() {
        if (componentBuilder != null)
            return componentBuilder;
        else if (componentBuilderClazz != null)
            try {
                return componentBuilderClazz.newInstance();
            } catch (Exception e) {
//                logger.error("Could not instantiate componentBuilder", e);
            }
        return null;
    }

    public void setComponentBuilder(ComponentBuilder componentBuilder) {
        this.componentBuilder = componentBuilder;
    }

    public void startConfigurationWindow(Window window) {
        window.setHeight("400px");
        window.setWidth("400px");
        UI.getCurrent().addWindow(window);
    }

    public void startConfigurationWindow(SubMenuItem subMenuItem) {

    }
}
