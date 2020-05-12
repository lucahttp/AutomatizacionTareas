package automatizacion.acciones.email.emailContent;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SesionEmail {





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
    }

