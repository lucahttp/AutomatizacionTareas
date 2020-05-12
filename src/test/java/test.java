import automatizacion.acciones.email.AdapterJavaMail;
import automatizacion.acciones.email.EnviarMail;
import automatizacion.acciones.email.emailContent.Email;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.IOException;

public class test {

	@Test
	public void Test() throws IOException {

		EnviarMail myEmail = new EnviarMail(new AdapterJavaMail(),new Email());
		myEmail.ejecutar();

	}

}
