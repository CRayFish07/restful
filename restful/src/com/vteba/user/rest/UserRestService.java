package com.vteba.user.rest;

import java.util.Date;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Named// ��ʾ��һ��bean����spring����
@Path("/user")// ӳ��·��
public class UserRestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GET// ���ڲ�ѯ
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
	
	@POST// һ���������
	@Path("/add")
	public Response add(User user) {
		LOGGER.info("�յ�����user.id=[{}], user.name=[{}]", user.getId(), user.getName());
		return Response.ok().build();
	}
	
	@PUT// һ�������޸ģ������û���ṩput����������Ҫ��jquery���ṩ��ģ�ⷽ��
	@Path("/update")
	@Consumes(value = { MediaType.APPLICATION_JSON })// ����json���͵�����
	public Response update(User user) {
		LOGGER.info("�յ�����user.id=[{}], user.name=[{}]", user.getId(), user.getName());
		return Response.ok().build();
	}
	
	@DELETE// һ������ɾ��
	@Path("/delete/{userId}")
	public Response delete(@PathParam("userId") Long userId) {
		
		return Response.ok().build();
	}
}
