package com.example.pharmapal.services;

import com.example.pharmapal.entities.DTOs.ShiftsDTO;
import com.example.pharmapal.entities.mappers.ShiftsMapper;
import com.example.pharmapal.entities.Shifts;

import com.example.pharmapal.entities.Staff;
import com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions.ShiftAlreadyExistsException;
import com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions.ShiftNotFoundException;
import com.example.pharmapal.interfaces.ShiftsServiceInterface;
import com.example.pharmapal.repositories.ShiftsRepository;
import com.example.pharmapal.repositories.StaffRepository;
import com.example.pharmapal.requests.ShiftIdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShiftsService implements ShiftsServiceInterface {
    private final ShiftsRepository shiftsRepository;
    private final ShiftsMapper shiftsMapper;
    private final StaffRepository staffRepository;


    @Autowired
    public ShiftsService(ShiftsRepository shiftsRepository, ShiftsMapper shiftsMapper, StaffRepository staffRepository) {
        this.shiftsRepository = shiftsRepository;
        this.shiftsMapper = shiftsMapper;

        this.staffRepository = staffRepository;
    }

    // returns a list of shifts
    public List<Shifts> getShifts() {
        return shiftsRepository.findAll();
    }

    //adds new shift
    public String addShift(Shifts shifts) {
        // creates a duration to verify length
        Duration shift = Duration.between(shifts.getShiftStart(), shifts.getShiftEnd());
        if (!shiftsRepository.existsByShiftStartAndShiftEnd(shifts.getShiftStart(), shifts.getShiftEnd())) {
            if ((shift.toHours() > 8 || shift.toHours() < 4)) {
                shiftsRepository.save(shifts);
                return "Shift registered. We advise keeping shifts between 4 and 8 hours for optimal productivity.";
            } else {
                shiftsRepository.save(shifts);
                return "Shift Registered.";
            }
        } else {
            throw new ShiftAlreadyExistsException("An existing shift already covers this period");
        }
    }

    // deletes an existing shift
    public String deleteShift(ShiftIdRequest shiftId) {
        Shifts shift = shiftsRepository.findById(shiftId.getShiftId())
                .orElseThrow(() -> new ShiftNotFoundException("This shift is not registered"));

        Set<Staff> staffSet = shift.getStaff();

        if (staffSet.isEmpty()) {
            // No staff assigned to the shift, safe to delete
            shiftsRepository.deleteById(shift.getShiftId());
            return "Shift deleted successfully";
        } else {
            // Remove the shift reference from staff entities
            for (Staff staff : staffSet) {
                staff.getShifts().remove(shift);
                staffRepository.save(staff);
            }

            // Clear the staff from the shift
            shift.getStaff().clear();
            shiftsRepository.save(shift);

            // Now, it should be safe to delete the shift
            shiftsRepository.deleteById(shift.getShiftId());

            return "Shift deleted successfully. Don't forget to assign the freed staff";
        }
    }


    //updates a shift
    public String updateShift(ShiftsDTO shiftsDTO) {

        Optional<Shifts> optionalPreUpdateShift = shiftsRepository.findById(shiftsDTO.getId());
        if (optionalPreUpdateShift.isPresent()) {
            if (!shiftsRepository.existsByShiftStartAndShiftEnd(shiftsDTO.getShiftStart(), shiftsDTO.getShiftEnd())) {
                Shifts preUpdateShift = optionalPreUpdateShift.get();
                shiftsMapper.mapFromDto(shiftsDTO, preUpdateShift);
                shiftsRepository.save(preUpdateShift);
                return " Shift updated successfully";
            } else {
                throw new ShiftAlreadyExistsException("An existing shift already covers this period");
            }
        } else {
            throw new ShiftNotFoundException("This shift doesn't exist");
        }
    }
}
