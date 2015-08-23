package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Button;

/**
 * @author tmaes
 */
public class FedasilButton extends Button {
	public enum Style {
		DEFAULT,
		PRIMARY
	}

	public FedasilButton() {
		this(Style.DEFAULT);
	}

	public FedasilButton(String caption) {
		this(Style.DEFAULT, caption);
	}

	public FedasilButton(String caption, ClickListener listener) {
		this(Style.DEFAULT, caption, listener);
	}

	public FedasilButton(Style style) {
		this(style, null);
	}

	public FedasilButton(Style style, String caption) {
		super(caption);
		init(style);
	}

	public FedasilButton(Style style, String caption, ClickListener listener) {
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
