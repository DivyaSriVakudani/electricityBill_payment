
package com.oebp.exceptions;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

 

import java.util.List;

 

@RestControllerAdvice
public class GlobalExceptionHandler1 extends RuntimeException{
    @ExceptionHandler(DuplicateCustomerException.class)
    public String handleMyException1(DuplicateCustomerException ex)
    {
        return "DuplicateCustomerException"+ex.getMessage();
    }
    @ExceptionHandler(NoSuchCustomerException.class)
    public String handleMyException2(NoSuchCustomerException ex)
    {
        return "NoSuchCustomerException:"+ex.getMessage();
    }

 

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMyException2(MethodArgumentNotValidException ex)
    {
        Map<String,String> m=new LinkedHashMap<>();
        List<ObjectError>  oerrors =ex.getAllErrors();
        oerrors.forEach(obj->{
            FieldError ferror=(FieldError)obj;
            String fname=ferror.getField();
            String message=ferror.getDefaultMessage();
            m.put(fname, message);
        });
        return m;
    }

 

}
