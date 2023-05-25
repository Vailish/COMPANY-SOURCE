package com.jobtang.sourcecompany.api.exception.mattermost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@ControllerAdvice
public class GrobalControllerAdvice {
    @Autowired
    private NotificationManager notificationManager;

//    @ExceptionHandler(Exception.class)
//    public void exceptionTest(Exception e, HttpServletRequest req) {
//        e.printStackTrace();
//        System.out.println("여기들어옴1");
//        notificationManager.sendNotification(e, req.getRequestURI(), getParams(req));
//        System.out.println("여기들어옴2");
////        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private String getParams(HttpServletRequest req) {
//        StringBuilder params = new StringBuilder();
//        Enumeration<String> keys = req.getParameterNames();
//        while (keys.hasMoreElements()) {
//            String key = keys.nextElement();
//            params.append("- ").append(key).append(" : ").append(req.getParameter(key)).append("\n");
//        }
//
//        return params.toString();
//    }
}
