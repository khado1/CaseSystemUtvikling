package services.booking;

import com.google.gson.Gson;
import services.menu.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Table {
    int tableID;
    int persons;
    int bookingId = 0;
    ArrayList<Booking> bookings = new ArrayList();

    public Table(){}

    public Table(int id, int pers){
        tableID = id;
        persons = pers;
    }

    public int addBooking(Booking b){
        if(checkTime(b)){
            bookings.add(b);
            Collections.sort(bookings);
            bookingId++;
            return 0;
        } return -1;
    }

    public boolean checkTime(Booking b){
        if(bookings.isEmpty()) return true;

        LocalDateTime tmpStart = b.getBookingStartDate();
        LocalDateTime tmpEnd = b.getBookingEndDate();
        LocalDateTime start;
        LocalDateTime end;

        for(int i = 0; i < bookings.size(); i++){
            start = bookings.get(i).getBookingStartDate();
            end = bookings.get(i).getBookingEndDate();
            if(start.isBefore(tmpStart) && end.isAfter(tmpStart)) return false;
            else if(start.isBefore(tmpStart) && end.isAfter(tmpEnd)) return false;
            else if(start.isAfter(tmpStart) && start.isBefore(tmpEnd)) return false;
            else if(end.isAfter(tmpStart) && end.isBefore(tmpEnd)) return false;
        }

        return true;
    }

    public void deleteBooking(int bookingId){
        for(int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingID() == bookingId) {
                bookings.remove(i);
            }
        }
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Booking getBooking(int id){
        for(int i = 0; i < bookings.size(); i++) if(bookings.get(i).getBookingID() == id) return bookings.get(i);
        return null;
    }

    public int getTableID() {
        return tableID;
    }

    public int getPersons() {
        return persons;
    }

    public int getBookingId() {
        return bookingId;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
