package com.ecommerceapp.medicalapp;

import lombok.Data;

@Data
public class MessageDTO {
   private String message=null;
   
   public MessageDTO (String message) {
	   this.message= message;
	   
	   
	   
   }
}
