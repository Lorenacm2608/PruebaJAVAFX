/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxApplication;

import controllers.InicioAdministradorProveedorController;
import controllers.ListaDeProductosController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author Lorena Cáceres Manuel
 */
public class PruebaVentanasFX extends Application {

    private static final Logger LOG = Logger.getLogger(PruebaVentanasFX.class.getName());

    @Override
    public void start(Stage primaryStage) {
        try {
            LOG.log(Level.INFO, "Iniciando la ventana");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/inicioAdministrador_proveedor.fxml"));
            LOG.log(Level.INFO, "Cargando Parent");
            Parent root = (Parent) loader.load();
            LOG.log(Level.INFO, "Cargando controller");
            InicioAdministradorProveedorController controller = ((InicioAdministradorProveedorController) loader.getController());
            LOG.log(Level.INFO, "Iniciando controller");
            controller.setStage(primaryStage);
            controller.initStage(root);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Se ha producido un error de E/S");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
