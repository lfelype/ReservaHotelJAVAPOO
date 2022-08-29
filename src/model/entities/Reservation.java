package model.entities;

import model.exceptions.DomainException;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;


    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if(!checkOut.after(checkIn)){
            throw new DomainException("Data do check-in posterior a do check-out. Reserva inválida!");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        //pega diferenca em milisegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainException("As datas precisam ser futuras. Reserva inválida!");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainException("Data do check-in posterior a do check-out. Reserva inválida!");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Room " + roomNumber + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) + ", "
                + duration() + " nights.";

    }
}
