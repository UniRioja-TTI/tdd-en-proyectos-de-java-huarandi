package com.tt1.test;

import java.util.List;

public class Repositorio {
    public DB db;

    public Repositorio(DB db){
        this.db = db;
    }

    public ToDo getToDo(String name){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ToDo> getAllToDo(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setCompletado(ToDo t, boolean completado){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addToDo(ToDo t){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addEmail(String email){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> getAllEmail(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
