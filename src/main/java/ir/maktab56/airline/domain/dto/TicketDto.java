package ir.maktab56.airline.domain.dto;

import java.sql.Date;
import java.time.ZonedDateTime;

public class TicketDto {

    private String from;

    private String to;

    private String date;

    public TicketDto(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public TicketDto(String from , String to , String date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public TicketDto() {

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
