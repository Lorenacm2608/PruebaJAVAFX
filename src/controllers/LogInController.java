package controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Optional;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author Moroni Collazos Fiestas
 */
public class LogInController {

    private static final Logger LOG = Logger.getLogger("controllers.LogInController");
    private final int treinta = 30;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Button btnIniciar;
    @FXML
    private Hyperlink hlRegistrarse;
    @FXML
    private Label lblerrorusuario;

    private Stage stage = new Stage();
    //private Usuario usuario;

    public LogInController() {

    }

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
        LOG.log(Level.INFO, "Ventana LOGIN");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.setResizable(false);
        stage.setOnCloseRequest(this::handleWindowClose);
        stage.setOnShowing(this::handleWindowShowing);
        //btnIniciar.setOnAction(this::btnIniciarClick);
        btnIniciar.setTooltip(new Tooltip("Pulse para iniciar sesion "));

        //txtUsuario.textProperty().addListener(this::txtChanged);
        //txtContrasena.textProperty().addListener(this::txtChanged);
        //hlRegistrarse.setOnAction(this::hlRegistrarseClick);
        stage.show();

    }

    /**
     * Al cerrar la ventana, saldrá un mensaje de confirmacion
     *
     * @param event, WindowEvent
     */
    private void handleWindowClose(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("LogIn");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> respuesta = alert.showAndWait();

        if (respuesta.get() == ButtonType.OK) {
            LOG.log(Level.INFO, "Has pulsado el boton Aceptar");
            stage.hide();
        } else {
            LOG.log(Level.INFO, "Has pulsado el boton Cancelar");
            event.consume();
        }
    }

    /**
     * Configura los eventos al iniciar la ventana
     *
     * @param event WindowEvent
     */
    private void handleWindowShowing(WindowEvent event) {
        btnIniciar.setDisable(true);
        lblerrorusuario.setVisible(false);
        LOG.log(Level.INFO, "Beginning LoginController::handleWindowShowing");

    }

    /**
     * Valida los textos introducidos
     *
     * @param observable Observa los cambios
     * @param oldValue Valor antiguo
     * @param newValue Valor nuevo
     *
     * private void txtChanged(ObservableValue observable, String oldValue,
     * String newValue) { Validar.addTextLimiter(txtUsuario, treinta);
     * Validar.addTextLimiterPass(txtContrasena, treinta); if
     * (!txtUsuario.getText().trim().equals("") &&
     * !txtContrasena.getText().trim().equals("")) { boolean isValidUsuario =
     * Validar.isValid(txtUsuario, lblerrorusuario, "usuario invalido", "usuario
     * valido"); lblerrorusuario.setVisible(true); if (isValidUsuario) {
     * btnIniciar.setDisable(false); } else { btnIniciar.setDisable(true);
     *
     * }
     * }
     * if (txtUsuario.getText().trim().equals("") ||
     * txtContrasena.getText().trim().equals("")) {
     *
     * btnIniciar.setDisable(true);
     *
     * }
     * }
     * LOG.log(Level.INFO, "Ventana Alta Proveedor (SignUp_Proveedor)"); try {
     * FXMLLoader loader = new
     * FXMLLoader(getClass().getResource("/view/SignUpProveedorView.fxml"));
     *
     * Parent root = (Parent) loader.load();
     *
     * SignUpProveedorController controller = ((SignUpProveedorController)
     * loader.getController()); controller.initStage(root); stage.hide(); }
     * catch (IOException e) { LOG.log(Level.SEVERE, "Se ha producido un error
     * de E/S");
        }
     */
    /**
     * Dirige a la ventana LogOut, la inicializa y envia usuario
     *
     * @param event ActionEvent
     *
     * private void btnIniciarClick(ActionEvent event) { LOG.log(Level.INFO,
     * "Ventana LOGOUT"); usuario = new Usuario();
     * usuario.setUsuario(txtUsuario.getText());
     * usuario.setContrasena(txtContrasena.getText()); Signable signable = new
     * SignableFactory().getSignableImplementation(); Alert alert;
     * txtUsuario.setText(""); txtContrasena.setText(""); try {
     * signable.logIn(usuario); try { FXMLLoader loader = new
     * FXMLLoader(getClass().getResource("/view/LogOut.fxml"));
     *
     * Parent root = (Parent) loader.load();
     *
     * //LogOutController controller = ((LogOutController)
     * loader.getController()); controller.setUsuario(usuario);
     * controller.initStage(root); stage.hide(); } catch (IOException e) {
     * LOG.log(Level.SEVERE, "Se ha producido un error de E/S"); } } catch
     * (AutenticacionFallidaException ex) { alert = new Alert(AlertType.ERROR);
     * alert.setTitle("Error"); alert.setHeaderText("Contraseña Incorrecta");
     * alert.showAndWait(); } catch (ErrorBDException ex) { alert = new
     * Alert(AlertType.INFORMATION); alert.setTitle("LOGIN");
     * alert.setHeaderText("Imposible conectar. Inténtelo más tarde");
     * alert.showAndWait(); } catch (ErrorServerException ex) { alert = new
     * Alert(AlertType.INFORMATION); alert.setTitle("LOGIN");
     * alert.setHeaderText("Imposible conectar. Inténtelo más tarde");
     * alert.showAndWait(); } catch (UsuarioNoEncontradoException ex) { alert =
     * new Alert(AlertType.ERROR); alert.setTitle("Error");
     * alert.setHeaderText("No se ha encontrado el usuario introducido");
     * alert.showAndWait(); }
     *
     * }
     */
    /**
     * Dirige a la ventana SignUp y la inicializa
     *
     * @param event ActionEvent
     
    private void hlRegistrarseClick(ActionEvent event) {
        LOG.log(Level.INFO, "Ventana LOGOUT");
        usuario = new Usuario();
        usuario.setNombre(txtUsuario.getText());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));

            Parent root = (Parent) loader.load();

            SignUpController controller = ((SignUpController) loader.getController());
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Se ha producido un error de E/S");
        }
    }*/

}
