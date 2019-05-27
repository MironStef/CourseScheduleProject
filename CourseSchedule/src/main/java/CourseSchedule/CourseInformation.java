package CourseSchedule;

public class CourseInformation {
     private String name;
     private int totalHours;
     private int lessonPlanned;
     private String startDate;

    public String getName() {
        return name;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public int getLessonPlanned() {
        return lessonPlanned;
    }

    public String getStartDate() {
        return startDate;
    }

    public CourseInformation(String name, int totalHours, int lessonPlanned, String startDate) {
        this.name = name;
        this.totalHours = totalHours;
        this.lessonPlanned = lessonPlanned;
        this.startDate = startDate;
    }

    private static String[] headlines = {"Name of course" ,"Total hours", "Lessons planned", "Start date"};



}
