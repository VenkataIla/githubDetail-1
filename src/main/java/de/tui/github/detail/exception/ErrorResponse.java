package de.tui.github.detail.exception;

import org.springframework.http.HttpStatus;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorResponse
{
    private HttpStatus status;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + getStatus() +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}