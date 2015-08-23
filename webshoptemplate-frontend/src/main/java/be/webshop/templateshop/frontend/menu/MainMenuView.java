package be.webshop.templateshop.frontend.menu;

import be.webshop.templateshop.frontend.WebshopTemplateUI;
import be.webshop.templateshop.frontend.util.LocaleText;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainMenuView extends CssLayout {
	private static final long serialVersionUID = 2739346173546549933L;

	private final CssLayout menu;
	private final Map<MainMenuItem, Button> viewButtons = new HashMap<MainMenuItem, Button>();

	public MainMenuView() {
		menu = new CssLayout();

		CssLayout navigationContainer = new CssLayout();
		CssLayout navigation = new CssLayout();
		CssLayout blockMenuMain = new CssLayout();
		CssLayout content = new CssLayout();

		setId("navigation-outer");
		setStyleName("clear-block");
		navigationContainer.setId("navigation-container");
		navigation.setId("navigation");
		navigation.setStyleName("clear-block");
		blockMenuMain.setId("block-menu-main");
		blockMenuMain.addStyleName("block-menu menu-main");
		content.addStyleName("content clear-block");
		menu.addStyleName("menu clear-block");

		addComponent(navigationContainer);
		navigationContainer.addComponent(navigation);
		navigation.addComponent(blockMenuMain);
		blockMenuMain.addComponent(content);
		content.addComponent(menu);
	}

	public MainMenuView setMenuItems(List<MainMenuItem> items) {
		for (MainMenuItem item : items)
			createViewButton(item);
		return this;
	}

	private void createViewButton(final MainMenuItem menuItem) {
		@SuppressWarnings("serial")
		/*Button button = new Button(LocaleText.getCaption(menuItem.getCaptionCode()), new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO : where best to put this?
//            	SessionUtil.initPlacesManagementGenericModels();
				WebshopTemplateUI.get().getCurrentPagePresenter().onMenuSelected(menuItem);
			}
		});*/

				Button button = new Button((menuItem.getCaption()), new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO : where best to put this?
//            	SessionUtil.initPlacesManagementGenericModels();
				WebshopTemplateUI.get().getCurrentPagePresenter().onMenuSelected(menuItem);
			}
		});

		button.setPrimaryStyleName("m-menu-button");
		button.setSizeUndefined();

		menu.addComponent(button);
		viewButtons.put(menuItem, button);
	}

	/**
	 * Highlights a view navigation button as the currently active view in the
	 * menu. This method does not perform the actual navigation.
	 *
	 * @param menuItem the name of the view to show as active
	 */

	public void setActiveView(MainMenuItem menuItem) {
		for (Button button : viewButtons.values()) {
			button.removeStyleName("m-selected");
		}
		Button selected = viewButtons.get(menuItem);
		if (selected != null) {
			selected.addStyleName("m-selected");
		}
	}
}
