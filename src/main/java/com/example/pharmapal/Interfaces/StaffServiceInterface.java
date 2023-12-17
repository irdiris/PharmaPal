package com.example.pharmapal.Interfaces;

import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Staff;
import com.example.pharmapal.Requests.AssignShiftsRequest;
import com.example.pharmapal.Requests.GrantPermissionsRequest;

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
