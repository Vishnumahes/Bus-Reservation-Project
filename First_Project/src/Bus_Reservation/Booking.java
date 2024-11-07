package Bus_Reservation;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int  busNo;
	Date date;
	
	Booking(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the anme of the passenger");
		passengerName = scan.next();
		System.out.println("Enter bus no:");
		busNo = scan.nextInt();
		System.out.println("Enter date dd-mm-yyy");
		String dateInput = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isAvailable(ArrayList <Booking> bookings, ArrayList<Bus> buses) {
		int capacity =0;
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		int booked =0;
		for(Booking b:bookings) {
			if(b.busNo ==busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return booked<capacity?true:false;
	}

}
