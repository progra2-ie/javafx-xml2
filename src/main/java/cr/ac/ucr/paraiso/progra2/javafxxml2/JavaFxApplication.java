package cr.ac.ucr.paraiso.progra2.javafxxml2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxApplication extends Application {
    // Creating a static root to pass to the controller
    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {

        MenuBar menuBar = (MenuBar)
                FXMLLoader.load(JavaFxApplication.class.getResource("javafx-application-main-menu-bar.fxml"));
        AnchorPane anchorPane =
                (AnchorPane) FXMLLoader.load(JavaFxApplication.class.getResource("javafx-application-view.fxml"));
        root.setTop(menuBar);
        root.setCenter(anchorPane);
        Scene scene = new Scene(root, 640, 480);
//        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}