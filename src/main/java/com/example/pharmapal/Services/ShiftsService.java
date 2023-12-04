package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.Mappers.ShiftsMapper;
import com.example.pharmapal.Entities.Shifts;

import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftNotFoundException;
import com.example.pharmapal.Repositories.ShiftsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class ShiftsService {
    private  final ShiftsRepository shiftsRepository;
    private  final ShiftsMapper shiftsMapper;






    @Autowired
    public ShiftsService(ShiftsRepository shiftsRepository, ShiftsMapper shiftsMapper) {
        this.shiftsRepository = shiftsRepository;
    this.shiftsMapper = shiftsMapper;

    }

    // returns a list of shifts
    public List<Shifts> getShifts(){
        return shiftsRepository.findAll();
    }

    //adds new shift
    public String addShift(Shifts shifts){
       // creates a duration to verify length
    Duration shift =  Duration.between(shifts.getShiftStart(), shifts.getShiftEnd());
        if (!shiftsRepository.existsByShiftStartAndShiftEnd(shifts.getShiftStart(), shifts.getShiftEnd())){
            if((shift.toHours()>8 || shift.toHours()<4)){
                shiftsRepository.save(shifts);
                return "Shift registered. We advise keeping shifts between 4 and 8 hours for optimal productivity.";
            }else {
                shiftsRepository.save(shifts);
                return "Shift Registered.";
            }
        }else {
            throw new ShiftAlreadyExistsException("An existing shift already covers this period");
        }
    }
// deletes an existing shift
    public String deleteShift(Shifts shifts){

            return "shift deleted successfully. Don't forget to assign the freed staff";
        }

    //updates a shift
    public String updateShift(ShiftsDTO shiftsDTO){

        Optional<Shifts> optionalPreUpdateShift = shiftsRepository.findById(shiftsDTO.getId());
        if (optionalPreUpdateShift.isPresent()){
     if (!shiftsRepository.existsByShiftStartAndShiftEnd(shiftsDTO.getShiftStart(), shiftsDTO.getShiftEnd())){
         Shifts preUpdateShift = optionalPreUpdateShift.get();
         shiftsMapper.mapShiftFromDto(shiftsDTO,preUpdateShift);
         shiftsRepository.save(preUpdateShift);
         return  " Shift updated successfully";
     }else {
       throw new ShiftAlreadyExistsException("An existing shift already covers this period");
     }}else {
            throw  new ShiftNotFoundException("This shift doesn't exist");
        }
    }
}
