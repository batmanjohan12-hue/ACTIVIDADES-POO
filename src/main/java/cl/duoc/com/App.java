package cl.duoc.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    /// Mostrar tabla
    @Override
    public void start(Stage stage){
        // Controller de la pantalla
        ProductoController controller = new ProductoController();

        // Escena con la vista del controller
        Scene scene = new Scene(controller.crearVista(), 620, 400);

        // Ventana principal

        stage.setTitle("Productos");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        // Iniciar tabla
        launch();
    }


}
