package cl.duoc.com;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductoController {

    // lista observable
    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    // Interfaz tabla

    public VBox crearVista(){
        // TablaView
        TableView<Producto> tabla = new TableView<>();

        // Columna nombre
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");

        // Celda nombre
        colNombre.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().nombre()));

        // Columna categoria
        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoria");

        // Celda categoria
        colCategoria.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().categoria()));

        // Columna precio
        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");

        // Celda precio
        colPrecio.setCellValueFactory(dato -> new SimpleDoubleProperty(dato.getValue().precio()));

        // Agregar columnas a la tabla
        tabla.getColumns().addAll(colNombre, colCategoria, colPrecio);

        // Conectar la tabla con la lista
        tabla.setItems(productos);

        // Agregar datos iniciales de la tabla

        productos.add(new Producto("Balon de futbol", "Deportes", 20000));
        productos.add(new Producto("GTA 6", "Videojuegos", 90000));
        productos.add(new Producto("TV Samsung 70'", "Hogar", 350000));

        // Campo Nombre TEXTFIELD
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        // Campo categoria
        TextField txtCategoria = new TextField();
        txtCategoria.setPromptText("Categoria");

        // Campo precio
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        // Boton de agregar producto

        Button btnAgregar = new Button("Agregar Producto");

        // Ejecucion del boton
        btnAgregar.setOnAction(evento -> {
            // Variables dentro del boton, para agregar los campos txt

            String nombre = txtNombre.getText();
            String categoria = txtCategoria.getText();

            // Parsear de String a double el precio
            double precio =  Double.parseDouble(txtPrecio.getText());

            // Agregamos los productos a la lista observable
            productos.add(new Producto(nombre, categoria, precio));

            // Limpiar los campos
            txtNombre.clear();
            txtCategoria.clear();
            txtPrecio.clear();
        });
        return new VBox(10, tabla, txtNombre, txtCategoria, txtPrecio, btnAgregar);
    }
}
