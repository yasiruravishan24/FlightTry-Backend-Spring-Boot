package com.example.airport;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class AirportApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}
}
