package com.sb.mini1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	@Column(name="ACTIVE_SW")
	private String activeSw;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="UPDATED_BY")
	private String updatedBy;
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable = false)
	private Date updatedDate;
	
	

}