package com.bank;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.bank.util.DecodeService;
@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = {"com.bank.*" })
//@PropertySource("classpath:application.properties")
//@ImportResource("spring-beans.xml")
public class BankApplication {
	 @Value("${security.user.password}")
	 private static String password2Go;
	 
	 @Bean
	   public static PropertySourcesPlaceholderConfigurer
	     propertySourcesPlaceholderConfigurer() {
	      return new PropertySourcesPlaceholderConfigurer();
	   }

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		
		String orig = "original String before base64 encoding in Java";

		  //encoding  byte array into base 64
        byte[] encoded = Base64.encodeBase64(orig.getBytes());   
        
        System.out.println("Original String: " + orig );
        System.out.println("Original String: " + encoded);
        
        System.out.println("Base64 Encoded String : " + new String(encoded));
        
        //decoding byte array into base64
       // byte[] decoded = Base64.decodeBase64(encoded);
        String password = "b3JpZ2luYWwgU3RyaW5nIGJlZm9yZSBiYXNlNjQgZW5jb2RpbmcgaW4gSmF2YQ==";
        byte[] bytes = password.getBytes();
        byte[] decoded = Base64.decodeBase64(bytes);
        //String passWord = new String(decoded);
        
        DecodeService decodeService = new DecodeService();
        String passWord = decodeService.decode(bytes);
        System.out.println("Base 64 Decoded  String : " + new String(decoded));
     System.out.println("password2Go  : " + password2Go );
        









	}
}
