package com.tt1.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestRepositorio {
    private DB db = new DBStub();
    private Repositorio repositorio = new Repositorio(db);

    private final ToDo t1 = new ToDo("1", "1", new Date(), false);
    private final ToDo t2 = new ToDo("2", "2", new Date(), false);

    private final String em1 = "email1";
    private final String em2 = "email2";

    @Test
    public void addGetToDo(){
        repositorio.addToDo(t1);
        Assertions.assertEquals(t1, repositorio.getToDo(t1.getName()));
    }

    @Test
    public void getAllToDo(){
        repositorio.addToDo(t1);
        repositorio.addToDo(t2);
        Assertions.assertEquals(2, repositorio.getAllToDo().size());
        Assertions.assertTrue(repositorio.getAllToDo().contains(t1));
        Assertions.assertTrue(repositorio.getAllToDo().contains(t2));
    }

    @Test
    public void setCompletado(){
        repositorio.addToDo(t1);
        repositorio.setCompletado(t1, true);
        Assertions.assertTrue(repositorio.getToDo(t1.getName()).isCompleted());
    }

    @Test
    public void addEmail(){
        repositorio.addToDo(t1);
    }
}
