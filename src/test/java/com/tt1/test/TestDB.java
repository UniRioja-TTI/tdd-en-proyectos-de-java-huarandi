package com.tt1.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestDB {
    private DB db = new DBStub();

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

        final String ndesc = "ndesc";
        db.updateToDo(t1.getName(), new ToDo(t1.getName(), ndesc, t1.getLimit(), t1.isCompleted()));
        Assertions.assertEquals(ndesc, db.getToDo(t1.getName()).getDescription());
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
