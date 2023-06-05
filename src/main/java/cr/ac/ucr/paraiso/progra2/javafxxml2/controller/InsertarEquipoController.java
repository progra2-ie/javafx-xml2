package cr.ac.ucr.paraiso.progra2.javafxxml2.controller;

import cr.ac.ucr.paraiso.progra2.javafxxml2.data.EquipoFutbolXmlData;
import cr.ac.ucr.paraiso.progra2.javafxxml2.domain.EquipoFutbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertarEquipoController {
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfCantidad;
    @FXML
    private TextField tfNombre;
    @FXML
    private Label lblMensaje;
    @FXML
    private TextField tfRespuesta;

    public void onClickedBtnSalvar(ActionEvent event) throws IOException {
        try {
            EquipoFutbolXmlData equipoDao
                    = EquipoFutbolXmlData.abrirDocumento("d:\\MyStuff\\equiposFutbol.xml");
            EquipoFutbol equipo = new EquipoFutbol();
            equipo.setCodEquipo(tfCodigo.getText());
            equipo.setNombre(tfNombre.getText());
            equipo.setCantidadJugadoresInscritos(Integer.parseInt(
                    tfCantidad.getText()));
            equipoDao.insertarEquipo(equipo);
        } catch (JDOMException ex) {
            Logger.getLogger(InsertarEquipoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
