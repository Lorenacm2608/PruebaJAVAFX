package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Administrador;
import modelo.Proveedor;
import modelo.TipoProducto;
import static modelo.TipoProducto.ROPA;

/**
 * FXML Controller class
 *
 * @author Lorena Cáceres Manuel
 */
public class InicioAdministradorProveedorController {

    private static final Logger LOG = Logger.getLogger(InicioAdministradorProveedorController.class.getName());

    private Stage stage = new Stage();
    @FXML
    private Pane pnInicioAdminProv;
    @FXML
    private Label lblProveedor;
    @FXML
    private VBox Vbox;
    @FXML
    private HBox Hbox;
    @FXML
    private Button btnAltaProveedor;
    @FXML
    private Button btnBorrarProveedor;
    @FXML
    private Button btnActualizarProveedor;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuPerfil;
    @FXML
    private MenuItem menuAdministrador;
    @FXML
    private Menu menuVendedor;
    @FXML
    private MenuItem menuSalir;
    @FXML
    private MenuItem menuVendedores;
    @FXML
    private TableView<?> tbProveedor;
    @FXML
    private TableColumn<Proveedor, Long> tcId;
    @FXML
    private TableColumn<Proveedor, String> tcNombre;
    @FXML
    private TableColumn<Proveedor, TipoProducto> tcTipo;
    @FXML
    private TableColumn<Proveedor, String> tcEmpresa;
    @FXML
    private TableColumn<Proveedor, String> tcEmail;
    @FXML
    private TableColumn<Proveedor, String> tcTelefono;
    @FXML
    private TableColumn<Proveedor, String> tcDescripcion;
    @FXML
    private TableColumn<Proveedor, Administrador> tcAdmin;

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
        /* //opcionesMenu();
        menuBar = new MenuBar();

        menuPerfil = new Menu("Perfil");
        //Opción del menú -- Vendedor
        menuVendedor = new Menu("Vendedor");
        //Añadimos el menuItem Administrador a la opción de menú de Perfil
        menuAdministrador = new MenuItem("Administrador");
        //ActionEvent de menuAdministrador
        menuAdministrador.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU ADMINISTRADOR");
        });
        //Opción del menú -- Salir
        menuSalir = new MenuItem("Salir");
        //ActionEvent de menuSalir
        menuSalir.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU SALIR");
        });
        //Opción de menú -- Lista de vendedores
        menuVendedores = new MenuItem("Lista de vendedores");
        //ActionEvent de menuVendedores
        menuVendedores.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU VENDEDORES");
        });
        //Añadimos a la barra de menú las opciones creadas
        menuBar.getMenus().addAll(menuPerfil, menuVendedor);
        //Añadimos al de menú Perfil las opciones de submenú creadas
        menuPerfil.getItems().addAll(menuAdministrador, menuSalir);
        //Añadimos al de menú Vendedor las opciones de submenú creadas
        menuVendedor.getItems().add(menuVendedores);
         */
        tcId.setCellFactory(new PropertyValueFactory<>("idProveedor"));
        tcNombre.setCellFactory(new PropertyValueFactory<>("nombre"));
        tcTipo.setCellFactory(new PropertyValueFactory<>("tipo"));
        tcEmpresa.setCellFactory(new PropertyValueFactory<>("empresa"));
        tcEmail.setCellFactory(new PropertyValueFactory<>("email"));
        tcTelefono.setCellFactory(new PropertyValueFactory<>("telefono"));
        tcDescripcion.setCellFactory(new PropertyValueFactory<>("descripcion"));
        tcAdmin.setCellFactory(new PropertyValueFactory<>("administrador"));
        
        

        LOG.log(Level.INFO, "Ventana Inicio de Administrador (Proveedor)");
        Scene scene = new Scene(root);
        //((HBox) scene.getRoot()).getChildren().addAll(menuBar);
        stage.setScene(scene);
        stage.setTitle("Administrador");
        stage.setResizable(false);
        imagenBotones();
        stage.setOnCloseRequest(this::handleWindowClose);
        stage.setOnShowing(this::handleWindowShowing);
        btnAltaProveedor.setOnAction(this::btnAltaProveedorClick);
        stage.show();

    }

    /**
     * Al cerrar la ventana, saldrá un mensaje de confirmacion
     *
     * @param event, WindowEvent
     */
    private void handleWindowClose(WindowEvent event) {
        LOG.log(Level.INFO, "Beginning InicioAdministradorProveedorController::handleWindowClose");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Administrador");
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
        LOG.log(Level.INFO, "Beginning InicioAdministradorProveedorController::handleWindowShowing");
        btnActualizarProveedor.setDisable(true);
        btnBorrarProveedor.setDisable(true);

    }

    private void btnAltaProveedorClick(ActionEvent event) {
        LOG.log(Level.INFO, "Ventana Alta Proveedor (SignUp_Proveedor)");
        /*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));

            Parent root = (Parent) loader.load();

            SignUpController controller = ((SignUpController) loader.getController());
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Se ha producido un error de E/S");
        }*/
    }

    private void imagenBotones() {
        //Creamos un objeto y en él guardaremos la ruta donde se encuentra las imagenes para los botones
        URL linkAlta = getClass().getResource("/img/usuario.png");
        URL linkBorrar = getClass().getResource("/img/eliminar.png");
        URL linkActualizar = getClass().getResource("/img/refrescar.png");

        //Instanciamos una imagen pasándole la ruta de las imagenes y las medidas del boton 
        Image imageAlta = new Image(linkAlta.toString(), 32, 32, false, true);
        Image imageBorrar = new Image(linkBorrar.toString(), 32, 32, false, true);
        Image imageActualizar = new Image(linkActualizar.toString(), 32, 32, false, true);

        //Añadimos la imagen a los botones que deban llevar icono
        btnAltaProveedor.setGraphic(new ImageView(imageAlta));
        btnBorrarProveedor.setGraphic(new ImageView(imageBorrar));
        btnActualizarProveedor.setGraphic(new ImageView(imageActualizar));

    }

    private void getProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor = null;
        Administrador administrador;
        for (int i = 0; i < proveedores.size(); i++) {
            proveedor = new Proveedor();
            administrador = new Administrador();
            proveedor.setIdProveedor(Long.valueOf(i));
            proveedor.setNombre("Lucas");
            proveedor.setTipo(ROPA);
            proveedor.setEmpresa("Nike");
            proveedor.setEmail("lucas@gmail.com");
            proveedor.setTelefono("927500299");
            proveedor.setDescripcion("Producto muy recomendado");
            proveedor.setAdministrador(administrador);
        }
        proveedores.add(proveedor);
    }

    private void opcionesMenu() {
        /* //Barra de menú
        menuBar = new MenuBar();
        //Opción del menú -- Perfil
        menuPerfil = new Menu();
        //Opción del menú -- Vendedor
        menuVendedor = new Menu();
        //Añadimos el menuItem Administrador a la opción de menú de Perfil
        menuAdministrador = new MenuItem("Administrador");
        //Opción del menú -- Salir
        menuSalir = new MenuItem("Salir");
        //Opción de menú -- Lista de vendedores
        menuVendedores = new MenuItem("Lista de vendedores");
        //Añadimos a la barra de menú las opciones creadas
        menuBar.getMenus().addAll(menuPerfil, menuVendedor);
        //Añadimos al de menú Perfil las opciones de submenú creadas
        menuPerfil.getItems().addAll(menuAdministrador, menuSalir);
        //Añadimos al de menú Vendedor las opciones de submenú creadas
        menuVendedor.getItems().add(menuVendedores);
        return menuBar;*/
        LOG.log(Level.INFO, "MENU");
        //Scene scene = new Scene(new VBox(), 400, 350);

        menuBar = new MenuBar();

        menuPerfil = new Menu("Perfil");
        //Opción del menú -- Vendedor
        menuVendedor = new Menu("Vendedor");
        //Añadimos el menuItem Administrador a la opción de menú de Perfil
        menuAdministrador = new MenuItem("Administrador");
        //ActionEvent de menuAdministrador
        menuAdministrador.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU ADMINISTRADOR");
        });
        //Opción del menú -- Salir
        menuSalir = new MenuItem("Salir");
        //ActionEvent de menuSalir
        menuSalir.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU SALIR");
        });
        //Opción de menú -- Lista de vendedores
        menuVendedores = new MenuItem("Lista de vendedores");
        //ActionEvent de menuVendedores
        menuVendedores.setOnAction((ActionEvent t) -> {
            LOG.log(Level.INFO, "MENU VENDEDORES");
        });
        //Añadimos a la barra de menú las opciones creadas
        menuBar.getMenus().addAll(menuPerfil, menuVendedor);
        //Añadimos al de menú Perfil las opciones de submenú creadas
        menuPerfil.getItems().addAll(menuAdministrador, menuSalir);
        //Añadimos al de menú Vendedor las opciones de submenú creadas
        menuVendedor.getItems().add(menuVendedores);

        //((VBox) scene.getRoot()).getChildren().addAll(menuBar);
        //stage.setScene(scene);
        //stage.show();
    }

}
