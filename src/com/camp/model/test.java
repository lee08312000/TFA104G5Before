package com.camp.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.campTagDetail.model.CampTagDetailService;
import com.campTagDetail.model.CampTagDetailVO;

public class test {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("SELECT  *  FROM camp where camp_name like '%%' ");
		int o = str.indexOf("%");
		System.out.println(o);
		str = str.insert(44, "i love me");
		System.out.println(str);

	}

}
