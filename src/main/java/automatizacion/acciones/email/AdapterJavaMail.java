package automatizacion.acciones.email;

import automatizacion.acciones.email.emailContent.Email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMultipart;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class AdapterJavaMail implements AdapterEmailSender {


	@Override
	public void enviar(Email email) {
		//this.enviarEmail("SmartMaceta@gmail.com","Hola.1234","lucasain2010@gmail.com","hello javatpoint","How r u?");
		//this.enviarGmail("SmartMaceta@gmail.com","Hola.1234");

		sendEmail(
				createSesion("SmartMaceta@gmail.com","Hola.1234"),
				"luca.sain@outlook.com",
				"este es un test",
				createBody("este es el cuerpo del email de test"),
				"luca",
				"luca@sain.com",
				"luca@sain.com"
		);
	}

	public static Session createSesion(String username, String password){
		System.out.println("Simple create sesion for email");

		//String username = "SmartMaceta@gmail.com";
		//String password = "Hola.1234";

		//String to = "lucasain2010@gmail.com";

		//String sub = "hello javatpoint";

		//String msg = "How r u?";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");


		//Session session = Session.getInstance(props, null);

		Session session = Session.getInstance(
				props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
		return session;
	}

	public static Multipart createBody(String body) {

		// Create the message body part
		BodyPart messageBodyPart = new MimeBodyPart();

		try {
			messageBodyPart.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// Create a multipart message for attachment
		Multipart multipart = new MimeMultipart();

		// Set text message part
		try {
			multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// Second part is image attachment
		messageBodyPart = new MimeBodyPart();
		//String filename = "image.png";
		String filename = "C:\\Users\\Luca\\Downloads\\Ben_10.png";


		DataSource source = new FileDataSource(filename);
		try {
			messageBodyPart.setDataHandler(new DataHandler(source));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			messageBodyPart.setFileName(filename);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		//Trick is to add the content-id header here
		try {
			messageBodyPart.setHeader("Content-ID", "image_id");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		//third part for displaying image in the email body
		messageBodyPart = new MimeBodyPart();
		try {
			messageBodyPart.setContent("<h1>Attached Image</h1>" +
					"<img src='cid:image_id'>", "text/html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return multipart;
	}



	public static void sendEmail(Session session, String toEmail, String subject, Multipart multipart, String DisplayUser, String DisplayEmail, String DisplayReplyEmail){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(DisplayEmail, DisplayUser));

			msg.setReplyTo(InternetAddress.parse(DisplayReplyEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));



			//Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("el EMail se envio correctamente!!");

		}catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}



	private void enviarEmail(String from,String password,String to,String sub,String msg){
			//Get properties object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			//get Session
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(from,password);
						}
					});
			//compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				message.setSubject(sub);
				message.setText(msg);
				//send message
				Transport.send(message);
				System.out.println("message sent successfully");
			} catch (MessagingException e) {throw new RuntimeException(e);}
	}





	private void enviarGmail(String nombreDeUsuario,String contraseñaDeUsuario){
		//final String username = "username@gmail.com";
		//final String password = "password";
		final String username = nombreDeUsuario;
		final String password = contraseñaDeUsuario;

		final String destinatarios = "to_username_a@gmail.com, to_username_b@yahoo.com";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(destinatarios)
			);
			message.setSubject("Testing Gmail SSL");
			message.setText("Dear Mail Crawler,"
					+ "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utility method to send email with attachment
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendAttachmentEmail(Session session, String toEmail, String subject, String body){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "abc.txt";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with attachment!!");
		}catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Utility method to send image in email body
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendImageEmail(Session session, String toEmail, String subject, String body,String DisplayUser, String DisplayEmail, String DisplayReplyEmail){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(DisplayEmail, DisplayUser));

			msg.setReplyTo(InternetAddress.parse(DisplayReplyEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			messageBodyPart = new MimeBodyPart();
			//String filename = "image.png";
			String filename = "C:\\Users\\Luca\\Downloads\\Ben_10.png";


			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			//Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			multipart.addBodyPart(messageBodyPart);

			//third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>Attached Image</h1>" +
					"<img src='cid:image_id'>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			//Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		}catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}




	public static void SendHTMLEmail(Session session, String toEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(body);

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Second part is image attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "image.png";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			//Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			multipart.addBodyPart(messageBodyPart);

			//third part for displaying image in the email body
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1>This is actual message</h1>", "text/html");
			multipart.addBodyPart(messageBodyPart);

			//Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


	}




	public static void sendEmailTest(Session session, String toEmail, String subject, Multipart multipart,String DisplayUser, String DisplayEmail, String DisplayReplyEmail){
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(DisplayEmail, DisplayUser));

			msg.setReplyTo(InternetAddress.parse(DisplayReplyEmail, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));



			//Set the multipart message to the email message
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			System.out.println("EMail Sent Successfully with image!!");
		}catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}





}//end AdapterJavaMail