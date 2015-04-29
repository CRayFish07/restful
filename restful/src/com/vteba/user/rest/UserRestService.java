package com.vteba.user.rest;

import java.util.Date;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vteba.user.model.User;

/**
 * resteasyʵ�ֵ�restful webservice����
 * 
 * @author yinlei
 * @see
 * @since 2015��4��29�� ����10:16:58
 */
@Path("/user")
@Named
public class UserRestService {
	
	@GET
	@Path("/detail")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public User get() {
		User user = new User();
		user.setId(11L);
		user.setName("yinlei");
		user.setCreateDate(new Date());
		return user;
	}
}
