package com.group3.onlineShooping.constants;

import javax.persistence.Transient;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMATTER);


}
