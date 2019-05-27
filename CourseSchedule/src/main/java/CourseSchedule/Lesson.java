package CourseSchedule;

public class Lesson {

    private String date, day, from, to;

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Lesson(String date, String day, String from, String to){
        this.date = date;
        this.day = day;
        this.from = from;
        this.to = to;
    }
}
