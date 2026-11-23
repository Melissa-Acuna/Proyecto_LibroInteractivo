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
 * @author Yirlani Melissa Acuña C10057
 */
public class ControladorColores implements ActionListener {

    private Libro modelo;

    //contadores de respuestas
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;

    //control para saber qué preguntas ya fueron contestadas
    private boolean pregunta1Respondida = false;
    private boolean pregunta2Respondida = false;
    private boolean pregunta3Respondida = false;
    

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

        actividadColores.habilitarSiguiente(false);
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

                //lo modifiqué para que agregara los resultados de la actividad
            case "RESULTADOS":
                resultados.mostrarResultados(respuestasCorrectas, respuestasIncorrectas);

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

            //respuestas de la actividad
            case "NARANJA_CORRECTO":
                if (!pregunta1Respondida) {
                    respuestasCorrectas++;
                    pregunta1Respondida = true;

                    actividadColores.bloquearPregunta(1);
                    verificarActividad();
                }
                break;

            case "NARANJA_INCORRECTO":

                if (!pregunta1Respondida) {
                    respuestasIncorrectas++;
                    pregunta1Respondida = true;

                    actividadColores.bloquearPregunta(1);
                    verificarActividad();
                }
                break;

            case "VERDE_CORRECTO":

                if (!pregunta2Respondida) {
                    respuestasCorrectas++;
                    pregunta2Respondida = true;

                    actividadColores.bloquearPregunta(2);
                    verificarActividad();
                }
                break;

            case "VERDE_INCORRECTO":

                if (!pregunta2Respondida) {
                    respuestasIncorrectas++;
                    pregunta2Respondida = true;

                    actividadColores.bloquearPregunta(2);
                    verificarActividad();
                }
                break;

            case "MORADO_CORRECTO":

                if (!pregunta3Respondida) {
                    respuestasCorrectas++;
                    pregunta3Respondida = true;

                    actividadColores.bloquearPregunta(3);
                    verificarActividad();
                }
                break;

            case "MORADO_INCORRECTO":

                if (!pregunta3Respondida) {
                    respuestasIncorrectas++;
                    pregunta3Respondida = true;

                    actividadColores.bloquearPregunta(3);
                    verificarActividad();
                }
                break;
        }
    }

    //verifica si las preguntas fueron respondidas
    private void verificarActividad() {

        if (pregunta1Respondida && pregunta2Respondida && pregunta3Respondida) {
            actividadColores.habilitarSiguiente(true);
        }
    }

    public void iniciar() {

        vistaPrimarios.setLocationRelativeTo(null);
        vistaPrimarios.setVisible(true);
    }
}
