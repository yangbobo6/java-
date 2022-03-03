package java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: yangbo
 * @Date: 2022-03-03-18:25
 * @Description:
 */
public class timeTest {
    public static void main(String[] args) {
        //format yyyy-MM-dd
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(String.format("date format: %s",date));

        //format HH:mm:ss
        LocalTime time = LocalTime.now().withNano(0);
        System.out.println(time);

        //format yyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeStr = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(dateTimeStr);
    }
}
