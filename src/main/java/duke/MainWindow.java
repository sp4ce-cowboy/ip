package duke;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private ChatterBox duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/DaDuke.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(ChatterBox d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    /*@FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }*/

    @FXML
    private void handleUserInput() {
        String userString = "\n" + "User: " + userInput.getText() + " ";
        Label userText = new Label("\n" + "User: " + userInput.getText() + " ");
        String responseString = duke.getResponse(userInput.getText());
        Label dukeText = new Label(responseString);

        if (responseString.equals("bye")) {
            dukeText = new Label(new Ui().byeScreen());
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        // 3. Exit the application
                        Platform.exit();
                    }
            ));

            timeline.play();
        }

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userString, userImage),
                DialogBox.getDukeDialog(responseString, dukeImage)
        );
        userInput.clear();
    }
}

