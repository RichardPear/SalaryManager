package com.lch.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;    
import org.springframework.context.annotation.Scope;

import com.lch.entity.NotiUser;
import com.lch.entity.User;
import com.lch.form.DataForm;
import com.lch.service.INotificationService;
import com.lch.service.IUserService;
import com.lch.util.DateJsonValueProcessor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.processors.JsDateJsonValueProcessor;
import net.sf.json.processors.JsonValueProcessor; 
@Scope("prototype")//支持多例
@Namespace("/user")//当前Action所在的命名空间
@ParentPackage("json-default")//继承的父包
@SuppressWarnings("serial")
public class NotificationAction extends ActionSupport{
	@Resource(name="NotificationService")
	private INotificationService notificationService;
	private String json;
	@Action(value="/getNotis",
			results={
					@Result(type="json",name="json"),
				}
	) 
	public String getNotis(){
		ActionContext context=ActionContext.getContext();
		int userId = (Integer) context.getSession().get("userId");
		List<NotiUser> list = notificationService.getNotificationsByUserId(userId);
		DataForm form = new DataForm();
		form.setData(list);
		form.setStatus(0);
		form.setMessage("");
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"users","positions","notiUsers","notifications"});  //此处是亮点，只要将所需忽略字段加到数组中即可，在上述案例中，所要忽略的是“libs”，那么将其添到数组中即可，在实际测试中，我发现在所返回数组中，存在大量无用属性，如“multipartRequestHandler”，“servletWrapper”，那么也可以将这两个加到忽略数组中.
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new DateJsonValueProcessor());  
		this.setJson(JSONArray.fromObject(form,jsonConfig).toString());
		System.out.println(json);
		return "json";
	}
	@Action(value="/getMyPubNotis",
			results={
					@Result(type="json",name="json"),
				}
	) 
	public String getMyPubNotis(){
		ActionContext context=ActionContext.getContext();
		int userId = (Integer) context.getSession().get("userId");
		List<NotiUser> list = notificationService.getMyPubNotis(userId);
		JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
		jsonConfig.setExcludes(new String[]{"users","positions","notiUsers","notifications"});  //此处是亮点，只要将所需忽略字段加到数组中即可，在上述案例中，所要忽略的是“libs”，那么将其添到数组中即可，在实际测试中，我发现在所返回数组中，存在大量无用属性，如“multipartRequestHandler”，“servletWrapper”，那么也可以将这两个加到忽略数组中.
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new DateJsonValueProcessor());  
		this.setJson(JSONArray.fromObject(list,jsonConfig).toString());
		System.out.println(json);
		return "json";
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	
	
}
