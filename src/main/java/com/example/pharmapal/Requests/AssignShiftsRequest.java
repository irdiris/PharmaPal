package com.example.pharmapal.Requests;

import com.example.pharmapal.Entities.Shifts;
import com.example.pharmapal.Entities.Staff;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AssignShiftsRequest {
    @JsonProperty("staffId")
    private Long staffId;

    @JsonProperty("shiftId")
    private Long shiftId;
}
