package cr.ac.ucr.paraiso.progra2.javafxxml2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class JavaFxController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void exit(ActionEvent event) throws IOException {
        Platform.exit();
    }
    public void loadInsertarEquipoPane(ActionEvent event) throws IOException {
        GridPane gridPane = (GridPane) FXMLLoader.load(JavaFxApplication.class.getResource("insertar-equipo.fxml"));
        BorderPane borderPane = JavaFxApplication.getRoot();
        borderPane.setCenter(gridPane);
    }
    public void loadVerEquiposPane(ActionEvent event) throws IOException {
        AnchorPane anchorPane =
                (AnchorPane) FXMLLoader.load(JavaFxApplication.class
                        .getResource("listar-equipos.fxml"));
        BorderPane borderPane = JavaFxApplication.getRoot();
        borderPane.setCenter(anchorPane);
    }
}