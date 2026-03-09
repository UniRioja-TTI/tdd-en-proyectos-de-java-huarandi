package com.tt1.test;

import java.util.List;

/**
 * Repositorio de tareas.
 */
public interface Repo {
    /**
     * Devuelve el ToDo del repositorio con nombre name. Si no existe en el repositorio, devuelve null.
     * @param name
     * @return
     */
    public ToDo getToDo(String name);

    /**
     * Devuelve una lista con todos los ToDo del repositorio.
     * @return Lista de todos los ToDo.
     */
    List<ToDo> getAllToDo();

    /**
     * Cambia el estado de completado en el repositorio del ToDo t.
     * @param t
     * @param completado
     */
    void setCompletado(ToDo t, boolean completado);

    /**
     * Añade el ToDo t al repositorio. No debe existir ya un ToDo con el mismo nombre.
     * @param t
     */
    void addToDo(ToDo t);

    /**
     * Añade el mail al repositorio. No debe existir ya un mail igual en el repositorio.
     * @param email
     */
    void addEmail(String email);

    /**
     * Devuelve una lista con todos los mails del repositorio.
     * @return
     */
    List<String> getAllEmail();
}
