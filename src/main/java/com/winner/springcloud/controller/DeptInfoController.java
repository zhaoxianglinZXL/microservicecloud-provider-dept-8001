package com.winner.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winner.springcloud.model.DeptInfo;
import com.winner.springcloud.service.IDeptInfoService;

/**
 * @author ZXL
 * @描述 部门操作相关controller
 */

@Controller
@RequestMapping("/dept")
public class DeptInfoController {

	@Autowired
	@Qualifier("deptInfoService")
	private IDeptInfoService ideptInfoService;
	
	//添加
	@RequestMapping(value = "/addDept",method = RequestMethod.POST)
	@ResponseBody
	public boolean addDept(DeptInfo dept){
		try {
			return ideptInfoService.addDept(dept);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	//根据id查询一条部门信息
	@RequestMapping(value="/queryDeptById",method = RequestMethod.GET)
	@ResponseBody
	public DeptInfo queryDeptById(int id){
		return ideptInfoService.queryDeptById(id);
	}

	//查询全部部门信息
	@RequestMapping(value="/queryAll",method = RequestMethod.GET)
	@ResponseBody
	public List<DeptInfo> queryAll(){
		System.out.println("进入了");
		return ideptInfoService.queryAll();
	}
}
