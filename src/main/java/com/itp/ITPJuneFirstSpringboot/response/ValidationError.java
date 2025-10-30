package com.itp.ITPJuneFirstSpringboot.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {
	
    private String message;
    private String field;
    private Object rejectedValue;
}
