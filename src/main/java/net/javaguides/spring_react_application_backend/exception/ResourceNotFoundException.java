package net.javaguides.spring_react_application_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// HogeExceptionControllerAdviceクラスを定義し、そちらに
// @ResponseBodyアノテーションなどを付ければ
// レスポンスボディにメッセージ以外(json等)が設定できる
// ResourceNotFoundExceptionControllerAdviceを参照

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
