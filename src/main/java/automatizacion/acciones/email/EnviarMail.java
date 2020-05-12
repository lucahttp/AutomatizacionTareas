package automatizacion.acciones.email;

import automatizacion.acciones.Accion;
import automatizacion.acciones.email.ejemplos.TestEmailFromGmail;
import automatizacion.acciones.email.emailContent.Email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class EnviarMail extends Accion {
	AdapterEmailSender adapterEmailSenderdapterEmai;
	Email email;

	//public AdapterEmailSender m_AdapterEmailSender;

	//https://mvnrepository.com/artifact/com.sun.mail/javax.mail
	//https://www.journaldev.com/2532/javamail-example-send-mail-in-java-smtp


	public EnviarMail(AdapterEmailSender adapterEmailSenderdapterEmai, Email email){
		this.adapterEmailSenderdapterEmai = adapterEmailSenderdapterEmai;
		this.email = email;
	}


	@Override
	public void ejecutar() {
		adapterEmailSenderdapterEmai.enviar(email);
	}



}//end EnviarMail