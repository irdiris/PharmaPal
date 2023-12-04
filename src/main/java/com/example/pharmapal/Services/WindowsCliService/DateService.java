package com.example.pharmapal.Services.WindowsCliService;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class DateService {

    public String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy_HH-mm-ss");
        Date now = new Date();
        return sdf.format(now);
    }
}
