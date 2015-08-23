package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

/**
 * @author gvginder
 */
public class FedasilFieldset extends CssLayout {
	private final Label captionLabel;
	private final Layout contentComponent;

	public FedasilFieldset() {
		this(null);
	}

	public FedasilFieldset(String caption) {
		captionLabel = new Label();
		captionLabel.setPrimaryStyleName("m-fieldset-caption");
		captionLabel.setSizeUndefined();

		contentComponent = new CssLayout();
		contentComponent.setPrimaryStyleName("m-fieldset-content-container");

		addComponent(captionLabel);
		addComponent(contentComponent);

		setPrimaryStyleName("m-fieldset");
		setCaption(caption);
	}

	@Override
	public void setCaption(String caption) {
		captionLabel.setValue(caption);
	}

	public void setContent(Component component) {
		contentComponent.removeAllComponents();
		contentComponent.addComponent(component);
	}
}
