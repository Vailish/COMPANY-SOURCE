package com.jobtang.sourcecompany.api.exception.customerror;

import com.jobtang.sourcecompany.api.exception.mattermost.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorControllerAdvice {
    @Autowired
    private NotificationManager notificationManager;

//    @ExceptionHandler(value = Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
//        ErrorResponse response = ErrorResponse.of(ErrorCode.TEMPORARY_SERVER_ERROR);
//        response.setDetail(e.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(Exception.class)
    public void exceptionTest(Exception e, HttpServletRequest req) {
        e.printStackTrace();
        notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<ErrorResponse> handleNoSuchElementException(Exception e) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
        response.setDetail(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    //요 밑으로 쭉쭉 추가적인 ExceptionHandler들을 추가해서 처리합니다

    /* Custom Error Handler */
    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e, HttpServletRequest req) {
        notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
        ErrorResponse response = ErrorResponse.of(e.getErrorCode());
        response.setDetail(e.getMessage());
//        HttpStatus httpStatus = HttpStatus.valueOf(response.getCode());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    private String getParams(HttpServletRequest req) {
        StringBuilder params = new StringBuilder();
        Enumeration<String> keys = req.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            params.append("- ").append(key).append(" : ").append(req.getParameter(key)).append("\n");
        }

        return params.toString();
    }
}
