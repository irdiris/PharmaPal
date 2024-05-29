package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.ShiftsDTO;
import com.example.pharmapal.entities.Shifts;
import com.example.pharmapal.requests.ShiftIdRequest;

import java.util.List;

public interface ShiftsServiceInterface {
    List<Shifts> getShifts();
    String addShift(Shifts shifts);
    String deleteShift(ShiftIdRequest shiftId);
    String updateShift(ShiftsDTO shiftsDTO);
}
