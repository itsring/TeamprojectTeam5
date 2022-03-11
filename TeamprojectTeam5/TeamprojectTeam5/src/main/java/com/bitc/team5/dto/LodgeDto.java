package com.bitc.team5.dto;



import java.sql.Date;

import lombok.Data;

@Data
public class LodgeDto {
	
	private int lodgeSeq;
	private String lodgeAddressName;
	private String lodgeName;
	private String lodgeUrl;
	private String lodgeId;
	private String lodgePhone;
	private String userEmail;
	private Date bookDate;
	private Date chkInDate;
	private Date chkOutDate;
}
