package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

import be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout.ProductLayout;
import com.vaadin.ui.Layout;

/**
 * Created by tmaes on 19/08/2015.
 */
public class JewelShopPresenter extends ShopPresenter {
    ShopModel shopModel;


    public JewelShopPresenter(ShopModel shopModel, ShopView shopView) {
        this.shopModel = shopModel;
        super.setView(shopView);

        createJewelView();
        shopView.createFilterPanel();
    }

    private void createJewelView() {
        getView().createFilterMenu(this);
        getView().setLayout(new ProductLayout(this));
        getView().setContent();
    }
}