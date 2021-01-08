package controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lorena Cáceres Manuel
 */
public class ReservaController {

    private static final Logger LOG = Logger.getLogger(ReservaController.class.getName());

    @FXML
    private Pane pnReserva;
    @FXML
    private Label lblReservas;
    @FXML
    private TableView<?> tbReservas;
    @FXML
    private Button btnVolver;

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
        LOG.log(Level.INFO, "Ventana de Reservas");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Reservas");
        stage.setResizable(false);
        stage.show();

    }

}
