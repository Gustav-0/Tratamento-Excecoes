package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in  date (DD/MM/YYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out  date (DD/MM/YYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in Reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: "+ reservation);
			
			System.out.println();
			System.out.println("Enter data to updating reservation: ");
			System.out.print("Check-in  date (DD/MM/YYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out  date (DD/MM/YYY): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println(": Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in Reservation: Check-out date must be after check-in date");
				
			}
			else {
				reservation.updateDates(checkOut, checkOut);
				System.out.print("Reservation: "+ reservation);
			}
									
		}
			
		sc.close();
	}

}
