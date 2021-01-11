package controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import java.util.Optional;
import javafx.scene.control.ButtonType;


/**
 *
 * @author Nadir Essadi
 */
public class SignUpController {

    private static final Logger LOG = Logger.getLogger("controllers.SignUpController");

    private final int treinta = 30;
    private final int cincuenta = 50;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtContrasena;
    @FXML
    private PasswordField txtConfirmarContrasena;
    @FXML

    private Button btnRegistrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblContrasena;
    @FXML
    private Label lblEmailIncorrecto;
    @FXML
    private Label lblNocoinciden;
    @FXML
    private Label lblUsuarioError;
    @FXML
    private Label lblNombreError;

    private Stage stage = new Stage();
   // private Usuario usuario = new Usuario();

    public SignUpController() {

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
        LOG.log(Level.INFO, "Ventana SIGNUP");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("SignUp");
        stage.setResizable(false);
        stage.setOnShowing(this::handleWindowShowing);
        stage.setOnCloseRequest(this::handleWindowClose);

        //btnRegistrar.setOnAction(this::btnRegistrarClick);
        btnCancelar.setOnAction(this::hlCancerClick);
        
        txtUsuario.setText("");
        txtEmail.setText("");
        txtNombre.setText("");
        txtContrasena.setText("");
        txtConfirmarContrasena.setText("");
        /*
        txtUsuario.textProperty().addListener(this::txtChanged);
        txtEmail.textProperty().addListener(this::txtChanged);
        txtNombre.textProperty().addListener(this::txtChanged);
        txtContrasena.textProperty().addListener(this::txtChanged);
        txtConfirmarContrasena.textProperty().addListener(this::txtChanged);
*/
        stage.show();
    }

    /**
     * Al cerrar la ventana, saldrá un mensaje de confirmacion
     * @param event, WindowEvent
     */
    private void handleWindowClose(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("SignUp");
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
     * Configura los eventos al iniciar la ventana.
     *
     * @param event WindowEvent.
     */
    private void handleWindowShowing(WindowEvent event) {

        btnRegistrar.setDisable(true);
        lblEmailIncorrecto.setVisible(false);
        lblNocoinciden.setVisible(false);
        lblUsuarioError.setVisible(false);
        lblNombreError.setVisible(false);
        LOG.log(Level.INFO, "Beginning LoginController::handleWindowShowing");
    }

    /**
     * Valida los textos introducidos
     *
     * @param observable Observa los cambios
     * @param oldValue Valor antiguo
     * @param newValue Valor nuevo
     *//*
    private void txtChanged(ObservableValue observable, String oldValue, String newValue) {
        Validar.addTextLimiter(txtUsuario, treinta);
        Validar.addTextLimiterPass(txtContrasena, treinta);
        Validar.addTextLimiterGrande(txtEmail, cincuenta);
        Validar.addTextLimiterGrande(txtNombre, cincuenta);
        Validar.addTextLimiterPass(txtConfirmarContrasena, treinta);

        if (!txtUsuario.getText().trim().equals("") && !txtContrasena.getText().trim().equals("") && !txtEmail.getText().trim().equals("") && !txtNombre.getText().trim().equals("") && !txtConfirmarContrasena.getText().trim().equals("")) {
            boolean isValidEmail = Validar.isValidEmail(txtEmail, lblEmailIncorrecto, "Email invalido!", "Email valido");
            lblEmailIncorrecto.setVisible(true);

            boolean isValidContrasena = Validar.isValidContrasena(txtContrasena, txtConfirmarContrasena, lblNocoinciden, "No coinciden", "Coinciden");
            lblNocoinciden.setVisible(true);

            boolean isValidUsuario = Validar.isValid(txtUsuario, lblUsuarioError, "Usuario invalido!", "Usuario valido");
            lblUsuarioError.setVisible(true);

            boolean isValidNombre = Validar.isValid(txtNombre, lblNombreError, "Nombre invalido!", "Nombre valido");
            lblNombreError.setVisible(true);

            if (isValidEmail && isValidContrasena && isValidUsuario && isValidNombre) {
                btnRegistrar.setDisable(false);
            } else {
                btnRegistrar.setDisable(true);
            }
        }
        if (txtUsuario.getText().trim().equals("") || txtContrasena.getText().trim().equals("") || txtEmail.getText().trim().equals("") || txtNombre.getText().trim().equals("") || txtConfirmarContrasena.getText().trim().equals("")) {

            btnRegistrar.setDisable(true);

        }

    }*/

    /**
     * Dirige a la ventana LogIn e inicializa.
     *
     * @param event ActionEvento.
     */
    private void hlCancerClick(ActionEvent event) {
        LOG.log(Level.INFO, "Ventana LOGIN");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));

            Parent root = (Parent) loader.load();

            LogInController controller = ((LogInController) loader.getController());

            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Se ha producido un error de E/S");
        }
    }

    /**
     * Dirige a la ventana LogOut, la inicializa y envia usuario
     *
     * @param event ActionEvento.
     *//*
    private void btnRegistrarClick(ActionEvent event) {
        LOG.log(Level.INFO, "Ventana LOGOUT");
        usuario = new Usuario();
        usuario.setNombre(txtNombre.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setUsuario(txtUsuario.getText());
        usuario.setContrasena(txtContrasena.getText());
        usuario.setUltimaContrasenia(txtContrasena.getText());
        Signable signable = new SignableFactory().getSignableImplementation();
        Alert alert;
        try {
            signable.signUp(usuario);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));
                Parent root;
                root = (Parent) loader.load();
                LogOutController controller = ((LogOutController) loader.getController());
                controller.setUsuario(usuario);
                controller.initStage(root);
                stage.hide();
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Se ha producido un error de E/S");
            }

        } catch (EmailExistenteException ex) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email ya registrado");
            alert.showAndWait();
        } catch (ErrorBDException ex) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SIGNUP");
            alert.setHeaderText("Imposible conectar. Inténtelo más tarde");
            alert.showAndWait();
        } catch (ErrorServerException ex) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SIGNUP");
            alert.setHeaderText("Imposible conectar. Inténtelo más tarde");
            alert.showAndWait();
        } catch (UsuarioExistenteException ex) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Usuario ya registrado");
            alert.showAndWait();
        }
    }*/

}
