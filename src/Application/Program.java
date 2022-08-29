package Application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in Date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-out Date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservado: " + reservation);

            System.out.println("Entre com a data para atualizar!");
            System.out.println("Check-in Date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out Date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservado: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Data invalida!");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva! " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inexperado!");
        }
        sc.close();
    }

}
