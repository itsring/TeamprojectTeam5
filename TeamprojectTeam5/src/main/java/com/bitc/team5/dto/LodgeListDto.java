package com.bitc.team5.dto;

import lombok.Data;

@Data
public class LodgeListDto {
	private int seq;
	private String placeName;
	private String lodgeAddressName;
	private String lodgeName;
	private String lodgePhone;
	private double lodgeScore;
	private String lodgeImg;
	private String lodgeLatitude;
	private String lodgeLongitude;
}
