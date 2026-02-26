package com.tt1.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRepositorioServicio {

    final private List<ToDo> td = new ArrayList<>();
    final private List<String> em = new ArrayList<>();

    private Repo repo;
    private Mailer mailer;

    private Servicio ser;

    @BeforeEach
    public void init() {
        repo = new Repositorio(new DBStub());
        for (int i = 0; i < 10; i++) {
            repo.addToDo(new ToDo("td" + i, "desc" + i, new Date(System.currentTimeMillis() + 100000), false));
            repo.addEmail("em" + i);
        }
        ser = new Servicio(mailer, repo);
    }

    @Test
    public void hasFailedToDo() {
        Assertions.assertFalse(ser.hasFailedToDo());
        td.add(new ToDo("td" + 11, "desc" + 11, new Date(System.currentTimeMillis() - 100000), false));
        ser = new Servicio(new MailerStub(), new RepoStub(td, em));
        Assertions.assertTrue(ser.hasFailedToDo());
    }

    @Test
    public void addToDo() {
        ser.addToDo("1", "desc", new Date());
        Assertions.assertNotNull(repo.getToDo("1"));
    }

    @Test
    public void getUncompletedToDo() {
        List<ToDo> un = ser.getUncompletedToDos();
        for (ToDo tdo : td) {
            if (!un.contains(tdo)) {
                Assertions.fail();
            }
        }
        Assertions.assertTrue(true);
    }

    @Test
    public void completeToDo() {
        ToDo t = ser.getUncompletedToDos().getFirst();
        Assertions.assertTrue(ser.completeToDo(t));
        Assertions.assertTrue(repo.getToDo(t.getName()).isCompleted());
        Assertions.assertFalse(ser.completeToDo(new ToDo("no existente", "a", new Date(), false)));
    }

    @Test
    public void addEmail() {
        String em1 = "em134";
        Assertions.assertTrue(ser.addEmail(em1));
        Assertions.assertTrue(repo.getAllEmail().contains(em1));
        Assertions.assertFalse(ser.addEmail(em1));
    }
}
