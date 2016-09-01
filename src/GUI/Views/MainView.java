package GUI.Views;
/*
* views.MainView is the first user-facing UI to be displayed.
* Any View classes should not contain functional code,
* the purpose of View classes are to organize methods
* and elements necessary for displaying user-facing
* elements.
 */

import GUI.Controllers.MainController;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView {
    private MainController controller = new MainController();
    private Stage mainStage = new Stage();


    /**
     * This is the main access point for
     * displayable content, all visible
     * elements should be included in the
     * stage.
     * @return the stage
     */
    public Stage getStage() {
        mainStage.resizableProperty().setValue(false);
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");
        root.setCenter(mainContainer());
        Scene mainScene = new Scene(root, 300, 240, Color.TRANSPARENT);
        mainStage.setScene(mainScene);
        mainScene.getStylesheets().add(this.getClass().getResource("/GUI/Resources/MainView.css").toExternalForm());
        return mainStage;
    }

    private VBox mainContainer() {
        VBox container = new VBox();
        TextField field = controller.createTextField();
        controller.formatTextField(field);
        /*-- Add children elements --*/
        container.getChildren().add(field);

        return container;
    }
}