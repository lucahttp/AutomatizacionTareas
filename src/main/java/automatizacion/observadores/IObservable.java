package automatizacion.observadores;

/**
 * @author Luca
 * @version 1.0
 * @created 10-May-2020 2:54:30 PM
 */
public interface IObservable {
    public void notificar();
    public void agregarObserver(IObserver ... observers);
    public void eliminarObserver(IObserver observers);

}//end Observable