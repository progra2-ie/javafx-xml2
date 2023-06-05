module cr.ac.ucr.paraiso.progra2.javafxxml2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdom2;
    requires java.logging;


    opens cr.ac.ucr.paraiso.progra2.javafxxml2 to javafx.fxml;
    opens cr.ac.ucr.paraiso.progra2.javafxxml2.controller to javafx.fxml;
    opens cr.ac.ucr.paraiso.progra2.javafxxml2.domain to javafx.base;
    exports cr.ac.ucr.paraiso.progra2.javafxxml2;
}