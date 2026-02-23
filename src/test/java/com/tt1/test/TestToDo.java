package com.tt1.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestToDo {
    private final String name = "ejemplo";
    private final String desc = "tarea de ejemplo";
    private final Date limit = new Date("1 Mar 2026");
    private final boolean comp = false;

    private ToDo tej;

    @BeforeEach
    public void init(){
        tej = new ToDo(name, desc, limit, comp);
    }

    @Test
    public void getName(){
        Assertions.assertEquals(name, tej.getName());
    }

    @Test
    public void setName() {
        String toset = "new name";
        tej.setName(toset);
        Assertions.assertEquals(toset, tej.getName());
    }

    @Test
    public void getDescription() {
        Assertions.assertEquals(desc, tej.getDescription());
    }

    @Test
    public void setDescription() {
        String toset = "new desc";
        tej.setDescription(toset);
        Assertions.assertEquals(toset, tej.getDescription());
    }

    @Test
    public void getDate(){
        Assertions.assertEquals(limit, tej.getLimit());
    }

    @Test
    public void setDate(){
        Date toset = new Date("2 Mar 2026");
        tej.setLimit(toset);
        Assertions.assertEquals(toset, tej.getLimit());
    }

    @Test
    public void getComp(){
        Assertions.assertEquals(comp, tej.isCompleted());
    }

    @Test
    public void setComp(){
        boolean toset = true;
        tej.setCompleted(toset);
        Assertions.assertEquals(toset, tej.isCompleted());
    }
}
