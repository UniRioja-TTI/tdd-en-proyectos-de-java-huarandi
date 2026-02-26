package com.tt1.test;

import java.util.ArrayList;
import java.util.List;

public class DBStub implements DB {
    private final List<ToDo> td = new ArrayList<>();
    private final List<String> em = new ArrayList<>();
    
    @Override
    public void addToDo(ToDo t){
        td.add(t);
    }

    @Override
    public void removeToDo(String name){
        for(ToDo t: td){
            if(t.getName().equals(name)){
                td.remove(t);
                return;
            }
        }
    }

    @Override
    public ToDo getToDo(String name){
        for(ToDo t: td){
            if(t.getName().equals(name)) return t;
        }
        return null;
    }

    @Override
    public void updateToDo(String name, ToDo t){
        for(ToDo to: td){
            if(to.getName().equals(name)){
                to.setName(t.getName());
                to.setDescription(t.getDescription());
                to.setLimit(t.getLimit());
                to.setCompleted(t.isCompleted());
                return;
            }
        }
    }

    @Override
    public boolean existToDo(String name) {
        for(ToDo t: td){
            if(t.getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public List<ToDo> getAllToDo() {
        //Sería mejor práctica hacer una deepcopy, pero como es un stub, vamos a mantenerlo simple.
        return td;
    }

    @Override
    public void addEmail(String email) {
        em.add(email);
    }

    @Override
    public void removeEmail(String email) {
        em.remove(email);
    }

    @Override
    public List<String> getAllEmail() {
        //Igual que para getAllToDo().
        return em;
    }
    
    @Override
    public boolean existEmail(String email) {
        for(String e: em){
            if(e.equals(email)) return true;
        }
        return false;
    }
}
