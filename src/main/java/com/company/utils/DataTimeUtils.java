package com.company.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataTimeUtils {
    private final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static String customDateNow() {
        ZoneId zoneId = ZoneId.of("Asia/Tashkent");
        LocalDateTime ldt = LocalDateTime.now().atZone(zoneId).toLocalDateTime();
        return ldt.format(CUSTOM_FORMATTER);
    }
}
