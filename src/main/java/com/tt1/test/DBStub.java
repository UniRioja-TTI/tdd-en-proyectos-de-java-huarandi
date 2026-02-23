package com.tt1.test;

import java.util.List;

public class DBStub implements DB {
    public void addToDo(ToDo t){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeToDo(String name){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ToDo getToDo(String name){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateToDo(String name, ToDo t){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean existToDo(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ToDo> getAllToDo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addEmail(String email) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }

    public void removeEmail(String email) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }

    public List<String> getAllEmail() {
        throw  new UnsupportedOperationException("Not supported yet.");
    }

    public boolean existEmail(String email) {
        throw  new UnsupportedOperationException("Not supported yet.");
    }
}
