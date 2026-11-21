/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.GUI_ActividadColores;
import vista.GUI_ColoresPrimarios;
import vista.GUI_ColoresSecundarios;
import vista.GUI_Menu;
import vista.GUI_Resultados;
import modelo.PaginaInformativa;
import modelo.PaginaActividad;

/**
 *
 * @author Yirlani
 */
public class ControladorSistema implements ActionListener {

    private Libro modelo;
    private ControladorColores controladorColores;

    // Vista
    private GUI_Menu vista;

    public ControladorSistema() {

        modelo = new Libro();
        vista = new GUI_Menu();
        
        prepararLibro();

        vista.addMenuListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {

            case "COLORES":
                abrirColores();
                break;

            case "FAMILIA":

                break;

            case "COMIDA":

                break;

            case "SALIR":
                System.exit(0);
                break;
        }
    }

    public void iniciar() {

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    public void abrirColores() {
        GUI_ColoresPrimarios vistaPrimarios = new GUI_ColoresPrimarios();
        GUI_ColoresSecundarios vistaSecundarios = new GUI_ColoresSecundarios();
        GUI_ActividadColores vistaActividad = new GUI_ActividadColores();
        GUI_Resultados vistaResultados = new GUI_Resultados();

        controladorColores = new ControladorColores(modelo, vista, vistaPrimarios, vistaSecundarios, vistaActividad, vistaResultados);

        vista.setVisible(false);

        controladorColores.iniciar();
    }

    private void prepararLibro() {

        modelo.agregarPagina(new PaginaInformativa(
                "Colores Primarios",
                1,
                "Los colores primarios son rojo, amarillo y azúl"
        ));
        
        modelo.agregarPagina(new PaginaInformativa(
                "Colores Secundarios",
                2,
                "Los colores secundarios se forman mezcalndo dos colores primarios"
        ));
        
        modelo.agregarPagina(new PaginaActividad(
                "Actividad de Colores",
                3,
                "Identifique qué colores se forman al mezclar los colores primarios"
        ));
    }

}
