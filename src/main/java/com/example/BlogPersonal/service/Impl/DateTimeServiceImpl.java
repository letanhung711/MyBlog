package com.example.BlogPersonal.service.Impl;

import com.example.BlogPersonal.service.DateTimeService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public String DateFormatTime(String datetime) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.ENGLISH);
        try {
            Date orderDate = inputFormat.parse(datetime);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return outputFormat.format(orderDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
