import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calc {



    public static long diferenciaEnMilis(String fecha, String hora){
        //Integer resultado = 0;
        long resultado = 0;
        try {
            String format = "dd/MM/yyyy HH:mm";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            //String date3 = "07/15/2016";
            //String time3 = "11:00 AM";
            //System.out.println("the current date and time: "+ timeStamp);
            //Date dateObj1 = sdf.parse(Fecha1 + " " + Hora1);
            Date dateObj1 = sdf.parse(timeStamp);


            Date dateObj2 = sdf.parse(fecha + " " + hora);
            //System.out.println(dateObj1);
            //System.out.println(dateObj2 + "\n");
            DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
            //long diff = dateObj2.getTime() - dateObj1.getTime();
            resultado = dateObj2.getTime() - dateObj1.getTime();

            System.out.println("difference between milliseconds: " + crunchifyFormatter.format(resultado));




        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultado;
    }



    public static void main(String[] args) {
        long gg = diferenciaEnMilis("29/06/2020","20:53");
        System.out.println("diferencia" + gg);
        System.out.println("nothing");
    }
}
