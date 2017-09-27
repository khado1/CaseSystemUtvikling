package services.booking;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import services.menu.*;

import java.time.LocalDateTime;

@Path("/restaurant/")
public class BookingService {
    private static Table[] tables = {
            new Table(0, 3),
            new Table(1, 4),
            new Table(2, 5),
            new Table(3, 8),
            new Table(4, 10),
            new Table(5, 15)
    };

    static int bookingId = 0;

    @POST
    @Path("/booking")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Booking addReservation(Booking b){
        int tId = -1;
        b.setBookingId(bookingId);
        b.fix();
        int x = b.getOrder().getX() * 30;
        LocalDateTime d = b.getBookingStartDate();
        b.setBookingSlutt(d.plusMinutes(x));
        for(int i = 0; i < tables.length; i++){
            if(tables[i].getPersons() >= b.getPersons() && tables[i].addBooking(b) != -1){
                tId = i;
                break;
            }
        }
        if(tId == -1) return null;
        bookingId++;
        return b;
    }

    @DELETE
    @Path("/booking")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBooking(Order o){
        tables[o.getTableId()].deleteBooking(o.getBookingId());
    }

    @GET
    @Path("/{tableId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Table getTable(@PathParam("tableId") int tableId){
        return tables[tableId];
    }

    @GET
    @Path("/{tableId}/{bookingId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Booking getBooking(@PathParam("tableId") int tableId, @PathParam("bookingId") int bookingId){
        return tables[tableId].getBooking(bookingId);
    }

    @GET
    @Path("/menu")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu getMenu(){
        return new Menu();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Table[] getTables() {
        Table[] t = new Table[tables.length];
        for(int i = 0; i < tables.length; i++) t[i] = tables[i];
        return t;
    }
}
