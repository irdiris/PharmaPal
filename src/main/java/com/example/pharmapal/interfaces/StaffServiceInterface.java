package com.example.pharmapal.interfaces;

import com.example.pharmapal.entities.DTOs.StaffDTO;
import com.example.pharmapal.entities.Staff;
import com.example.pharmapal.requests.AssignShiftsRequest;
import com.example.pharmapal.requests.GrantPermissionsRequest;

import java.util.List;

public interface StaffServiceInterface {
    List<Staff> getStaff();
    String addStaffMember(Staff staffMember);
    String updateStaffMember(StaffDTO updatedStaffMember);
    String terminateStaff(Staff staff);
    String assignShift(AssignShiftsRequest assignShiftsRequest);
    String removeFromShift(AssignShiftsRequest assignShiftsRequest);
    String grantPermission(GrantPermissionsRequest grantPermissionsRequest);
    String revokePermission(GrantPermissionsRequest grantPermissionsRequest);
}
