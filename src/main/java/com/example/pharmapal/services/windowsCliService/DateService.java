package com.example.pharmapal.services.windowsCliService;

import com.example.pharmapal.interfaces.DateServiceInterface;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class DateService implements DateServiceInterface {

    public String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy_HH-mm-ss");
        Date now = new Date();
        return sdf.format(now);
    }
}
