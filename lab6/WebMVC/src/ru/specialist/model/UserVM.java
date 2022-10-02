package ru.specialist.model;

import java.time.LocalTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//   ������

// hours >= 18
// 0 .. 6  ������ ����
// 6 .. 12 ������ ����
// 12 ..18 ������ ����
// 18..23  ������ �����

@Component("userVM")
public class UserVM {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Autowired
	private MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}	
	

	public String getHello() {
		
		//return (getUserName() == null || getUserName().isEmpty()) ? "������!" : 
		//	String.format("������, %s!", getUserName());
		
		int hourNow = LocalTime.now().getHour();
		int numHello = (hourNow >= 0 && hourNow < 6) ? 1 :
							(hourNow >= 6 && hourNow < 12) ? 2 :
								(hourNow >= 12 && hourNow < 18) ? 3 : 
									4;
		String hello = getMessageSource().getMessage("header_hello_"+String.valueOf(numHello),null,Locale.getDefault());
		return (getUserName() == null || getUserName().isEmpty())
				?getMessageSource().getMessage("header_hello_td", 
											   new Object[] {hello},  
											   Locale.getDefault())
				:getMessageSource().getMessage("header_hello_username_td", 
						   new Object[] {hello, getUserName()},  
						   Locale.getDefault())
				;
					
		
		//String hello = getMessageSource().getMessage("header_hello", null, Locale.getDefault());
		
//		return (getUserName() == null || getUserName().isEmpty() ? hello :
//			getMessageSource().getMessage("header_hello_username", 
//					new Object[] {getUserName()}, Locale.getDefault()));
		
	}
	

}
