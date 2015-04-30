package com.vteba.service.restful.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.vteba.user.model.User;
import com.vteba.utils.charstr.StringUtils;

/**
 * �����͵��ύ�����ݽ����������ܱ�post�ύ������json���ݡ�
 * 
 * @author yinlei
 * @see
 * @since 2015��4��30�� ����10:26:23
 */
@Named// ��ʾһ��bean
@Provider// ��ʾ��һ�����ݽ����ṩ��
@Consumes(value = { MediaType.APPLICATION_FORM_URLENCODED })// ���ܱ����͵�����
@Produces(value = { MediaType.APPLICATION_JSON })// ����json��ʽ������
public class DefaultFormProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// ����һ��Ҫ��һЩ���ƣ�����mediaType���Ȳ���
		return true;
	}

	@Override
	public long getSize(Object t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		
		return -1L;
	}

	// ����json���ݸ����ö�
	@Override
	public void writeTo(Object t, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		
		byte[] b = JSON.toJSONBytes(t);
		entityStream.write(b);
	}

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		// һ��Ҫ����֤
		return true;
	}

	// �ӿͻ����ύ�����ݣ���������
	@Override
	public Object readFrom(Class<Object> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		// ����ֻ�Ǽ򵥵Ĵ����ˣ���ͨ�õ������� Ҫ�ܹ������κ����͡�
		User user = new User();
		
		String content = IOUtils.toString(entityStream);
		String[] forms = content.split("&");
		if (forms != null) {
			for (String form : forms) {
				String[] args = form.split("=");
				if (args != null && args.length == 2) {
					String key = args[0];
					String value = args[1];
					if (key.equals("id")) {
						Long id = Long.valueOf(value);
						user.setId(id);
						continue;
					} else if (key.equals("name")) {
						user.setName(value);
						continue;
					}
				}
			}
		}
		return user;
	}

	public static String buildJson(String content) {
		if (StringUtils.hasText(content)) {
			StringBuilder json = new StringBuilder("{");
			boolean append = false;
			String[] forms = content.split("&");
			if (forms != null) {
				for (String form : forms) {
					String[] args = form.split("=");
					if (args != null && args.length == 2) {
						String key = args[0];
						String value = args[1];
						if (key != null && value != null) {
							if (key.indexOf(".") > -1) {// ���ж༶����
								
							} else {
							}
							if (!append) {
								json.append("\"").append(key).append("\":\"").append(value).append("\"");
								append = true;
							} else {
								json.append(",\"").append(key).append("\":\"").append(value).append("\"");
							}
						}
					}
				}
			}
			return json.append("}").toString();
		}
		return null;
	}
	
	public static String buildJson(InputStream is) {
		try {
			String content = IOUtils.toString(is);
			return buildJson(content);
		} catch (IOException e) {
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		StringBuilder text = new StringBuilder();
		text.append("{\"").append("id\":\"").append("2\",").append("\"name\":\"yinlei\"}");
		User user = JSON.parseObject(text.toString(), User.class);
		System.out.println(user);
		long d = System.currentTimeMillis();
		String content = "id=22&name=yinlei&createDate=2015-04-30 14:22:17";
		content = buildJson(content);
		user = JSON.parseObject(content, User.class);
		System.out.println(System.currentTimeMillis() - d);
	}
}
