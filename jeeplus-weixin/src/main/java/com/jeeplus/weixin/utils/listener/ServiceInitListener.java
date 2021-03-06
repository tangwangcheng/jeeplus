//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ServiceInitListener.java
//  @ Date : 2013/1/16
//  @ Author : czp
//	@ Title : 初始化
//  @ Description :  添加 到WEB进行启动执行，对全文进行配置加载
//
//
package com.jeeplus.weixin.utils.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jeeplus.weixin.utils.PropertiesUtil;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
 

public class ServiceInitListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(ServiceInitListener.class);
	
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			// 取得该应用的ServletContext实例
			ServletContext application = sce.getServletContext();
 
			// 获取配置文件发布到tomcate后的路径
		    String confFile = application.getRealPath("/WEB-INF/classes/conf.properties");
		    /*    new SpringContext().setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(application));
 		    */

		    
			// 初始化用户自定义属性对象
			PropertiesUtil.createProperties(confFile);
			System.out.println(PropertiesUtil.getConfigProperty().getProperty("mail.password"));
			System.out.println("");
 
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
 
}
