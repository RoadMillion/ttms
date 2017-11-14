package cn.tedu.ttms.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.ttms.system.entity.Project;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 下午2:15:50
* @desciption 持久层对象：负责数据的持久化操作
*/
public interface ProjectDao {
	/**
	 * 从数据查询表中所有数据（项目信息）
	 * 1）一行记录封装为一个Project对象
	 * 2)多行记录对应的多个Project对象再封装到list集合中
	 * @return List<Project>
	 */
	List<Project> findObjects();
	
	List<Project> findPageObjects(@Param("startIndex")int startIndex, @Param("pageSize")int PageSize);
	int getRowCount();
}
