package com.ct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        java.sql.Date DateSql = java.sql.Date.valueOf(date.format(formatter));
        int i =0;
    }
}
