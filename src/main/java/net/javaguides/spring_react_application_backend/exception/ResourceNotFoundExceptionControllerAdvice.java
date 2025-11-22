//package net.javaguides.spring_react_application_backend.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//
//// 使う場合はExceptionクラスのフィールドに
//// private static final long serialVersionUID = 1L;
//// を追加
//@ControllerAdvice
//public class ResourceNotFoundExceptionControllerAdvice {
//
//    @ResponseBody
//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String resourceNotFoundHandler(ResourceNotFoundException ex){
//        return ex.getMessage();
//    }
//}
