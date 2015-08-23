package be.webshop.templateshop.frontend.menu;


import be.webshop.templateshop.frontend.component.ComponentBuilder;


import java.util.ArrayList;
import java.util.List;

public class MainMenuItem {
	private String captionCode;
	private List<SubMenuItem> subMenuItems;
	private String caption;

	/**
	 * ComponentBuilder to be used to build the body part of the page when this menu item is selected.
 	 */

	private ComponentBuilder componentBuilder;
	
	public MainMenuItem() {
	}

	/*public MainMenuItem(String captionCode) {
		setCaptionCode(captionCode);
	}*/

	public MainMenuItem(String caption) {
		setCaption(caption);
	}

	public String getCaptionCode() {
		return captionCode;
	}

	public void setCaptionCode(String captionCode) {
		this.captionCode = captionCode;
	}

	public List<SubMenuItem> getSubMenuItems() {
		if(subMenuItems==null)
			subMenuItems=new ArrayList<SubMenuItem>();
		return subMenuItems;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setSubMenuItems(List<SubMenuItem> subMenuItems) {
		this.subMenuItems = subMenuItems;
	}

	public ComponentBuilder getComponentBuilder() {
		return componentBuilder;
	}

	public void setComponentBuilder(ComponentBuilder componentBuilder) {
		this.componentBuilder = componentBuilder;
	}
}
