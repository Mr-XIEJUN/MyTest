package com.empsystem.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.empsystem.entity.TbEmp;
import com.empsystem.service.IDeptService;
import com.empsystem.service.IEmpService;
import com.opensymphony.xwork2.ActionContext;

@Controller("empAction")
@Scope("prototype")
public class EmpAction {
	
	private TbEmp emp;
	
	@Resource(name="deptService")
	private IDeptService deptService;
	@Resource(name="empService")
	private IEmpService empService;
	
	private int message;			/*状态*/
	
	/**
	 * 查询出部门信息，再去到添加添加员工页面
	 */
	public String toAddEmp(){
		List deptList=deptService.findDeptList();			/*查询出部门信息*/
		ActionContext.getContext().put("deptList", deptList);
		return "addEmp";
	}
	
	/**
	 * 添加员工
	 */
	public String addEmp(){
		if(empService.addEmp(emp)){
			message = 1;
		}else{
			message = 0;
		}
		return "toAddEmp";
	}
	
	/**
	 * 查询所有员工信息
	 */
	public String findEmps(){
		List empList=empService.findEmpList();			/*查询所有员工信息*/
		ActionContext.getContext().put("empList", empList);
		return "empList";
	}

	public TbEmp getEmp() {
		return emp;
	}

	public void setEmp(TbEmp emp) {
		this.emp = emp;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}
	
}







