package com.itp.ITPJuneFirstSpringboot.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String errorType;
	private String errorMessage;
	private LocalDateTime errorTimestamp;
	private int httpStatusCode;
}
