package com.trustfinity.lmswebsite.globalExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<ExceptionModel> catchException(Exception e){
		logger.error("chcked exception",e);
		ExceptionModel exceptionModel = new ExceptionModel();
		
		exceptionModel.setE(e);
		
		exceptionModel.setMessage("chcked exception");
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<ExceptionModel> catchRuntimeException(Exception e){
		logger.error("runtime exception",e);
		ExceptionModel exceptionModel = new ExceptionModel();
		
		exceptionModel.setE(e);
		
		exceptionModel.setMessage("runtime exception");
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	@ExceptionHandler(value=EmailNotFound.class)
	public ResponseEntity<ExceptionModel> CatchEmailNotFound(EmailNotFound emailNotFound){
		logger.error("Email is not found",emailNotFound);
		
		ExceptionModel exceptionModel = new ExceptionModel();
		exceptionModel.setE(emailNotFound);
		exceptionModel.setMessage("This email address does't exists");
		
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value=EmailFound.class)
	public ResponseEntity<ExceptionModel> CatchEmailFound(EmailFound emailFound){
		logger.error("Email found",emailFound);
		
		ExceptionModel exceptionModel = new ExceptionModel();
		exceptionModel.setE(emailFound);
		exceptionModel.setMessage("This email address  exists");
		
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(value=PasswordNotMatch.class)
	public ResponseEntity<ExceptionModel> catchPasswordNotMatch(PasswordNotMatch passwordNotMatch){
		
		logger.error("password not Match");
		ExceptionModel exceptionModel = new ExceptionModel();
		exceptionModel.setE(passwordNotMatch);
		exceptionModel.setMessage("password not Match");
		
		
		return new ResponseEntity<ExceptionModel>(exceptionModel,HttpStatus.BAD_REQUEST);
		
	}
	


}
