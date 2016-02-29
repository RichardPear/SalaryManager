package com.lch.action;
import java.util.List;
import javax.annotation.Resource;
import net.sf.json.JSONArray;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;    
import org.springframework.context.annotation.Scope;
import com.lch.entity.Department;
import com.lch.service.impl.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")//支持多例
@Namespace("/department")//当前Action所在的命名空间
@ParentPackage("json-default")//继承的父包
@SuppressWarnings("serial")
@Results(@Result(name="input",location="/login.html",type="redirect"))
public class DepartmentAction extends ActionSupport{
	@Resource(name="DepartmentService")
	private DepartmentService departmentService;
	
	private String json;
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Action(value="/department/list",
			results={
					@Result(type="json",name="json")
				}
	)
	public String list(){
		List<Department> list = departmentService.listDepartment();
		this.setJson(JSONArray.fromObject(list).toString());
		return "json";
	}
	
	
}
