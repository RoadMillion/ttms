package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.product.service.ProjectService;
import cn.tedu.ttms.system.entity.Project;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 下午3:51:48
* @desciption 
*/
@RequestMapping("/project/")
@Controller
public class ProjectController {
	static int x = 1;
	static {
		x += 1;
	}
	@Autowired
	private ProjectService projectService;
	@RequestMapping("doFindObjects")
	@ResponseBody
	/**
	 *spring通过整合第三方的API，实现了JSON数据的转换，jackson
	 *spring发现方法被此注解修饰时，底层会启动第三方API将方法返回的数据转换为JSON格式的字符串
	 *例如：借助jackson（此底层会调用对象的getxxx方法获取数据）
	 *
	 *当没有返回modelandview时，会将映射名当做视图名
	 *
	*/
	public List<Project> doFindObjects(String objects){
		List<Project> list = projectService.findObjects();
		return list;
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public Map<String,Object> doFindPageObjects(@RequestParam("name")String name,
			@RequestParam("valid") Integer valid,
			@RequestParam("pageCurrent")Integer currentPage) {
		System.out.println(name);
		return  projectService.findPageObjects(name,valid,currentPage);
	}
	@RequestMapping("listUI")
	public String listUI() {
		return "product/project_list";
	}
	static {
		x += 2;
	}
}
