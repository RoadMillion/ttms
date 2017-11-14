package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.system.entity.Project;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 下午2:37:31
* @desciption 业务接口实现对象（负责Project对象的业务处理）
* 1)业务数据的验证
* 2)事务的处理
* 3)日志的处理
* 4)缓存的处理
* 5)权限的处理
*/
public interface ProjectService {
	List<Project> findObjects();
	Map<String,Object> findPageObjects(String name,Integer valid,Integer pageCurrent);
	int getRowCount(String name,Integer valid);
}
