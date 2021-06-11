package model.entites;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roonumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roonumber, Date checkIn, Date checkOut) {
        this.roonumber = roonumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoonumber() {
        return roonumber;
    }

    public void setRoonumber(Integer roonumber) {
        this.roonumber = roonumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

//retornar duração em dias com base em duas datas
    public long duration(){
        //dia final menos dia inicial ( getTime retorna miliSegundos)
        long dif = checkOut.getTime() - checkIn.getTime();
        //TimeUnit.DAYS converte os milisegundos em dias e retorna
        return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
        }

    //atualizar datas novas
    public String upDatesDate(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){

            return "Error! Dates befores of date now!\nReservation dates for update must be future";
        }else if(!checkOut.after(checkIn)){
            return "Error in reservation: chek-out date must be after check-out date!!!";
        }else{

            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return null;
        }
    }



    @Override
    public String toString(){
        return "Room " + roonumber + ", CheckIn " + sdf.format(checkIn) + " " + sdf.format(checkOut) + ", " + duration() + " nigths";

    }

}
