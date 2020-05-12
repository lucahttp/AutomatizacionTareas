package automatizacion.acciones.email;

import automatizacion.acciones.email.emailContent.Email;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public interface AdapterEmailSender {
    public void enviar(Email email);

}