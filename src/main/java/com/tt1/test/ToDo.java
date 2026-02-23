package com.tt1.test;

import java.io.Serializable;
import java.util.Date;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLimit() {
        return limit;
    }

    public void setLimit(Date limit) {
        this.limit = limit;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o instanceof ToDo t){
            return  this.name.equals(t.name) && this.limit.equals(t.limit);
        }
        return false;
    }
}
