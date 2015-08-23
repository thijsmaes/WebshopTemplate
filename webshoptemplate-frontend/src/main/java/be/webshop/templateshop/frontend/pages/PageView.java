package be.webshop.templateshop.frontend.pages;

import be.webshop.templateshop.frontend.component.ComponentBuilder;
import be.webshop.templateshop.frontend.menu.MainMenuItem;
import be.webshop.templateshop.frontend.menu.SubMenuItem;

public interface PageView {

	/**
	 * Any implementation should change the "current" indicator (if any) of the main menu to the provided menuItem.
	 * The submenu screen must be updated with the submenu part of this menuitem.
	 * 
	 * @param menuItem
	 */
	void setCurrentMenuItem(MainMenuItem menuItem);
	
	/**
	 * Any implementation should change the "current" indicator (if any) of the sub menu to the provided subMenuItem.
	 * Use the ComponentBuilder of the subMenuItem to build a user interface component for the bodypart
	 * @param subMenuItem
	 */
	void setCurrentSubMenuItem(SubMenuItem subMenuItem);
	
	/**
	 * Implementation must use {@link ComponentBuilder#build()} to get the Component instance to put in the body section of the page.
	 * @param builder
	 */
	void setBody(ComponentBuilder builder);
}
