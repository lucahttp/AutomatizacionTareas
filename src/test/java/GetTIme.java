import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetTIme {



    //public void calcularDiferenciaDeFechas(String Fecha1,String Hora1,String Fecha2,String Hora2) {
    public void calcularDiferenciaDeFechas(String fecha,String hora) {
        try {
            String format = "MM/dd/yyyy hh:mm a";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            if (fecha.contains("dia")){
                String[] fechaAlt = fecha.split(" ");

                Integer Result = 0;
                if(fechaAlt.length > 3)
                    Result = Integer.valueOf(fechaAlt[1]);
                    fecha = fecha;

            }

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
            long diff = dateObj2.getTime() - dateObj1.getTime();

            System.out.println("difference between milliseconds: " + crunchifyFormatter.format(diff));




        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Integer diferenciaEnMilis(String fecha1, String hora1, String fecha2, String hora2){

        Integer resultado = 0;

        try {
            String format = "MM/dd/yyyy hh:mm a";
            SimpleDateFormat sdf = new SimpleDateFormat(format);


            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

            System.out.println("the current date and time: "+ timeStamp);
            Date dateObj1 = null;
            dateObj1 = sdf.parse(fecha1 + " " + hora1);
            Date dateObj2 = sdf.parse(fecha2 + " " + hora2);
            //System.out.println(dateObj1);
            //System.out.println(dateObj2 + "\n");
            DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
            long diff = dateObj2.getTime() - dateObj1.getTime();

            System.out.println("difference between milliseconds: " + crunchifyFormatter.format(diff));


        } catch (ParseException e) {
            e.printStackTrace();
        }


        return resultado;
    }


    public void calcularDiferenciaDeFechasTest(){

        try {
            String date1 = "07/15/2016";
            String time1 = "11:00 AM";
            String date2 = "07/17/2016";
            String time2 = "12:15 AM";

            String format = "MM/dd/yyyy hh:mm a";

            SimpleDateFormat sdf = new SimpleDateFormat(format);

            Date dateObj1 = sdf.parse(date1 + " " + time1);
            Date dateObj2 = sdf.parse(date2 + " " + time2);
            System.out.println(dateObj1);
            System.out.println(dateObj2 + "\n");

            DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

            // getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
            long diff = dateObj2.getTime() - dateObj1.getTime();

            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            System.out.println("difference between days: " + diffDays);

            int diffhours = (int) (diff / (60 * 60 * 1000));
            System.out.println("difference between hours: " + crunchifyFormatter.format(diffhours));

            int diffmin = (int) (diff / (60 * 1000));
            System.out.println("difference between minutues: " + crunchifyFormatter.format(diffmin));

            int diffsec = (int) (diff / (1000));
            System.out.println("difference between seconds: " + crunchifyFormatter.format(diffsec));

            System.out.println("difference between milliseconds: " + crunchifyFormatter.format(diff));

            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
            String date3 = "07/15/2016";
            String time3 = "11:00 AM";

            System.out.println("the current date and time: "+ timeStamp);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("nothing");
    }

}
