package com.campTag.model;

import java.io.Serializable;
//營地標籤(camp_tag)
public class CampTagVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer campTagId;  //營地標籤流水號
	private String campTagName;  //營地標籤名稱
	
	public CampTagVO(){
		
	}
	
	public CampTagVO(Integer campTagId, String campTagName) {
		this.campTagId = campTagId;
		this.campTagName = campTagName;
	}
	

	public Integer getCampTagId() {
		return campTagId;
	}

	public void setCampTagId(Integer campTagId) {
		this.campTagId = campTagId;
	}

	public String getCampTagName() {
		return campTagName;
	}

	public void setCampTagName(String campTagName) {
		this.campTagName = campTagName;
	}

	@Override
	public String toString() {
		return "CampTagVO [campTagId=" + campTagId + ", campTagName=" + campTagName + "]";
	}


}