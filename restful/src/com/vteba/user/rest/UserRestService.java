package com.vteba.user.rest;

import java.util.Date;

import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.vteba.user.model.User;
import com.vteba.user.service.UserServiceImpl;

/**
 * resteasyʵ�ֵ�restful webservice����
 * 
 * @author yinlei
 * @see
 * @since 2015��4��29�� ����10:16:58
 */
@Named
@Path("/user")
public class UserRestService {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GET
	@Path("/detail/{userId}")// ����·������
	@Produces(value = { MediaType.APPLICATION_JSON })// ����Json��ʽ������
	public User get(@PathParam("userId") Long userId) {// ��ȡ·��������Ϊ���
		User user = new User();
		user.setId(11L);
		user.setName("yinlei");
		user.setCreateDate(new Date());
		
		userServiceImpl.save(user);
		
		return user;
	}
	
	@POST
	@Path("/add")
	public Response add(User user) {
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/update")
	public Response update() {
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/delete/{userId}")
	public Response delete(@PathParam("userId") Long userId) {
		
		return Response.ok().build();
	}
}
