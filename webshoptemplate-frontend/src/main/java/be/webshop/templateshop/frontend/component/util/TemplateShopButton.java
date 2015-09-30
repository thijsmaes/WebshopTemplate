package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Button;

/**
 * @author tmaes
 */
public class TemplateShopButton extends Button {
	public enum Style {
		DEFAULT,
		PRIMARY
	}

	public TemplateShopButton() {
		this(Style.DEFAULT);
	}

	public TemplateShopButton(String caption) {
		this(Style.DEFAULT, caption);
	}

	public TemplateShopButton(String caption, ClickListener listener) {
		this(Style.DEFAULT, caption, listener);
	}

	public TemplateShopButton(Style style) {
		this(style, null);
	}

	public TemplateShopButton(Style style, String caption) {
		super(caption);
		init(style);
	}

	public TemplateShopButton(Style style, String caption, ClickListener listener) {
		super(caption, listener);
		init(style);
	}

	public void setStyle(Style style) {
		switch (style) {
			case DEFAULT:
				setStyleName("m-button-default");
				break;
			case PRIMARY:
				setStyleName("m-button-primary");
				break;
		}
	}

	private void init(Style style) {
		setPrimaryStyleName("m-button");
		setStyle(style);
	}
}
