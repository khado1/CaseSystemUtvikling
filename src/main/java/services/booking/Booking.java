package services.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import services.cards.Visa;
import services.menu.*;

import java.time.LocalDateTime;

class Booking implements Comparable{
    int bookingId;
    int persons;
    LocalDateTime bookingStart;
    LocalDateTime bookingSlutt;
    Visa paymentCard;

    Order order;

    // Getters
    public int getBookingID() {
        return bookingId; }

    public int getPersons() {
        return persons; }

    @JsonIgnore
    public LocalDateTime getBookingStartDate() {
        return bookingStart; }

    @JsonIgnore
    public LocalDateTime getBookingEndDate() {
        return bookingSlutt; }

    public String getBookingStart() {
        return (bookingStart != null ? bookingStart.toString() : ""); }

    public String getBookingSlutt() {
        return (bookingSlutt != null ? bookingSlutt.toString() : ""); }

    public Visa getPaymentCard() {
        return paymentCard; }

    // Setters
    public void setBookingStart(String d){
        bookingStart = LocalDateTime.parse(d); }

    public void setBookingSlutt(LocalDateTime d){
        bookingSlutt = d; }

    public void setBookingId(int id){
        bookingId = id; }

    public void setOrder(Order o){
        o.fix(); order = o; }

    public Order getOrder(){
        return order; }

    public void fix(){
        order.fix();
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int compareTo(Object b){
        Booking tmp = (Booking) b;
        if(bookingStart.isAfter(tmp.getBookingStartDate())) return 1;
        else if(bookingStart.isBefore(tmp.getBookingStartDate())) return -1;
        else return 0;
    }
}
