package com.example.pharmapal.Controller;

import com.example.pharmapal.Entities.DTOs.FileDto;
import com.example.pharmapal.Entities.DTOs.PathDto;
import com.example.pharmapal.Entities.DTOs.ShiftsDTO;
import com.example.pharmapal.Entities.DTOs.StaffDTO;
import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import com.example.pharmapal.Services.DataBaseService;
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

    private final StaffService staffService;
    private final DataBaseService dataBaseService;
    private final ShiftsService shiftsService;

@Autowired
    public AdminController(StaffService staffService, DataBaseService dataBaseService, ShiftsService shiftsService) {
        this.staffService = staffService;
    this.dataBaseService = dataBaseService;
    this.shiftsService = shiftsService;

}


    @GetMapping("/getStaff")
    public ResponseEntity<List<Staff>> getStaff(){
    List<Staff> staff = staffService.getStaff();

    return  new ResponseEntity<>(staff, HttpStatus.OK);

    }
    @PostMapping("/addStaff")
    public ResponseEntity<String> addStaff(@RequestBody Staff staff){
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
    public ResponseEntity<String> deleteShift(@RequestBody Shifts shifts){
        String response = shiftsService.deleteShift(shifts);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getShifts")
    public ResponseEntity<List<Shifts>> getShifts(){
    List<Shifts> shifts = shiftsService.getShifts();
    return new ResponseEntity<>(shifts, HttpStatus.OK);
    }
    @PostMapping("/assignShifts")
    public  ResponseEntity<String> assignShifts(@RequestBody Staff staff, @RequestBody  Shifts shifts){
          String response =  staffService.assignShifts(staff, shifts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
