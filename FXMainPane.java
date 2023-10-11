package Lab2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

// Make the main panel's layout be a VBox
public class FXMainPane extends VBox {

    // Student Task #2:
    // Declare five buttons, a label, and a textfield
    private Button buttonHello;
    private Button buttonHowdy;
    private Button buttonChinese;
    private Button buttonClear;
    private Button buttonExit;
    private Label labelFeedback;
    private TextField textField;

    // Declare two HBoxes
    private HBox hBoxButtons;
    private HBox hBoxLabelTextField;

    // Student Task #4:
    // Declare an instance of DataManager
    private DataManager dataManager;

    /**
     * The MainPanel constructor sets up the entire GUI in this approach. Remember to
     * wait to add a component to its containing component until the container has
     * been created. This is the only constraint on the order in which the following
     * statements appear.
     */
    FXMainPane() {
        // Student Task #2:
        // Instantiate the buttons, label, and textfield
        buttonHello = new Button("Hello");
        buttonHowdy = new Button("Howdy");
        buttonChinese = new Button("Chinese");
        buttonClear = new Button("Clear");
        buttonExit = new Button("Exit");
        labelFeedback = new Label("Feedback:");
        textField = new TextField();

        // Instantiate the HBoxes
        hBoxButtons = new HBox(10); // 10 pixels spacing between components
        hBoxLabelTextField = new HBox(10);

        // Student Task #4:
        // Instantiate the DataManager instance
        dataManager = new DataManager();

        // Set margins and set alignment of the components
        Insets buttonInsets = new Insets(10); // You can adjust this margin value
        HBox.setMargin(buttonHello, buttonInsets);
        HBox.setMargin(buttonHowdy, buttonInsets);
        HBox.setMargin(buttonChinese, buttonInsets);
        HBox.setMargin(buttonClear, buttonInsets);
        HBox.setMargin(buttonExit, buttonInsets);

        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxLabelTextField.setAlignment(Pos.CENTER);

        // Student Task #3:
        // Add the label and textfield to one of the HBoxes
        hBoxLabelTextField.getChildren().addAll(labelFeedback, textField);

        // Add the buttons to the other HBox
        hBoxButtons.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonClear, buttonExit);

        // Add the HBoxes to this FXMainPanel (a VBox)
        getChildren().addAll(hBoxLabelTextField, hBoxButtons);

        // Task #4:
        // Create a private inner class to handle the button clicks
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHello.setOnAction(buttonHandler);
        buttonHowdy.setOnAction(buttonHandler);
        buttonChinese.setOnAction(buttonHandler);
        buttonClear.setOnAction(buttonHandler);
        buttonExit.setOnAction(buttonHandler);
    }

    // Task #4:
    // Create a private inner class to handle the button clicks
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Handle button clicks here
            if (event.getSource() == buttonHello) {
                String helloMessage = dataManager.getHello();
                textField.setText(helloMessage);
            } else if (event.getSource() == buttonHowdy) {
                String howdyMessage = dataManager.getHowdy();
                textField.setText(howdyMessage);
            } else if (event.getSource() == buttonChinese) {
                String chineseMessage = dataManager.getChinese();
                textField.setText(chineseMessage);
            } else if (event.getSource() == buttonClear) {
                textField.setText("");
            } else if (event.getSource() == buttonExit) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}
