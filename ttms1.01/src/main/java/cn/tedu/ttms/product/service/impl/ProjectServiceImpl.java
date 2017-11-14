package cn.tedu.ttms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.exception.ServiceException;
import cn.tedu.ttms.common.web.PageObject;
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
	public List<Project> findObjects() {
		// TODO Auto-generated method stub
		return projectDao.findObjects();
	}
	@Override
	public Map<String,Object> findPageObjects(Integer pageCurrent) {
		// TODO Auto-generated method stub
		if(pageCurrent == null || pageCurrent < 1) {
			throw new ServiceException("参数值无效,pageCurrent" + pageCurrent);
		}
		int pageSize = 2;
		int startIndex = pageSize * (pageCurrent - 1) ;
		List<Project> list = projectDao.findPageObjects(startIndex, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		PageObject page = new PageObject();
/*		page.setPageCurrent(pageCurrent);
		page.setPageSize(pageSize);
		page.setStartIndex(startIndex);
		int rowCount = projectDao.getRowCount();
		if(rowCount % pageSize != 0) {
			rowCount ++;
		}
		page.setRowCount(projectDao.getRowCount());*/
		page.setRowCount(projectDao.getRowCount());
		page.setPageSize(pageSize);
		page.setPageCurrent(pageCurrent);
		page.setStartIndex(startIndex);
		map.put("pageObject", page);
		return map;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return projectDao.getRowCount();
	}

}
