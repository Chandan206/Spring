package com.sb.mini1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.mini1.entity.Plan;
import com.sb.mini1.services.PlanService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class PlanController {
	@Autowired
	private PlanService planService;
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> categories=planService.getPlan_Catagory();
		return new ResponseEntity<>(categories,HttpStatus.OK);	
	}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMsg="";
		boolean isSaved=planService.savePlan(plan);
		if(isSaved) {
			responseMsg="Plan Saved";
		}else {
			responseMsg="Plan Not Saved";
		} 
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);	
	}
	@GetMapping("/viewplans")
	public ResponseEntity<List<Plan>> plans(){
		
		List<Plan> lp=planService.getAllPlan();
		return new ResponseEntity<>(lp,HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/editplan/{planId}")
	public ResponseEntity<Plan> editplan(@PathVariable Integer planId){
		
		Plan plan=planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
  @PutMapping("/plan")
	public ResponseEntity<String> updateplan(@RequestBody Plan plan){
	  String msg="";
		boolean isUpdated=planService.updatePlan(plan);
		if(isUpdated) {
			msg="Plan Saved";
		}else {
			msg="Plan Not Saved";
		} 
		return new ResponseEntity<>(msg,HttpStatus.OK);	
	}
  @DeleteMapping("/deletePlan/{planId}")
  public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
	boolean isDeleted=planService.deleteById(planId);
	String dmsg="";
	if(isDeleted) {
		dmsg="Plan Deleted";
	}else {
		dmsg="Plan Not Deleted";
	} 
	return new ResponseEntity<>(dmsg,HttpStatus.OK);	
  }
  @PutMapping("/change_status")
	public ResponseEntity<String> updateStatus(Integer planId,String status){
	String statusMsg="";
	 boolean changeStatus =planService.planStatusChange(planId, status);
	  if(changeStatus) {
		  statusMsg="Plan Status Changed";
		}else {
			statusMsg="Plan Status Not Changed";
		} 
		return new ResponseEntity<>(statusMsg,HttpStatus.OK);	
	}

}
