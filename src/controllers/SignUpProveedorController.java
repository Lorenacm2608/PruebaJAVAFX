/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lorena
 */
public class SignUpProveedorController {

    private static final Logger LOG = Logger.getLogger(SignUpProveedorController.class.getName());

    @FXML
    private Pane pnRegistrar;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblEmpresa;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblTelefono;
    @FXML
    private TextField txtTipo;
    @FXML
    private TextField txtEmpresa;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Label lblDescripcion;

    private Stage stage = new Stage();

    /**
     * Recibe el escenario
     *
     * @return stage
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Establece el escenario
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Inicia el escenario
     *
     * @param root, clase parent
     */
    public void initStage(Parent root) {
        //Configuración de la ventana
        LOG.log(Level.INFO, "Ventana de registro (Proveedor)");

        Scene scene = new Scene(root);
        //((HBox) scene.getRoot()).getChildren().addAll(menuBar);
        stage.setScene(scene);
        stage.setTitle("Registro Proveedor");
        stage.setResizable(false);

        stage.show();

    }

}
