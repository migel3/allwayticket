package by.alex.allwayticket.json;

import org.springframework.util.StringUtils;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TimeUtil {
    public static final DateTimeFormatter DATE_TME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");


    public static String toString(LocalTime ldt) {
        return ldt == null ? null: ldt.format(TIME_FORMATTER);
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? null : ldt.format(DATE_TME_FORMATTER);
    }

    public static LocalDateTime toDateTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDateTime.parse(str, DATE_TME_FORMATTER);
    }

    public static LocalTime toTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalTime.parse(str, TIME_FORMATTER);
    }

}
