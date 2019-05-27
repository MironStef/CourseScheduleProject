package CourseSchedule;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    static String[] headlines = {"Name of course" ,"Total hours", "Lessons planned", "Start date"};
    static List<CourseInformation> courseInformations = new ArrayList<CourseInformation>();
    static String[] titles = {"Date" ,"Day of week", "From", "To"};
    static List<Lesson> schedule = new ArrayList<Lesson>();


    public static void main(String[] args) throws IOException {
        schedule.add(new Lesson("03/06/2019","Monday","18:30","20:00"));
        schedule.add(new Lesson("05/06/2019","Wednesday","18:30","20:00"));
        schedule.add(new Lesson("10/06/2019","Monday","18:30","20:00"));
        schedule.add(new Lesson("12/06/2019","Wednesday","18:30","20:00"));
        schedule.add(new Lesson("17/06/2019","Monday","18:30","20:00"));
        schedule.add(new Lesson("19/06/2019","Wednesday","18:30","20:00"));

        courseInformations.add(new CourseInformation("Java Basics",9,6,"3/06/2019"));

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Course Schedule");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.DARK_RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headlineRow = sheet.createRow(0);

        for(int i = 0; i< headlines.length; i++){
            Cell cell = headlineRow.createCell(i);
            cell.setCellValue(headlines[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;

        for(CourseInformation courseInformation : courseInformations ){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(courseInformation.getName());
            row.createCell(1).setCellValue(courseInformation.getTotalHours());
            row.createCell(2).setCellValue(courseInformation.getLessonPlanned());
            row.createCell(3).setCellValue(courseInformation.getStartDate());
        }

        Row headerRow = sheet.createRow(2);

        for(int i = 0; i< titles.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum2 = 3;

        for(Lesson schedule : schedule ){
            Row row = sheet.createRow(rowNum2++);
            row.createCell(0).setCellValue(schedule.getDate());
            row.createCell(1).setCellValue(schedule.getDay());
            row.createCell(2).setCellValue(schedule.getFrom());
            row.createCell(3).setCellValue(schedule.getTo());
        }

        for (int i = 0; i <titles.length;i++){
            sheet.autoSizeColumn(i);
        }
        try {
            FileOutputStream out =
                    new FileOutputStream(new File("CourseSchedule.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written seccessfully..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
