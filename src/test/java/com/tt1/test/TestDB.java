package com.tt1.test;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDB {
    private final DB db = new DBStub();

    private final ToDo t1 = new ToDo("1", "1", new Date(), false);
    private final ToDo t2 = new ToDo("2", "2", new Date(), false);

    private final String em1 = "email1";
    private final String em2 = "email2";

    @Test
    public void addGetToDo(){
        db.addToDo(t1);
        Assertions.assertEquals(t1, db.getToDo(t1.getName()));
    }

    @Test
    public void removeToDo(){
        db.addToDo(t1);
        db.removeToDo(t1.getName());
        Assertions.assertEquals(0, db.getAllToDo().size());
    }

    @Test
    public void getAllToDo(){
        db.addToDo(t1);
        db.addToDo(t2);
        Assertions.assertEquals(2, db.getAllToDo().size());
        Assertions.assertTrue(db.getAllToDo().contains(t1));
        Assertions.assertTrue(db.getAllToDo().contains(t2));
    }

    @Test
    public void updateToDo(){
        db.addToDo(t1);

        final String nname = "nname";
        final String ndesc = "ndesc";
        final Date nlimit = new Date();
        final boolean ncomp = !t1.isCompleted();

        db.updateToDo(t1.getName(), new ToDo(nname, ndesc, nlimit, ncomp));
        
        Assertions.assertEquals(nname, t1.getName());
        Assertions.assertEquals(ndesc, t1.getDescription());
        Assertions.assertEquals(nlimit, t1.getLimit());
        Assertions.assertEquals(ncomp, t1.isCompleted());
    }

    @Test
    public void existToDo(){
        db.addToDo(t1);
        Assertions.assertTrue(db.existToDo(t1.getName()));
    }

    @Test
    public void addExistEmail(){
        db.addEmail(em1);
        Assertions.assertTrue(db.existEmail(em1));
    }

    @Test
    public void removeEmail(){
        db.addEmail(em1);
        db.removeEmail(em1);
        Assertions.assertFalse(db.existEmail(em1));
    }

    @Test
    public void getAllEmail(){
        db.addEmail(em1);
        db.addEmail(em2);
        Assertions.assertEquals(2, db.getAllEmail().size());
        Assertions.assertTrue(db.getAllEmail().contains(em1));
        Assertions.assertTrue(db.getAllEmail().contains(em2));
    }
}
