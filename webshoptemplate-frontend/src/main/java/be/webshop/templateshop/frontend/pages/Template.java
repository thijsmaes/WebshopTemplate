package be.webshop.templateshop.frontend.pages;

import be.webshop.templateshop.frontend.WebshopTemplateUI;
import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.menu.*;
import be.webshop.templateshop.frontend.template.LanguageBar;
import be.webshop.templateshop.frontend.template.NormalPagePresenter;
import be.webshop.templateshop.frontend.template.PagePresenter;
import be.webshop.templateshop.frontend.template.PageView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by tmaes on 29/06/2015.
 */

public class Template extends CssLayout implements View, PageView {
	private static final long serialVersionUID = 2214712538561739489L;

	/**
	 * Container for the body part of the view
	 */
	private SubMenuView subMenuPart;
	private PagePresenter pagePresenter;
	private CssLayout mainFrame;

	public Template() {
//		logger.debug("New NormalPageViewImpl");
		pagePresenter = WebshopTemplateUI.get().getCurrentPagePresenter();
		if (pagePresenter == null)
			WebshopTemplateUI.get().setCurrentPagePresenter(
					pagePresenter = new NormalPagePresenter(this));
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
//		logger.debug("NormalPageViewImpl.enter:" + event);

		removeAllComponents();

		LanguageBar languageBar = new LanguageBar();
		Header header = new Header();
		MainMenuView mainMenu = new MainMenuBuilder().build();
		/*LookupPlaceViewImpl lookupPlace = new LookupPlaceBuilder()
				.setLookupListener(this).build();*/

		subMenuPart = new SubMenuView(pagePresenter);
		subMenuPart.setId("left-menu-container");

		CssLayout sidebar = new CssLayout();
		sidebar.setId("sidebar");
//		sidebar.addComponent(lookupPlace);
		sidebar.addComponent(subMenuPart);

		mainFrame = new CssLayout();
		mainFrame.setId("main-frame");
		mainFrame.setPrimaryStyleName("clear-block");

		CssLayout mainContent = new CssLayout();
		mainContent.setId("main-content");
		mainContent.setStyleName("clear-block");
		mainContent.addComponent(sidebar);
		mainContent.addComponent(mainFrame);

		CssLayout wrapper = new CssLayout();
		wrapper.setId("wrapper");
		wrapper.addComponent(languageBar);
		wrapper.addComponent(header);
		wrapper.addComponent(mainMenu);
		wrapper.addComponent(mainContent);

		Footer footer = new Footer();
		footer.setStyleName("m-footer");

		addComponent(wrapper);
		addComponent(footer);

	}

/*	@Override
	public void selectedPlace(Place place) {
		PlaceManagementModel tm = new PlaceManagementModel(place);
		setBody(new PlaceManagementTabSheetViewBuilder().
				addPlaceManagementModelToContext(tm));
	}

	@Override
	public void setCurrentMenuItem(MainMenuItem menuItem) {
		logger.debug("setCurrentMenuItem IN with:" + menuItem.getCaptionCode());
		subMenuPart.setSubMenuItems(menuItem.getSubMenuItems());
	}

	@Override
	public void setCurrentSubMenuItem(SubMenuItem subMenuItem) {
		logger.debug("setCurrentSubMenuItem IN with:"
				+ subMenuItem.getCaptionCode());
		if (subMenuItem.getComponentBuilder() != null) {
			setBody(subMenuItem.getComponentBuilder());
		} else {
			subMenuItem.startConfigurationWindow(subMenuItem);
		}
	}*/

	@Override
	public void setCurrentMenuItem(MainMenuItem menuItem) {
		subMenuPart.setSubMenuItems(menuItem.getSubMenuItems());

	}

	@Override
	public void setCurrentSubMenuItem(SubMenuItem subMenuItem) {
		if (subMenuItem.getComponentBuilder() != null) {
			setBody(subMenuItem.getComponentBuilder());
		} else {
			subMenuItem.startConfigurationWindow(subMenuItem);
		}
	}

	/**
	 * Replaces the body part with the Component returned by the
	 * {@link ComponentBuilder#build() builder.build()} method.
	 *
	 * @param builder
	 *            required ComponentBuilder instance
	 */
	@Override
	public void setBody(ComponentBuilder builder) {
		mainFrame.removeAllComponents();
		mainFrame.addComponent(builder.build());
	}
}
