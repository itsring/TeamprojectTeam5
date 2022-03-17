package com.bitc.team5.dto;



import java.sql.Date;

import lombok.Data;

@Data
public class LodgeDto {
	
	private int seq;
	private String roomImg;
	private String lodgeName;
	private String roomType;
	private Date chkInDate;
	private Date chkOutDate;
	private String userEmail;
	private int roomCount;
	private int roomPrice;
}
