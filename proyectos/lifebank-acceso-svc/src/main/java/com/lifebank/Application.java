package com.lifebank;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		try {
			System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
			SpringApplication.run(Application.class, args);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
