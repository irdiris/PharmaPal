package com.example.pharmapal.Services;

import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Mappers.StaffMapper;
import com.example.pharmapal.Entities.Permissions;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import com.example.pharmapal.ExceptionHandling.PermissionsExceptionHandling.exceptions.PermissionNotFoundException;
import com.example.pharmapal.ExceptionHandling.ShiftsExceptionHandling.Exceptions.ShiftNotFoundException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberAlreadyExistsException;
import com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions.StaffMemberNotFoundException;
import com.example.pharmapal.Interfaces.StaffServiceInterface;
import com.example.pharmapal.Repositories.PermissionsRepository;
import com.example.pharmapal.Repositories.ShiftsRepository;
import com.example.pharmapal.Repositories.StaffRepository;
import com.example.pharmapal.Repositories.UserRepository;
import com.example.pharmapal.Requests.AssignShiftsRequest;
import com.example.pharmapal.Requests.GrantPermissionsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements StaffServiceInterface {

    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    private final StaffMapper staffMapper;
    private final ShiftsRepository shiftsRepository;
    private final PermissionsRepository permissionsRepository;



    @Autowired
    public StaffService(StaffRepository staffRepository, UserRepository userRepository, StaffMapper staffMapper, ShiftsRepository shiftsRepository, PermissionsRepository permissionsRepository) {
        this.staffRepository = staffRepository;
        this.userRepository = userRepository;

        this.staffMapper = staffMapper;
        this.shiftsRepository = shiftsRepository;
        this.permissionsRepository = permissionsRepository;
    }

    // returns a list of employees.
    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    // add new staff member.
    public String addStaffMember(Staff staffMember) {
        System.out.println(staffMember.getUser().getType());
        if (!userRepository.existsById(staffMember.getId())) {
            if (!userRepository.existsByPhone(staffMember.getUser().getPhone())) {
                if (!userRepository.existsByEmail(staffMember.getUser().getEmail())) {
                    staffRepository.save(staffMember);
                    return "employee registered";
                } else {
                    throw new StaffMemberAlreadyExistsException("This email already exists");
                }
            } else {
                throw new StaffMemberAlreadyExistsException("this phone number already exists");
            }
        } else {
            throw new StaffMemberAlreadyExistsException("This user already exists");
        }

    }
// update an existing staff member

    public String updateStaffMember(StaffDTO updatedStaffMember) {
       Staff preUpdateStaffMember = staffRepository.findById(updatedStaffMember.getId()).orElseThrow(()-> new StaffMemberNotFoundException("this employee doesn't exist."));

            if (!userRepository.existsByEmailAndIdNot(updatedStaffMember.getUser().getEmail(), updatedStaffMember.getId())) {
                if (!userRepository.existsByPhoneAndIdNot(updatedStaffMember.getUser().getPhone(), updatedStaffMember.getId())) {
                    staffMapper.mapStaffFromDto(updatedStaffMember, preUpdateStaffMember);
                    staffRepository.save(preUpdateStaffMember);
                    return "employee information updated successfully.";
                } else {
                    throw new StaffMemberAlreadyExistsException("this phone number already exists.");
                }
            } else {
                throw new StaffMemberAlreadyExistsException("this email already exists.");
            }

    }

    //terminates an employee once they're fired.
    public String terminateStaff(Staff staff) {
        Staff staffMemberToBeTerminated = staffRepository.findById(staff.getId()).orElseThrow(() -> new StaffMemberNotFoundException("this employee doesn't exist."));
        staffMemberToBeTerminated.setState(StaffStates.TERMINATED);
        staffMemberToBeTerminated.getShifts().clear();
        staffRepository.save(staffMemberToBeTerminated);
        return "Employee terminated successfully.";

    }

    public String assignShift(AssignShiftsRequest assignShiftsRequest) {
        Staff staff = staffRepository.findByIdAndState(assignShiftsRequest.getStaffId(), StaffStates.ACTIVE).orElseThrow(() -> new StaffMemberNotFoundException("this employee doesn't exist"));
        Shifts shifts = shiftsRepository.findById(assignShiftsRequest.getShiftId()).orElseThrow(() -> new ShiftNotFoundException("this shift doesn't exist"));
        staff.getShifts().add(shifts);
        shifts.getStaff().add(staff);
        shiftsRepository.save(shifts);
        staffRepository.save(staff);
        return "Staff member assigned";
    }

    public String removeFromShift(AssignShiftsRequest assignShiftsRequest) {
        Staff staff = staffRepository.findByIdAndState(assignShiftsRequest.getStaffId(), StaffStates.ACTIVE).orElseThrow(() -> new StaffMemberNotFoundException("this employee doesn't exist"));
        Shifts shifts = shiftsRepository.findById(assignShiftsRequest.getShiftId()).orElseThrow(() -> new ShiftNotFoundException("this shift doesn't exist"));
    staff.getShifts().remove(shifts);
    shifts.getStaff().remove(staff);
    staffRepository.save(staff);
    shiftsRepository.save(shifts);
    return "Staff member removed from shift";
    }

    public String grantPermission(GrantPermissionsRequest grantPermissionsRequest) {
        Staff staff = staffRepository.findByIdAndState(grantPermissionsRequest.getStaffId(), StaffStates.ACTIVE).orElseThrow(() -> new StaffMemberNotFoundException("this employee doesn't exist"));
        Permissions permissions = permissionsRepository.findById(grantPermissionsRequest.getPermissionId()).orElseThrow(() -> new PermissionNotFoundException("this permission doesn't exist"));
        staff.getPermissions().add(permissions);
        permissions.getStaffSet().add(staff);
        permissionsRepository.save(permissions);
        staffRepository.save(staff);
        return "permission granted.";
    }

    public String revokePermission(GrantPermissionsRequest grantPermissionsRequest){
        Staff staff = staffRepository.findByIdAndState(grantPermissionsRequest.getStaffId(), StaffStates.ACTIVE).orElseThrow(() -> new StaffMemberNotFoundException("this employee doesn't exist"));
        Permissions permissions = permissionsRepository.findById(grantPermissionsRequest.getPermissionId()).orElseThrow(() -> new PermissionNotFoundException("this permission doesn't exist"));
        staff.getPermissions().remove(permissions);
        permissions.getStaffSet().remove(staff);
        permissionsRepository.save(permissions);
        staffRepository.save(staff);
        return "permission revoked.";
    }
}




