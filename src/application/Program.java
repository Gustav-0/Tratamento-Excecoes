package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in  date (DD/MM/YYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out  date (DD/MM/YYY): ");
			Date checkOut = sdf.parse(sc.next());
					
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to updating reservation: ");
			System.out.print("Check-in  date (DD/MM/YYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out  date (DD/MM/YYY): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation "+ reservation);
			sc.close();
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in Reservation: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unespected error!");
		}
		
	}

}
