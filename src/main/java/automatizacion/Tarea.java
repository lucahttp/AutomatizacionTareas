package automatizacion;

import automatizacion.acciones.Accion;
import automatizacion.ejecuciones.EstrategiaDeEjecucion;
import automatizacion.observadores.IObservable;
import automatizacion.observadores.IObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:31 PM
 */
public class Tarea implements IObservable {

	private EstrategiaDeEjecucion estrategiaDeEjecucion;
	private List<Accion> acciones;
	private List<IObserver> observers;
	private EstadoTarea estadoTarea;
	/*
	public Observer m_Observer;
	public Estado m_Estado;
	public Accion m_Accion;
	 */



	public Tarea(EstrategiaDeEjecucion estrategiaDeEjecucion){
		this.estrategiaDeEjecucion = estrategiaDeEjecucion;
		this.acciones = new ArrayList<Accion>();
		this.observers = new ArrayList<>();
		this.estadoTarea = EstadoTarea.INICIADA;
	}


	public List<Accion> getAcciones() {
		return acciones;
	}


	public void ejecutar() {
		System.out.println("Estoy ejecutando");

		cambiarEstadoYNotificar(EstadoTarea.EN_EJECUCION);
		this.estrategiaDeEjecucion.ejecutar(this);
		cambiarEstadoYNotificar(EstadoTarea.FINALIZADA);
	}


	private void cambiarEstadoYNotificar(EstadoTarea estadoTarea){
		this.estadoTarea = estadoTarea;
		notificar();
	}


	@Override
	public void notificar() {
		this.observers.forEach(o -> o.serNotificadoPor(this));
	}

	@Override
	public void agregarObserver(IObserver... observers) {
		Collections.addAll(this.observers, observers);

	}

	@Override
	public void eliminarObserver(IObserver observers) {

	}


	public void agregarAccion(Accion ... acciones) {
		Collections.addAll(this.acciones,acciones);
	}
}//end Tarea