package com.campTagDetail.model;

import java.io.Serializable;
//營地標籤明細(camp_tag_detail)
public class CampTagDetailVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	Integer campTagId;   //營地標籤流水號
	private Integer campId;      //營地流水號
	private Integer campTagIdNew;
	private Integer campIdNew;
	public CampTagDetailVO() {

	}
	public Integer getCampTagId() {
		return campTagId;
	}
	public void setCampTagId(Integer campTagId) {
		this.campTagId = campTagId;
	}
	public Integer getCampId() {
		return campId;
	}
	public void setCampId(Integer campId) {
		this.campId = campId;
	}
	public Integer getCampTagIdNew() {
		return campTagIdNew;
	}
	public void setCampTagIdNew(Integer campTagIdNew) {
		this.campTagIdNew = campTagIdNew;
	}
	public Integer getCampIdNew() {
		return campIdNew;
	}
	public void setCampIdNew(Integer campIdNew) {
		this.campIdNew = campIdNew;
	}
	@Override
	public String toString() {
		return "CampTagDetailVO [campTagId=" + campTagId + ", campId=" + campId + ", campTagIdNew=" + campTagIdNew
				+ ", campIdNew=" + campIdNew + "]";
	}
	
	
	
}