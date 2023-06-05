package cr.ac.ucr.paraiso.progra2.javafxxml2.controller;

import cr.ac.ucr.paraiso.progra2.javafxxml2.data.EquipoFutbolXmlData;
import cr.ac.ucr.paraiso.progra2.javafxxml2.domain.EquipoFutbol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarEquiposController {
    @FXML
    private TableView tvEquipos;
    @FXML
    private ComboBox<EquipoFutbol> cbEquipos;
    private EquipoFutbolXmlData equipoFutbolDao;
    @FXML
    private TableColumn<EquipoFutbol, String> tcCodEquipoCol;
    @FXML
    private TableColumn<EquipoFutbol, String> tcNombreEquipoCol;

    @FXML
    public void initialize() {
        try {
            equipoFutbolDao =
                    EquipoFutbolXmlData.abrirDocumento("d:\\MyStuff\\equiposFutbol.xml");
            ObservableList<EquipoFutbol> list =
                    FXCollections.observableArrayList(equipoFutbolDao.getEquipos());
            tvEquipos.setItems(list);
            tcCodEquipoCol = new TableColumn<>("Código");
            PropertyValueFactory<EquipoFutbol, String> fCodEquipoValueFactory
                    = new PropertyValueFactory<>("codEquipo");
            tcCodEquipoCol.setCellValueFactory(fCodEquipoValueFactory);
            tvEquipos.getColumns().add(tcCodEquipoCol);

            tcNombreEquipoCol = new TableColumn<>("Nombre Equipo");
            PropertyValueFactory<EquipoFutbol, String> fNombreValueFactory
                    = new PropertyValueFactory<>("nombre");
            tcNombreEquipoCol.setCellValueFactory(fNombreValueFactory);
            tvEquipos.getColumns().add(tcNombreEquipoCol);

            //tvEquipos.getColumns().remove(0);
            tvEquipos.refresh();

            //cbEquipos.getItems().setAll(list);
            cbEquipos.setItems(list);
            cbEquipos.getSelectionModel().selectFirst();


        } catch (JDOMException ex) {
            Logger.getLogger(ListarEquiposController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListarEquiposController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
