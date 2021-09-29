package ir.maktab56.airline.domain.dto;

public class TicketDto {

    private String from;

    private String to;

    public TicketDto(String from, String to) {
        this.from = from;
        this.to = to;
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
}
