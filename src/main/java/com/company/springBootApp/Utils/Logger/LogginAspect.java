package com.company.springBootApp.Utils.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	private static final Logger LOG = LoggerFactory.getLogger(LogginAspect.class);
	
	@Before("execution(public * com.company.springBootApp.controllers.UsersController.getAllUsers())")
	public void logBeforeGetAllUsers() {
		LOG.info("Log before execute getAllUsers");
	}
	
	@After("execution(public * com.company.springBootApp.controllers.UsersController.getAllUsers())")
	public void logAfterGetAllUsers() {
		LOG.info("Log after execute getAllUsers");
	}
	
	@AfterThrowing("execution(public * com.company.springBootApp.controllers.UsersController.getAllUsers())")
	public void logAfetIfaExecprtion() {
		LOG.info("Log for a issue in getAllUsers");
	}
	
}
