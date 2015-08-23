package be.webshop.templateshop.frontend.template;


import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.menu.MainMenuItem;
import be.webshop.templateshop.frontend.menu.SubMenuItem;

/**
 * PagePresenter is the controller behind the user interface page actions.
 * The PagePresenter implementation must verify access rights and decide how menu navigation choices are executed.
 *
 * @author tmaes
 */


public interface PagePresenter {

	/**
	 * Called by the PageView when a main menu item is selected by the user.
	 * Implementations must assure the action is justified and instruct the PageView which submenu to show.
	 *
	 * @param menuItem
	 */

	void onMenuSelected(MainMenuItem menuItem);

	/**
	 * Called by the PageView when a sub menu item is selected by the user.
	 * Implementations must assure the action is justified and decide how the page must be modified.
	 * hint: every subMenuItem has a ComponentBuilder class.
	 *
	 * @param subMenuItem
	 */

	void onSubMenuSelected(SubMenuItem subMenuItem);

	void doBodyRefresh(ComponentBuilder bodyComponentBuilder);
}
