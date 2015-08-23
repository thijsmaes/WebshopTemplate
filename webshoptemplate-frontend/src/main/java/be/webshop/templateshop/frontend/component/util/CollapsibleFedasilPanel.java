package be.webshop.templateshop.frontend.component.util;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;

/**
 * @author tmaes
 */
public class CollapsibleFedasilPanel extends FedasilPanel {
	private final ThemeResource expandIconResource;
	private final ThemeResource collapseIconResource;

	public CollapsibleFedasilPanel() {
		this(null);
	}

	public CollapsibleFedasilPanel(String caption) {
		super(caption);

		expandIconResource = new ThemeResource("images/arrow_down.png");
		collapseIconResource = new ThemeResource("images/arrow_up.png");

		final Button collapseButton = new Button();
		collapseButton.setPrimaryStyleName("m-unstyled-button");
		collapseButton.setIcon(expandIconResource);
		collapseButton.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				if (isContentVisible()) {
					setContentVisible(false);
					collapseButton.setIcon(expandIconResource);
				} else {
					setContentVisible(true);
					collapseButton.setIcon(collapseIconResource);
				}
			}
		});

		setContentVisible(false);
		addCaptionComponent(collapseButton);
		getCaptionComponentContainer().setStyleName("m-panel-caption-container-right");
	}
}
