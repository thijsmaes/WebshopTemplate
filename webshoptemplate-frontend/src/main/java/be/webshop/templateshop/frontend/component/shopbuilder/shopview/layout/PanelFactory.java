package be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout;

import be.webshop.templatewebshop.backend.entities.Product;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;


/**
 * Created by tmaes on 4/10/2015.
 */
public class PanelFactory {

    Product product;
    VerticalLayout panelContent;
    Image thumb;
    Label name;
    Label title;
    Label shortDescription;
    Label description;
    Label price;
    Label origin;

    public PanelFactory(Product product) {
        this.product = product;
        //thumb = new Image("", new ClassResource(product.getThumbnail()));
        name = new Label(product.getName());
        shortDescription = new Label(product.getShortDescription());
        description = new Label(product.getDescription());
        price = new Label((product.getPriceInclVat()).toString());
        origin = new Label(product.getOrigin());
        createPanelContent();
    }

    private void createPanelContent() {
        panelContent = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponents(name, price);
        hl.setSpacing(true);
        panelContent.addComponents(hl, thumb, shortDescription);
        panelContent.setSpacing(true);
    }

    public Panel createPanel(Layout layout) {
        Panel panel = new Panel();
        panel.setContent(panelContent);
        return panel;
    }


}
