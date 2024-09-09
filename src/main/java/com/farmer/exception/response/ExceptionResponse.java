package com.farmer.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ExceptionResponse {

  private String message;
  private String traceMessage;
  private int statusCode;

  public ExceptionResponse(){

  }

  public ExceptionResponse(String message, String traceMessage, int statusCode) {
    this.message = message;
    this.traceMessage = traceMessage;
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTraceMessage() {
    return traceMessage;
  }

  public void setTraceMessage(String traceMessage) {
    this.traceMessage = traceMessage;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }
}
