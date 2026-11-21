/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Libro;
import vista.GUI_ActividadColores;
import vista.GUI_Menu;
import vista.GUI_ColoresPrimarios;
import vista.GUI_ColoresSecundarios;
import vista.GUI_Resultados;

/**
 *
 * @author Yirlani
 * Melissa Acuña C10057
 */
public class ControladorColores implements ActionListener {

    private Libro modelo;

    // Vistas
    private GUI_Menu vistaMenu;
    private GUI_ColoresPrimarios vistaPrimarios;
    private GUI_ColoresSecundarios vistaSecundarios;
    private GUI_ActividadColores actividadColores;
    private GUI_Resultados resultados;

    public ControladorColores(Libro modelo, GUI_Menu vistaMenu, GUI_ColoresPrimarios vistaPrimarios, GUI_ColoresSecundarios vistaSecundarios, GUI_ActividadColores actividadColores, GUI_Resultados resultados) {
        this.modelo = modelo;
        this.vistaMenu = vistaMenu;
        this.vistaPrimarios = vistaPrimarios;
        this.vistaSecundarios = vistaSecundarios;
        this.actividadColores = actividadColores;
        this.resultados = resultados;
        vistaPrimarios.addButtonListener(this);
        vistaSecundarios.addButtonListener(this);
        actividadColores.addButtonListener(this);
        resultados.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String op = e.getActionCommand();

        switch (op) {

            case "SIGUIENTE":
            vistaPrimarios.setVisible(false);
            vistaSecundarios.setLocationRelativeTo(null);
            vistaSecundarios.setVisible(true);
            break;

        case "ACTIVIDAD":
            vistaSecundarios.setVisible(false);
            actividadColores.setLocationRelativeTo(null);
            actividadColores.setVisible(true);
            break;

        case "RESULTADOS":
            actividadColores.setVisible(false);
            resultados.setLocationRelativeTo(null);
            resultados.setVisible(true);
            break;

        case "VOLVER AL MENU":
            vistaPrimarios.setVisible(false);
            vistaMenu.setVisible(true);
            vistaSecundarios.setVisible(false);
            actividadColores.setVisible(false);
            resultados.setVisible(false);
            vistaMenu.setVisible(true);
            break;

        case "REGRESAR":
            vistaSecundarios.setVisible(false);
            vistaPrimarios.setVisible(true);
            break;

        case "REGRESAR_ACTIVIDAD":
            actividadColores.setVisible(false);
            vistaSecundarios.setVisible(true);
            break;

        case "REGRESAR_RESULTADOS":
            resultados.setVisible(false);
            actividadColores.setVisible(true);
            break;

        case "SALIR":
            System.exit(0);
            break;
    }
    }

    public void iniciar() {

        vistaPrimarios.setLocationRelativeTo(null);
        vistaPrimarios.setVisible(true);
    }
}
