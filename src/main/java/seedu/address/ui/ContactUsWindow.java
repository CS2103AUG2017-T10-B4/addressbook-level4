package seedu.address.ui;

import java.util.logging.Logger;

import javax.swing.plaf.synth.Region;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.FxViewUtil;

public class ContactUsWindow extends UiPart<Region>{
    public static final String CONTACTUS_FILE_PATH = "/docs/ContactUs.html";//must edit tests

    private static final Logger logger = LogsCenter.getLogger(ContactUsWindow.class);
    private static final String ICON = "/images/contact_icon.png";
    private static final String FXML = "ContactUs.fxml";
    private static final String TITLE = "ContactUs";

    @javafx.fxml.FXML
    private WebView browser;

    private final Stage dialogStage;

    public ContactUsWindow() {
        super(FXML);
        Scene scene = new Scene(getRoot()); //why cannot?
        //Null passed as the parent stage to make it non-modal.
        dialogStage = createDialogStage(TITLE, null, scene);
        dialogStage.setMaximized(true); //TODO: set a more appropriate initial size
        FxViewUtil.setStageIcon(dialogStage, ICON);

        String contactUsUrl = getClass().getResource(CONTACTUS_FILE_PATH).toString();
        browser.getEngine().load(contactUsUrl);
    }

    /**
     * Shows the contactUs window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing contactUs page about the application.");
        dialogStage.showAndWait();
    }
}
