package com.example.addressbook.exception;

import com.example.addressbook.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@ControllerAdvice
public class AddressBookExceptionHandler {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ResponseDTO> handleException(MethodArgumentNotValidException exception){
//        List<String> errorList = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).
//                collect(Collectors.toList());
//        return new ResponseEntity<>(new ResponseDTO("Exceptions while processing REST request",errorList),
//                HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(AddressBookException.class)
//    public ResponseEntity<ResponseDTO> customException(AddressBookException exception){
//        return new ResponseEntity<>(new ResponseDTO("Exceptions while processing REST request",exception.getMessage()),
//                HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleException(MethodArgumentNotValidException exception){
    List<String> errorList = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).
            collect(Collectors.toList());
    return new ResponseEntity<>(new ResponseDTO("Exceptions while processing REST request",errorList),
            HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> customException(AddressBookException exception){
        return new ResponseEntity<>(new ResponseDTO("Exceptions while processing REST request",exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
