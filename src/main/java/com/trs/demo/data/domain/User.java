package com.trs.demo.data.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author leeyao
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String displayName;
	
	private String password;

}
