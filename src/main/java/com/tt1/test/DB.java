package com.tt1.test;

import java.util.List;

/**
 * Interfaz de acceso a la base de datos.
 */
public interface DB {
    /**
     * Añade un ToDo a la base de datos. El ToDo no debe existir ya en la base de datos.
     * @param t
     */
    void addToDo(ToDo t);

    /**
     * Elimina el ToDo que tiene por nombre name. El ToDo debe existir en la base de datos.
     * @param name Nombre ToDo
     */
    void removeToDo(String name);

    /**
     * Devuelve el ToDo que tiene por nombre name. El ToDo debe existir en la base de datos.
     * @param name Nombre ToDo
     * @return
     */
    ToDo getToDo(String name);

    /**
     * Actualiza una entrada existente de un ToDo con nombre name con los datos de t.
     * @param name Nombre ToDo
     * @param t Nuevo ToDo
     */
    void updateToDo(String name, ToDo t);

    /**
     * Determina si ya existe un TODo con el nombre name.
     * @param name Nombre ToDo
     * @return
     */
    boolean existToDo(String name);

    /**
     * Devuelve una lista con todos los ToDo (completeados y no completados) regustrados.
     * @return
     */
    List<ToDo> getAllToDo();

    /**
     * Añade un nuevo mail a la base de datos. No debe haber ya un mail igual.
     * @param email
     */
    void addEmail(String email);

    /**
     * Elimina el mail de la base de datos. El mail debe existir.
     * @param email
     */
    void removeEmail(String email);

    /**
     * Devuelve una lista con todos los mail.
     * @return
     */
    List<String> getAllEmail();

    /**
     * Determina si existe el mail en la base de datos.
     * @param email
     * @return
     */
    boolean existEmail(String email);
}
