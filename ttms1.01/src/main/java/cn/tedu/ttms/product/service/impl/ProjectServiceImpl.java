package cn.tedu.ttms.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.druid.util.StringUtils;

import cn.tedu.ttms.common.exception.ServiceException;
import cn.tedu.ttms.common.util.StringUtil;
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
	//声明TransactionTemplate
	private final TransactionTemplate transactionTemplate;
	//初始化TransactionTemplate
	public ProjectServiceImpl(PlatformTransactionManager tm){
		this.transactionTemplate = new TransactionTemplate(tm);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object testTransaction() {
		return transactionTemplate.execute(new TransactionCallback() {

			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
					//然后调用持久层处理方法。
					//下面返回处理的结果。
				return null;
			}
			
		});
	}
	public List<Project> findObjects() {
		// TODO Auto-generated method stub
		return projectDao.findObjects();
	}
	@Override
	public Map<String,Object> findPageObjects(String name, Integer valid, Integer pageCurrent) {
		// TODO Auto-generated method stub
		if(pageCurrent == null || pageCurrent < 1) {
			throw new ServiceException("参数值无效,pageCurrent" + pageCurrent);
		}
		int pageSize = 2;
		String order="createdTime";
		int startIndex = pageSize * (pageCurrent - 1) ;
		List<Project> list = projectDao.findPageObjects(name,valid,startIndex, pageSize,order);
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
		page.setRowCount(projectDao.getRowCount(name,valid));
		page.setPageSize(pageSize);
		page.setPageCurrent(pageCurrent);
		page.setStartIndex(startIndex);
		map.put("pageObject", page);
		return map;
	}
	@Override
	public int getRowCount(String name,Integer valid) {
		// TODO Auto-generated method stub
		return projectDao.getRowCount(name,valid);
	}
	@Override
	/**
	 * 更改项目的状态，启用和禁用
	 */
	public void validById(String checkIds, Integer valid) {
		// TODO Auto-generated method stub
		//1.验证业务数据的有效性
		//2.执行更新操作
		//3.验证更新结果
		if(org.springframework.util.StringUtils.isEmpty(checkIds)) {
			throw new ServiceException("请先选择");
		}
		if(valid!=0 && valid !=1) {
			throw new ServiceException("启用或禁用的状态值不正确");
		}
		String[] ids = checkIds.split(",");
		int i = projectDao.validById(ids, valid);
		if(i<=0) {
			throw new ServiceException("更新失败：" + i);
		}
	}

}
