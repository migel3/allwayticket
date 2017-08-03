package by.alex.allwayticket.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StringToDayOfWeek implements Converter<String, DayOfWeek> {


    @Override
    public DayOfWeek convert(String date) {

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return localDate.getDayOfWeek();

    }
}
