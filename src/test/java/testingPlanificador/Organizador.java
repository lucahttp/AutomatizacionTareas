package testingPlanificador;

import java.util.Date;
import java.util.Timer;

public class Organizador {

    Timer timer;
    int counter1 = 0;
    int counter2 = 0;
    Date fecha;
    boolean finTarea = false;



    public Organizador() {
        //se crea un planificador que planificara 2 tareas
        timer = new Timer();
        //la Tarea1 se ejecuta pasado 1 segundo y luego periódicamente cada segundo
        //timer.schedule(new MyPlanificador.Tarea1(), 1000,1000);
        //la Tarea2 se ejecuta pasado 5 segundos y luego periodicamente cada segundo
        //timer.schedule(new MyPlanificador.Tarea2(), 5000, 1000);

    }



}
