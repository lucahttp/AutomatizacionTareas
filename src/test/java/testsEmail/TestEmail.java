package testsEmail;

import automatizacion.acciones.email.emailContent.SesionEmail;
import automatizacion.acciones.email.ejemplos.TestEmail1;
import org.junit.Test;

import javax.mail.*;
import java.io.IOException;

public class TestEmail {

	@Test
	public void Test() throws IOException {

		Session mySesion = SesionEmail.createSesion("SmartMaceta@gmail.com","Hola.1234");

		TestEmail1.sendImageEmail(mySesion,"lucasain2010@gmail.com","SimpleEmail Testing Subject", "SimpleEmail Testing Body");


	}

}
