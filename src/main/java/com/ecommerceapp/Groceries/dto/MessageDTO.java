package com.ecommerceapp.Groceries.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
	
	public String message;
	public MessageDTO(String message)
	{
		this.message=message;
	}

}
