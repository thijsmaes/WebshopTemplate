package be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout;

import be.webshop.templateshop.frontend.component.shopbuilder.shopview.ShopPresenter;
import be.webshop.templatewebshop.backend.entities.Product;

import java.util.List;

/**
 * Created by tmaes on 2/10/2015.
 */
public class ProductLayout extends AbstractLayout {
    List<Product> products;
    ShopPresenter presenter;


    public ProductLayout(ShopPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    void createContent() {

    }
}
