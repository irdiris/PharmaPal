package com.example.pharmapal.Controller;

import com.example.pharmapal.Entities.DTOs.FileDto;
import com.example.pharmapal.Entities.DTOs.PathDto;
import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Permissions;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import com.example.pharmapal.Interfaces.DataBaseServiceInterface;
import com.example.pharmapal.Interfaces.PermissionsServiceInterface;
import com.example.pharmapal.Interfaces.ShiftsServiceInterface;
import com.example.pharmapal.Interfaces.StaffServiceInterface;
import com.example.pharmapal.Requests.AssignShiftsRequest;
import com.example.pharmapal.Requests.GrantPermissionsRequest;
import com.example.pharmapal.Requests.ShiftIdRequest;
import com.example.pharmapal.Services.DataBaseService;
import com.example.pharmapal.Services.PermissionsService;
import com.example.pharmapal.Services.ShiftsService;
import com.example.pharmapal.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/PharmaPal/Admin")
public class AdminController {

    private final StaffServiceInterface staffService;
    private final DataBaseServiceInterface dataBaseService;
    private final ShiftsServiceInterface shiftsService;
    private  final PermissionsServiceInterface permissionsService;

@Autowired
    public AdminController(StaffService staffService, DataBaseService dataBaseService, ShiftsService shiftsService, PermissionsService permissionsService) {
        this.staffService = staffService;
    this.dataBaseService = dataBaseService;
    this.shiftsService = shiftsService;

    this.permissionsService = permissionsService;
}


    @GetMapping("/getStaff")
    public ResponseEntity<List<Staff>> getStaff(){
    List<Staff> staff = staffService.getStaff();

    return  new ResponseEntity<>(staff, HttpStatus.OK);

    }
    @PostMapping("/addStaff")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff){
        System.out.println(staff.getUser().getType());
        String response = staffService.addStaffMember(staff);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/updateStaff")
    public ResponseEntity<String> updateStaff(@RequestBody StaffDTO staffDTO){
    String response=  staffService.updateStaffMember(staffDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/terminateStaff")
    public ResponseEntity<String> terminateStaff(@RequestBody Staff staff){
        String response=  staffService.terminateStaff(staff);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/backUpDataBase")
    public ResponseEntity<String> backUpDataBase(@RequestBody PathDto path) throws IOException, InterruptedException {

        String response= dataBaseService.backUpDataBase(path.getPath());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/restoreDataBase")
    public ResponseEntity<String> restoreDataBase(@RequestBody FileDto file) throws IOException, InterruptedException {
        String response= dataBaseService.restoreDataBase(file.getFile());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addShift")
    public ResponseEntity<String> addShift(@RequestBody Shifts shifts){
        String response = shiftsService.addShift(shifts);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }
    @PostMapping("/updateShift")
    public ResponseEntity<String> updateShift(@RequestBody ShiftsDTO shiftsDTO){
        String response = shiftsService.updateShift(shiftsDTO);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/deleteShift")
    public ResponseEntity<String> deleteShift(@RequestBody ShiftIdRequest shifts){
        String response = shiftsService.deleteShift(shifts);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getShifts")
    public ResponseEntity<List<Shifts>> getShifts(){
    List<Shifts> shifts = shiftsService.getShifts();
    return new ResponseEntity<>(shifts, HttpStatus.OK);
    }
    @PostMapping("/assignShift")
    public  ResponseEntity<String> assignShift(@RequestBody AssignShiftsRequest assignShiftsRequest){
    System.out.println(assignShiftsRequest.getShiftId());
        System.out.println(assignShiftsRequest.getStaffId());
        String response = staffService.assignShift(assignShiftsRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/removeFromShift")
    public  ResponseEntity<String> removeFromShift(@RequestBody AssignShiftsRequest assignShiftsRequest){
        String response = staffService.removeFromShift(assignShiftsRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getPermissions")
    public  ResponseEntity<List<Permissions>> getPermission(){
           List<Permissions> permissionsList = permissionsService.getPermissions();
        return new ResponseEntity<>(permissionsList, HttpStatus.OK);
    }

    @PostMapping("/grantPermission")
    public  ResponseEntity<String> grantPermission(@RequestBody GrantPermissionsRequest grantPermissionsRequest){
        String response = staffService.grantPermission(grantPermissionsRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/revokePermission")
    public  ResponseEntity<String> revokePermission(@RequestBody GrantPermissionsRequest grantPermissionsRequest){
        String response = staffService.revokePermission(grantPermissionsRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
