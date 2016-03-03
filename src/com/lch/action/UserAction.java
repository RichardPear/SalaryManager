package com.lch.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;    
import org.springframework.context.annotation.Scope;
import com.lch.entity.User;
import com.lch.form.DataForm;
import com.lch.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")//支持多例
@Namespace("/user")//当前Action所在的命名空间
@ParentPackage("json-default")//继承的父包
@SuppressWarnings("serial")
@Results(@Result(name="input",location="/login.jsp",type="redirect"))
public class UserAction extends ActionSupport{
	@Resource(name="UserService")
	private IUserService userService;
	private String json;
	@Action(value="/login",
			results={
					@Result(type="json",name="json"),
				}
	) 
	public String login(){
		JSONObject jsonObject = JSONObject.fromObject(json);
		User user = (User)JSONObject.toBean(jsonObject, User.class);
		User u = userService.getUserByUsername(user.getUsername());
		DataForm form = new DataForm();
		if(u == null){
			form.setData(null);
			form.setStatus(1);//1表示要显示message
			form.setMessage("用户不存在！");
			this.setJson(JSONObject.fromObject(form).toString());
			return "json";
		}
		if(u.getPassword().equals(user.getPassword())){
			form.setData(null);
			form.setStatus(0);
			form.setMessage("登录成功！");
			ActionContext context=ActionContext.getContext();
			context.getSession().put("user", u.getUsername());
			context.getSession().put("userId", u.getId());
			this.setJson(JSONObject.fromObject(form).toString());
			return "json";
		}else{
			form.setData(null);
			form.setStatus(1);
			form.setMessage("密码错误！");
			this.setJson(JSONObject.fromObject(form).toString());
			return "json";
		}
	}
	@Action(value="/logout",
			results={
					@Result(name="success",location="/login.jsp",type="redirect"),
				}
	)
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		System.out.println("logout");
		return "success";
	}
	@Action(value="/user/isUnique",
			results={
					@Result(type="json",name="json"),
				}
	)
	public String isUnique(){
		String username = json;
		User u =  userService.getUserByUsername(username);
		if(u != null){
			this.setJson("false");
		}else{
			this.setJson("true");
		}
		return "json";
	}
	/*public void validate() {
		JSONObject jsonObject = JSONObject.fromObject(json);
		User user = (User)JSONObject.toBean(jsonObject, User.class);
		String username = user.getUsername();
		String password = user.getPassword();
		if (username == null || username.length() == 0) {
			super.addActionError("用户名不能为空!");
		}
		if (password == null || password.length() == 0) {
			super.addActionError("密码不能为空!");
		}
	}*/
	@Action(value="/add",
			results={
					@Result(type="json",name="json")
				}
	) 
	public String addUser(){
		JSONObject jsonObject = JSONObject.fromObject(json);
		User user = (User)JSONObject.toBean(jsonObject, User.class);
		userService.addUser(user);
		DataForm form = new DataForm();
		form.setData(null);
		form.setStatus(1);
		form.setMessage("添加成功！");
		this.setJson(JSONObject.fromObject(form).toString());
		return "json";
	}
	@Action(value="/isLogin",
			results={
					@Result(type="json",name="json",params={"excludeProperties","json"}),
					@Result(name="login",location="/login.jsp",type="redirect",params={"excludeProperties","json"}),
				}
	) 
	public String isLogin(){
		ActionContext context=ActionContext.getContext();
		String str = (String)context.getSession().get("user");
		if(str == null || str == ""){
			return "login";
		}
		return "json";
	}
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	
}
