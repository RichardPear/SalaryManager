package com.lch.action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;

import com.lch.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Namespace("/test")
// 当前Action所在的命名空间
@ParentPackage("json-default")
// 继承的父包
@SuppressWarnings("serial")
public class TestJson extends ActionSupport   {
	private String json;
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	@Action(value = "/test/test", results = { @Result(name ="json",type="json",params={"excludeProperties","json.username"})})
	public String cate() {
		System.out.println(json);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		User u = new User();
		u.setId(998);
		u.setUsername("998");
		u.setPassword("9865567");
		System.out.println(jsonObject.fromObject(u).toString());
		System.out.println(jsonArray.fromObject(u).toString());
		//this.setJson(jsonObject.fromObject(u).toString());
		jsonObject = JSONObject.fromObject(json);
	    User stu = (User) JSONObject.toBean(jsonObject, User.class);
	    System.out.println(stu.getPassword());
	    System.out.println(stu.getId());
	    System.out.println(stu.getUsername());
		return "json";
	}



}
