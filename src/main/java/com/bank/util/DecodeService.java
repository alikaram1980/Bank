package com.bank.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class DecodeService {
	private @Value("${security.user.password}")
	 String password2Go;
	
	public String decode ( byte[] password){
		 byte[] decoded = Base64.decodeBase64(password);
		 String passWord = new String(decoded);
		 System.out.println("password2Go from decode service  : " + password2Go );
		return passWord;
		
	}
}
