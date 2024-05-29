package com.example.pharmapal.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AssignShiftsRequest {
    @JsonProperty("staffId")
    private Long staffId;

    @JsonProperty("shiftId")
    private Long shiftId;
}
