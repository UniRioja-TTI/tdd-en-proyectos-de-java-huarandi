package com.tt1.test;

import java.util.List;

public interface DB {
    void addToDo(ToDo t);

    void removeToDo(String name);

    ToDo getToDo(String name);

    void updateToDo(String name, ToDo t);

    boolean existToDo(String name);

    List<ToDo> getAllToDo();

    void addEmail(String email);

    void removeEmail(String email);

    List<String> getAllEmail();

    boolean existEmail(String email);
}
