package cn.tedu.ttms.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.ttms.product.dao.ProjectDao;
import cn.tedu.ttms.product.service.ProjectService;
import cn.tedu.ttms.system.entity.Project;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 下午2:42:03
* @desciption 实现ProjectService接口，实现方法
*/
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Override
	public List<Project> findObjects() {
		// TODO Auto-generated method stub
		return projectDao.findObjects();
	}

}
