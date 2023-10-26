package com.sb.mini1.services;

import java.util.List;
import java.util.Map;

import com.sb.mini1.entity.Plan;

public interface PlanService {

	public Map<Integer, String> getPlan_Catagory();
	
	public Boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer planID);
	
	public Boolean updatePlan(Plan plan);
	
	public Boolean deleteById(Integer planId);
	
	public Boolean planStatusChange(Integer planId,String status);
}
