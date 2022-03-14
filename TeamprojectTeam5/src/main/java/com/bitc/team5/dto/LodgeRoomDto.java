package com.bitc.team5.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class LodgeRoomDto {
	private int seq;
	private String lodgeName;
	private String lodgeImg;
	private int lodgeScore;
	private String roomImg;
	private String roomName;
	private String roomType;
	private int roomPrice;
	private int roomCount;
	private Date chkInDate;
	private Date chkOutDate;
	private String soldOut;
}
