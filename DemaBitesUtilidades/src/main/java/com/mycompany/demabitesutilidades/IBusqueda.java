package com.mycompany.demabitesutilidades;

import java.util.List;

/**
 * Interfaz que define cómo debe comportarse cualquier búsqueda en el sistema.
 * @author Emily Lara
 */
public interface IBusqueda {
    
    //Qué columnas va a llevar la tabla
    String[] getColumnas();
    
    //El método que irá a la base de datos a buscar según el texto
    List<?> buscar(String textoBusqueda);
    
    //Cómo transformar un objeto
    Object[] aFila(Object entidad);
    
}
