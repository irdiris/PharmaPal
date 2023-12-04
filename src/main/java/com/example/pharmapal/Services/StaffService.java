package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Mappers.StaffMapper;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftNotFoundException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions.StaffAlreadyAssignedToShift;
import com.example.pharmapal.Repositories.ShiftsRepository;
import com.example.pharmapal.Repositories.StaffRepository;
import com.example.pharmapal.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
     private  final  StaffMapper staffMapper;
     private final ShiftsRepository shiftsRepository;



@Autowired
    public StaffService(StaffRepository staffRepository, UserRepository userRepository, StaffMapper staffMapper, ShiftsRepository shiftsRepository) {
        this.staffRepository = staffRepository;
    this.userRepository = userRepository;

    this.staffMapper = staffMapper;
    this.shiftsRepository = shiftsRepository;
}

// returns a list of employees.
    public List<Staff> getStaff(){
    return  staffRepository.findAll();
    }
// add new staff member.
    public String addStaffMember(Staff staffMember){
       if (!userRepository.existsById(staffMember.getId())){
           if (!userRepository.existsByPhone(staffMember.getUser().getPhone())){
               if (!userRepository.existsByEmail(staffMember.getUser().getEmail())){
                   staffRepository.save(staffMember);
                   return "employee registered";
               }else {
                   throw  new StaffMemberAlreadyExistsException("This email already exists");
               }
           }else {
               throw  new StaffMemberAlreadyExistsException("this phone number already exists");
           }
       }else
       {
           throw new StaffMemberAlreadyExistsException("This user already exists");
       }


    }

// update an existing staff member

    public String updateStaffMember(StaffDTO updatedStaffMember){
        Optional<Staff> optionalPreUpdateStaffMember = staffRepository.findById(updatedStaffMember.getId());
        if (optionalPreUpdateStaffMember.isPresent()){
            if (!userRepository.existsByEmailAndIdNot(updatedStaffMember.getUser().getEmail(), updatedStaffMember.getId())){
                if (!userRepository.existsByPhoneAndIdNot(updatedStaffMember.getUser().getPhone(), updatedStaffMember.getId())){
                   Staff preUpdateStaffMember = optionalPreUpdateStaffMember.get();
                    staffMapper.mapStaffFromDto(updatedStaffMember, preUpdateStaffMember);
                   staffRepository.save(preUpdateStaffMember);
                   return "employee information updated successfully.";
                }else {
                    throw new StaffMemberAlreadyExistsException("this phone number already exists.");
                }
            }else {
                throw new StaffMemberAlreadyExistsException("this email already exists.");
            }
            }else {
            throw new StaffMemberNotFoundException("this employee doesn't exist.");
        }


}
 //terminates an employee once they're fired.
public String terminateStaff(Staff staff){
    Optional<Staff> optionalStaffMemberToBeTerminated = staffRepository.findById(staff.getId());
    if (optionalStaffMemberToBeTerminated.isPresent()){
        // TO DO : REMOVE SHIFTS BEFORE TERMINATING
        Staff staffMemberToBeTerminated = optionalStaffMemberToBeTerminated.get();
        staffMemberToBeTerminated.setState(StaffStates.TERMINATED);
        return "Employee terminated successfully.";
    }else {
        throw new StaffMemberNotFoundException("this employee doesn't exist.");
    }
}

public String assignShifts(Staff staff, Shifts shifts){

    staffRepository.save(staff);
    shiftsRepository.save(shifts);
        return "Staff member assigned";
    }

}




