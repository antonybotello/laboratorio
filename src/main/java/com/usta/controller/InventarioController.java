package com.usta.controller;

import com.usta.model.Equipo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventarioController {

    // Componentes TextField
    @FXML
    private TextField nombreField;
    @FXML
    private TextField cantidadField;
    @FXML
    private TextField serieField;
    
    // Componentes de la tabla
    @FXML
    private TableView<Equipo> equiposTable; // La tabla de equipos en la interfaz
    @FXML
    private TableColumn<Equipo, String> nombreCol; // Columna para el nombre del equipo
    @FXML
    private TableColumn<Equipo, Integer> cantidadCol; // Columna para la cantidad del equipo
    @FXML
    private TableColumn<Equipo, String> serieCol; // Columna para el número de serie del equipo
    @FXML
    private TableColumn<Equipo, Equipo> siguienteCol; // Columna para la referencia al siguiente equipo en la lista
    
    // Lista observable de equipos para la tabla
    private ObservableList<Equipo> equiposData = FXCollections.observableArrayList();

    // Cabeza de la lista de equipos
    Equipo cabeza;

    // Método de inicialización del controlador
    @FXML
    public void initialize() {
        // Asignación de las propiedades de las columnas a los atributos de la clase Equipo
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cantidadCol.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        serieCol.setCellValueFactory(new PropertyValueFactory<>("numeroDeSerie"));
        siguienteCol.setCellValueFactory(new PropertyValueFactory<>("siguiente"));

        // Inicialización de la cabeza de la lista de equipos
        this.cabeza = null; // Inicialmente el inventario está vacío
    }   

    // Método para agregar un nuevo equipo al inventario
    @FXML
    public void agregarEquipo() {
        // Obtener los valores de los campos de texto
        String nombre = nombreField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());
        String serie = serieField.getText();
       
        // Crear un nuevo equipo con los valores obtenidos
        Equipo nuevoEquipo= new Equipo(nombre, cantidad, serie);
        
        // Agregar el nuevo equipo a la lista de equipos
        if (cabeza == null) {
            cabeza = nuevoEquipo; // Si la lista está vacía, el nuevo equipo será la cabeza
        } else {
            Equipo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoEquipo; // Agregamos el nuevo equipo al final de la lista
        }
        
        // Agregar el nuevo equipo a la lista observable para actualizar la tabla
        equiposData.add(nuevoEquipo);
        equiposTable.setItems(equiposData);
        
        // Limpiar los campos de texto después de agregar el equipo
        limpiarCampos();
    }
    
    // Método para limpiar los campos de texto
    private void limpiarCampos() {
        nombreField.clear();
        cantidadField.clear();
        serieField.clear();
    }
}
