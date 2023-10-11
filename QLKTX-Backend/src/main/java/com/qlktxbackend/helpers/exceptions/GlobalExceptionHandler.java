package com.qlktxbackend.helpers.exceptions;

import com.sct.vedi.helpers.ExceptionDTOResponse;
import com.sct.vedi.helpers.ResponseStatusCodeEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTOResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.NOT_FOUND.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionDTOResponse> recordNotFound(RecordNotFoundException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ExceptionDTOResponse resourceNotFound(NotFoundException ex) {
//        ExceptionDTOResponse response = new ExceptionDTOResponse();
//        response.setErrorCode(ResponseStatusCodeEnum.NOT_FOUND.getCode());
//        response.setErrorMessage(ResponseStatusCodeEnum.NOT_FOUND.getMessage());
//        response.setTimestamp(new Date());
//        return response;
//    }


    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ExceptionDTOResponse> resourceAlreadyExists(ResourceAlreadyExists ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.CONFLICT.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionDTOResponse> customException(CustomException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionDTOResponse> unauthorizedException(UnauthorizedException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.UNAUTHORIZED.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


//    @ExceptionHandler(UnauthorizedException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ExceptionDTOResponse handleUnauthorized(UnauthorizedException ex) {
//        ExceptionDTOResponse response = new ExceptionDTOResponse();
//        response.setErrorCode(ResponseStatusCodeEnum.UNAUTHORIZED.getCode());
//        response.setErrorMessage(ResponseStatusCodeEnum.UNAUTHORIZED.getMessage());
//        response.setTimestamp(new Date());
//        return response;
//    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<ExceptionDTOResponse> systemException(SystemException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.INTERNAL_SERVER_ERROR.getCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // yêu cầu không hợp lệ
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(errors.toString());
        response.setTimestamp(new Date());

        return handleExceptionInternal(
                ex, response, headers, HttpStatus.BAD_REQUEST, request);
    }

    // thiếu tham số
    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(error);
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    // tham số khác kiểu yêu cầu
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error =
                ex.getName() + " should be of type " + ex.getRequiredType().getName();

        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(error);
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    // 404 not found
    @Override
    public ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(error);
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    // method http not support
    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(
                " method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.METHOD_NOT_ALLOWED.getCode());
        response.setErrorMessage(builder.toString());
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({MissingRequestParameter.class})
    public ResponseEntity<Object> handleMissingRequestParameter(MissingRequestParameter ex) {
        String error = ex.getMessage();
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(error);
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException ex) {
        String error = "File vượt quá dung lượng cho phép!";
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
        response.setErrorMessage(error);
        response.setTimestamp(new Date());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler({
//            HttpMessageNotReadableException.class,
//            HttpMediaTypeNotSupportedException.class,
//    })
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Object> handleInvalidPayload(Exception ex) {
//        ExceptionDTOResponse response = new ExceptionDTOResponse();
//        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
//        response.setErrorMessage(ResponseStatusCodeEnum.BAD_REQUEST.getMessage());
//        response.setTimestamp(new Date());
//        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleInvalid(InvalidParameterException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.BAD_REQUEST.getCode());
//        response.setErrorMessage(ResponseStatusCodeEnum.BAD_REQUEST.getMessage());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleInternal(InternalServerException ex) {
        ExceptionDTOResponse response = new ExceptionDTOResponse();
        response.setErrorCode(ResponseStatusCodeEnum.INTERNAL_SERVER_ERROR.getCode());
//        response.setErrorMessage(ResponseStatusCodeEnum.BAD_REQUEST.getMessage());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(new Date());
        return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}