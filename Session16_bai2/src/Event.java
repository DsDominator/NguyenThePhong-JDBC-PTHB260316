import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    // Kiểm tra trạng thái sự kiện
    public String getStatus() {

        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(startDate)) {
            return "Sap toi";
        } else if (now.isAfter(endDate)) {
            return "Da ket thuc";
        } else {
            return "Dang dien ra";
        }
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Event{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate.format(formatter) +
                ", endDate=" + endDate.format(formatter) +
                ", status=" + getStatus() +
                '}';
    }
}