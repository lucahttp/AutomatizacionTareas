package automatizacion.ejecuciones;

import automatizacion.Tarea;
import automatizacion.acciones.Accion;
import automatizacion.ejecuciones.EstrategiaDeEjecucion;

import javax.mail.MessagingException;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class EjecucionSecuencial implements EstrategiaDeEjecucion {


	@Override
	public void ejecutar(Tarea tarea) {
		//tarea.getAcciones().forEach(a -> a.ejecutar());
		//tarea.getAcciones().stream().forEach(Accion::ejecutar);
		tarea.getAcciones().forEach(Accion::ejecutar);
		/*
		for (Accion accion : tarea.getAcciones()) {
			try {
				accion.ejecutar();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		 */
	}
}//end EjecucionSecuencial