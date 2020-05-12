package automatizacion.ejecuciones;

import automatizacion.Tarea;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public interface EstrategiaDeEjecucion {

    public void ejecutar(Tarea tarea);

}