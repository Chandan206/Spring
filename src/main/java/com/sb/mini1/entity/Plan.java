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
	@Table(name="PLAN_MASTER")
	public class Plan{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="PLAN_ID")
		private Integer planId;
		@Column(name="PLAN_NAME")
		private String planName;
		@Column(name="PLAN_CategoryId")
		private String planCategoryId;
		@Column(name="PLAN_START_DATE")
		private Date planStartDate;
		@Column(name="PLAN_END_DATE")
		private Date planEndDate;
		@Column(name="aCTIVE_SW")
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
