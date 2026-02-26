package com.tt1.test;

import java.util.Date;
import java.util.List;

public class Servicio {
    private final  Mailer mailer;
    private final  Repo repo;

    public Servicio(Mailer mailer, Repo repo) {
        this.mailer = mailer;
        this.repo = repo;
    }

    protected boolean hasFailedToDo(){
        return repo.getAllToDo().stream().anyMatch((ToDo t) -> t.getLimit().getTime() < System.currentTimeMillis());
    }

    protected boolean  notifyFailed(){
        boolean ret = true;
        
        List<String> em = repo.getAllEmail();
        for(String e: em){
            ret &= mailer.sendMail(e, "Hay tareas vencidas");
        }
        return ret;
    }

    public boolean  addToDo(String name, String desc, Date limit){
        if(repo.getToDo(name) != null) return false; 
        repo.addToDo(new ToDo(name, desc, limit, false));
        if(hasFailedToDo()) notifyFailed();
        return true;
    }

    public boolean completeToDo(ToDo t){
        if(hasFailedToDo()) notifyFailed();
        if(getUncompletedToDos().contains(t)) {
            repo.setCompletado(t, true);
            return true;
        }
        return false;
    }

    public List<ToDo> getUncompletedToDos(){
        if(hasFailedToDo()) notifyFailed();
        List<ToDo> ret = repo.getAllToDo().stream().filter((ToDo t) -> !t.isCompleted()).toList();
        return ret;
    }

    public boolean  addEmail(String email){
        if(repo.getAllEmail().contains(email)) return false;
        repo.addEmail(email);
        if(hasFailedToDo()) notifyFailed();
        return true;
    }
}
