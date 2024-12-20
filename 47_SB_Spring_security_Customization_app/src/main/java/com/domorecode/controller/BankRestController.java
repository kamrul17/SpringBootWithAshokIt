package com.domorecode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BankRestController {

	
	@GetMapping("/transfer")
	public String amtTransfer() {
		return "Amount transfer successfull";
	}
	@GetMapping("/login-check")
	public String loginMsg() {
		return "Login successfully";
	}
	@GetMapping("/logout-check")
	public String logoutMsg() {
		return "Logout successfully";
	}
	@GetMapping("/contact")
	public String getContactInfo() {
		return "abc@gmail.com";
	}
	@GetMapping("/balance")
	public String amountdetails() {
		return "your balance::7292 INR";
	}
}