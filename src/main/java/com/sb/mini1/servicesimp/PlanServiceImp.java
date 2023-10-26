package com.sb.mini1.servicesimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sb.mini1.entity.Plan;
import com.sb.mini1.entity.PlanCategory;
import com.sb.mini1.repository.PlanCategoryRepo;
import com.sb.mini1.repository.PlanRepo;
import com.sb.mini1.services.PlanService;
@Service
public class PlanServiceImp implements PlanService {
	
	@Autowired
	private PlanRepo planrepo;
	@Autowired
	private PlanCategoryRepo planCategoryrepo;

	@Override
	public Map<Integer, String> getPlan_Catagory() {
		 List<PlanCategory> pc =planCategoryrepo.findAll();
		 Map<Integer, String> mp=new HashMap<>();
		 pc.forEach(catogory->{
			 mp.put(catogory.getCategoryId(), catogory.getCategoryName()); });
		return mp;
	}

	@Override
	public Boolean savePlan(Plan plan) {
		Plan p= planrepo.save(plan);
		return p.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlan() {
		// TODO Auto-generated method stub
		List<Plan> lp=planrepo.findAll();
		return lp;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> po=planrepo.findById(planId);
		if(po.isPresent()) {
		return po.get();
		}
		return null;
	}

	@Override
	public Boolean updatePlan(Plan plan) {
		planrepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public Boolean deleteById(Integer planId) {
		boolean status=false;
		try {
		planrepo.deleteById(planId); 
		status=true;
	}catch(Exception e) {
		e.printStackTrace();
	}
   return status;
	}
	@Override
	public Boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> op=planrepo.findById(planId);
		if(op.isPresent()) {
			Plan plan=op.get();
			plan.setActiveSw(status);
			planrepo.save(plan);
			return true;
		}
		return false;
	}

}
