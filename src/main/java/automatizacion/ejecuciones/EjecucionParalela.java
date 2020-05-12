package automatizacion.ejecuciones;

import automatizacion.Tarea;
import automatizacion.acciones.Accion;
import automatizacion.ejecuciones.EstrategiaDeEjecucion;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class EjecucionParalela implements EstrategiaDeEjecucion {

	@Override
	public void ejecutar(Tarea tarea) {
		tarea.getAcciones().parallelStream().forEach(Accion::ejecutar);
	}
}//end EjecucionParalela