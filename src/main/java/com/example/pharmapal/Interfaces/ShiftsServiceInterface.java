package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Requests.ShiftIdRequest;

import java.util.List;

public interface ShiftsServiceInterface {
    List<Shifts> getShifts();
    String addShift(Shifts shifts);
    String deleteShift(ShiftIdRequest shiftId);
    String updateShift(ShiftsDTO shiftsDTO);
}
