package com.example.pharmapal.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShiftIdRequest {

    @JsonProperty("shiftId")
    private Long shiftId;
}
