package be.webshop.templateshop.frontend.component.shopbuilder.shopview;

import be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout.AbstractLayout;
import be.webshop.templateshop.frontend.component.shopbuilder.shopview.layout.ProductLayout;
import be.webshop.templatewebshop.backend.entities.Jewel;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmaes on 19/08/2015.
 */
public class ShopViewImpl extends CssLayout implements ShopView {

    private List<Jewel> jewels = new ArrayList<>();
    private CssLayout mainLayout = new CssLayout();
    private HorizontalLayout filterMenu;
    private AbstractLayout layout;
    private ShopPresenter presenter;


    public ShopViewImpl(){
        if(presenter instanceof ShopPresenter ){
            layout = new ProductLayout(presenter);
        }
        
    }

    public AbstractLayout getLayout() {
        return layout;
    }

    @Override
    public void setLayout(AbstractLayout layout) {
        this.layout = layout;
    }

    public ShopPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(ShopPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void createFilterPanel() {

    }

    @Override
    public void createFilterMenu(JewelShopPresenter jewelShopPresenter) {
        filterMenu = new HorizontalLayout();

//        mainLayout.addComponent(filterMenu);
    }

    @Override
    public void setContent() {
        addComponent(mainLayout);
        mainLayout.addComponent(filterMenu);
    }


    public List<Jewel> getJewels() {
        return jewels;
    }

    public void setJewels(List<Jewel> jewels) {
        this.jewels = jewels;
    }

}
