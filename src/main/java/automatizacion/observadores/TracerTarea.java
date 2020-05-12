package automatizacion.observadores;

import automatizacion.Tarea;
import automatizacion.observadores.Tracer;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:31 PM
 */
public class TracerTarea extends Tracer {


	@Override
	public void serNotificadoPor(IObservable observable) {
		Tarea tarea = (Tarea) observable;
	}
}//end TracerTarea