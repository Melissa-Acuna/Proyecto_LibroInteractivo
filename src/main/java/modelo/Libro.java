/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Yirlani
 */
public class Libro {

    private ArrayList<Pagina> paginas;

    public Libro() {
        paginas = new ArrayList<>();
    }

    //agrega pagina al libro
    public void agregarPagina(Pagina pagina) {

        if (pagina != null) {
            paginas.add(pagina);
        }
    }

    //busca pagina por numero
    public Pagina buscarPagina(int numeroPagina) {

        for (int i = 0; i < paginas.size(); i++) {

            Pagina pagina = paginas.get(i);

            if (pagina.getNumeroPagina() == numeroPagina) {
                return pagina;
            }
        }

        return null;
    }

    //obtiene pagina por posicion
    public Pagina obtenerPagina(int posicion) {

        if (posicion < 0 || posicion >= paginas.size()) {
            return null;
        }

        return paginas.get(posicion);
    }

    public int getCantidadPaginas() {
        return paginas.size();
    }

    public ArrayList<Pagina> getPaginas() {
        return new ArrayList<>(paginas);
    }
    
}
