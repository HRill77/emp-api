package com.codeWithProject.employee.payload.message;

public class ErrorResponse {
    private String timestamp;
    private int status;
    private String error;
    // private String message;
    private String path;
    
    public ErrorResponse( int status, String error, String path) {
        this.timestamp = java.time.Instant.now().toString();
        this.status = status;
        this.error = error;
        this.path = path;
    }


    
    
}
