package com.example.park.Controllers;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException() {
	    super("Customer id not found : ");
	  }
	

}
