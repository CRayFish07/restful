package com.vteba.user.model;

import java.util.Date;

/**
 * �û�ʵ����
 * 
 * @author yinlei
 * @see
 * @since 2015��4��28�� ����10:21:41
 */
public class User {
	private Long id;
	private String name;
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
