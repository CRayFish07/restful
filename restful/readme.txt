1��restful�������UserRestServcie.java

2����Ӧ�Ĳ��Է����ֱ���
http://localhost:8090/restful/add.jsp��������ӵ�(@POST)
http://localhost:8090/restful/index.jsp
ҳ���е� ���º�ɾ����ť����  ����(@UPDATE)��ɾ����@DELETE����

֮����дǰ����������������Ϊ �������һ��û��ʵ��update��delete������postҲҪ���ύ��
����ͨ�õ������� ʹ��jquery��js���ģ�⡣����ֱ��ʹ�� Apache�� httpclient����������
restful webservice�����ṩҵ���

��ѯ��@GET����ֱ�����������http://localhost:8090/restful/rest/user/detail/2

3����spring mvc����spring ��Ϻ���web.xml���������б仯
ԭ����listener���ˣ�������Ĵ���
<!-- resteasy������ʼ�������� -->
	<listener>
      	<listener-class>org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap</listener-class> 
   	</listener>
   	<!-- resteasy��spring���ϣ����������ContextLoaderListener�Ͳ�Ҫ��  -->
	<listener>
		<listener-class>com.vteba.service.context.listener.SpringContextLoaderListener</listener-class>
  	</listener>

4�����������resteasy ���� url�ģ�Ϊ�˺�spring mvc���֣�һ��Ҫ���һ��ǰ׺
	
<!-- Ҫָ��ǰ׺�����spring mvc��url-pattern��ͻ������һ�ֽ���취���ǽ�spring mvc��reseasy������һ��
		tomcat����Ҫ�����jboss�о�Ҫע�͵���
	 -->
	<servlet>
      	<servlet-name>resteasy</servlet-name>
      	<servlet-class>org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher</servlet-class>
      	<init-param>
      		<param-name>resteasy.servlet.mapping.prefix</param-name>
        	<param-value>/rest</param-value>
      	</init-param>
    </servlet>
  
   	<servlet-mapping>
      	<servlet-name>resteasy</servlet-name>
      	<url-pattern>/rest/*</url-pattern>t
   	</servlet-mapping>
   	
5����spring mvc���ϣ���Ҫ�� spring���������ļ�application-context.xml������ 
<!-- Import basic SpringMVC Resteasy integration -->
    <import resource="classpath:springmvc-resteasy.xml"/>
��������ļ���������resteasy-spring-3.0.11.Final.jar��

6�������ﷵ�غͽ���json�����ݣ�ʹ��fastjson��ʵ�֣�
��application-context.xml�У�������
<bean id="fastjsonProvider" class="com.vteba.service.json.jaxrs.FastJsonProvider"></bean>

һ�㣬resteasy��ʹ��jackson���ṩ�ߡ��������滻�����ܺ�һЩ��

7������Ŀ���뵽eclipse�У�����tomcat���Ե����ˡ�