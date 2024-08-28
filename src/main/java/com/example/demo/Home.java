package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Home {

	private String owner;
	private int doorno;
	
	public Home(){
//		this.owner=owner;
//		this.doorno=doorno;
//		owner = "parker";
//		doorno=10;
		
		System.out.println("Constructor");
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getDoorno() {
		return doorno;
	}

	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	void connect() {
		System.out.println("connetion is done");
	}
}
