package com.tt1.test;

/**
 * Servicio de envío de mails.
 */
public interface Mailer {
    /**
     * Envía un mail a un destinatario y devuelve si ha tenido éxito o no.
     * @param to Mail del destinatario
     * @param content Contenido del mensaje
     * @return
     */
    boolean sendMail(String to, String content);
}
