package com.tt1.test;

import java.util.Date;
import java.util.List;

/**
 * Servicios ofrecidos por la app de tareas.
 */
public class Servicio {
    private final  Mailer mailer;
    private final  Repo repo;

    public Servicio(Mailer mailer, Repo repo) {
        this.mailer = mailer;
        this.repo = repo;
    }

    /**
     * Determina si el repositorio tiene tareas que han superado su fecha límite.
     * @return
     */
    protected boolean hasFailedToDo(){
        return repo.getAllToDo().stream().anyMatch((ToDo t) -> t.getLimit().getTime() < System.currentTimeMillis());
    }

    /**
     * Notifica a los mails suscritos al repositorio que hay una tarea vencida. Devuelve true si ha podido enviárselo a todos los interesados.
     * @return
     */
    protected boolean  notifyFailed(){
        boolean ret = true;

        List<String> em = repo.getAllEmail();
        for(String e: em){
            ret &= mailer.sendMail(e, "Hay tareas vencidas");
        }
        return ret;
    }

    /**
     * Añade un nuevo ToDo al repositorio. Devuelve false si el ToDo ya existe.
     * @param name
     * @param desc
     * @param limit
     * @return
     */
    public boolean  addToDo(String name, String desc, Date limit){
        if(repo.getToDo(name) != null) return false;
        repo.addToDo(new ToDo(name, desc, limit, false));
        if(hasFailedToDo()) notifyFailed();
        return true;
    }

    /**
     * Completa el ToDo t. Devuelve false si el ToDo no está en el repositorio.
     * @param t
     * @return
     */
    public boolean completeToDo(ToDo t){
        if(hasFailedToDo()) notifyFailed();
        if(getUncompletedToDos().contains(t)) {
            repo.setCompletado(t, true);
            return true;
        }
        return false;
    }

    /**
     * Devuelve una lista con todos los ToDo sin completar del repositorio.
     * @return
     */
    public List<ToDo> getUncompletedToDos(){
        if(hasFailedToDo()) notifyFailed();
        List<ToDo> ret = repo.getAllToDo().stream().filter((ToDo t) -> !t.isCompleted()).toList();
        return ret;
    }

    /**
     * Suscribe un mail al repositorio. Devuelve false si ya está suscrito.
     * @param email
     * @return
     */
    public boolean  addEmail(String email){
        if(repo.getAllEmail().contains(email)) return false;
        repo.addEmail(email);
        if(hasFailedToDo()) notifyFailed();
        return true;
    }
}
