package automatizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public class EjecutadorDeTareas extends TimerTask {

	private List<Tarea> tareas;

	public EjecutadorDeTareas(){
		this.tareas = new ArrayList<>();
	}

	public void agregarTarea(Tarea ... tareas){
		Collections.addAll(this.tareas, tareas);
	}



	@Override
	public void run() {
		this.tareas.forEach(Tarea::ejecutar);
	}

}//end EjecutadorDeTareas