package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

import be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;

/**
 * Created by tmaes on 19/08/2015.
 */
public interface ShopView extends Component {
    void createFilterPanel();

    void createFilterMenu(JewelShopPresenter jewelShopPresenter);

    void setContent();

    void setLayout(AbstractLayout layout);
}
