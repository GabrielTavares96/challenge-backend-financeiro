package com.challenge.backendfinanceiro.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    public static int getMonth(LocalDate date) {
        int mes = date.getMonthValue();
        return mes;
    }

    public static int getYear(LocalDate date) {
        int year = date.getYear();
        return year;
    }

    public static LocalDate converterDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = date.format(formatter);

        LocalDate ld = LocalDate.parse(dataFormatada);
        return ld;

    }
}
