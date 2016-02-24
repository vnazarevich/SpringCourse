package com.epam.spring.club.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String ticketId;
    private String showId;
    private Integer seat;
    private Boolean isVIP;
    private Boolean isFree;
    private Integer price;

    public Ticket(String ticketId, String showId, int seat, boolean isVIP, boolean isFree, int price) {
        this.ticketId = ticketId;
        this.showId = showId;
        this.seat = seat;
        this.isVIP = isVIP;
        this.isFree = isFree;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getShowId() {
        return showId;
    }

    public int getSeat() {
        return seat;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", showId='" + showId + '\'' +
                ", seat=" + seat +
                ", isVIP=" + isVIP +
                ", isFree=" + isFree +
                ", price=" + price +
                '}';
    }
}
