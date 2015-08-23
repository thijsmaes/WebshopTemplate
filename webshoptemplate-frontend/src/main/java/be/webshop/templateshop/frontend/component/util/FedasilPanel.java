package be.webshop.templateshop.frontend.component.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

/**
 * @author gvginder
 */
public class FedasilPanel extends CssLayout {
	private final Label captionLabel;
	private final Layout captionComponents;
	private final Layout contentComponent;

	public FedasilPanel() {
		this(null);
	}

	public FedasilPanel(String caption) {
		captionLabel = new Label();
		captionLabel.setPrimaryStyleName("m-panel-caption");
		captionLabel.setSizeUndefined();

		captionComponents = new CssLayout();
		captionComponents.setPrimaryStyleName("m-panel-caption-container");

		Layout headerComponent = new CssLayout();
		headerComponent.setPrimaryStyleName("m-panel-header-container");
		headerComponent.addComponent(captionLabel);
		headerComponent.addComponent(captionComponents);

		contentComponent = new CssLayout();
		contentComponent.setPrimaryStyleName("m-panel-content-container");

		addComponent(headerComponent);
		addComponent(contentComponent);

		setPrimaryStyleName("m-panel");
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

	public void setContentVisible(boolean visible) {
		contentComponent.setVisible(visible);
	}

	public boolean isContentVisible() {
		return contentComponent.isVisible();
	}

	public Label getCaptionLabel() {
		return captionLabel;
	}

	public Layout getCaptionComponentContainer() {
		return captionComponents;
	}

	public void addCaptionComponent(Component component) {
		captionComponents.addComponent(component);
	}
}
