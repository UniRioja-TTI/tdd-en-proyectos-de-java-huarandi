package com.tt1.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Tarea a realizar.
 */
public class ToDo implements Serializable {
    private String name;
    private String description;
    private Date limit;
    private boolean completed;

    public ToDo(){

    }

    public ToDo(String name, String description, Date limit, boolean completed){
        this.completed = completed;
        this.description = description;
        this.limit = limit;
        this.name = name;
    }

    /**
     * Devuelve el nombre del ToDo.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del ToDo.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve la descripción del ToDo.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descipcion del ToDO.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la fecha límite para completar la tarea.
     * @return
     */
    public Date getLimit() {
        return limit;
    }

    /**
     * Devuelve la fecha límite para completar la tarea
     * @param limit
     */
    public void setLimit(Date limit) {
        this.limit = limit;
    }

    /**
     * Determina si la tarea está completada.
     * @return
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Establece el estado de completitud del ToDo.
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof ToDo){
            ToDo t = (ToDo) o;
            return  this.name.equals(t.name) && this.limit.equals(t.limit);
        }
        return false;
    }
}
