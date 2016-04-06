package com.trs.demo.data.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.trs.demo.model.ContextHolder;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = -2955330485748809219L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * 对象创建时间
	 */
	private long createdTime;

	/**
	 * 创建用户
	 */
	private String createdUser;

	/**
	 * 最后修改时间
	 */
	private long lastModifiedTime;

	/**
	 * 最后修改用户
	 */
	private String lastModifiedUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	
	@PrePersist
	protected void onCreate() {
		createdTime = System.currentTimeMillis();
		createdUser = ContextHolder.getCurrentUserName();
	}
	
	@PreUpdate
	protected void onUpdate() {
		lastModifiedTime = System.currentTimeMillis();
		lastModifiedUser = ContextHolder.getCurrentUserName();
	}
	
	
}
