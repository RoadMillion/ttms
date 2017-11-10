package cn.tedu.ttms.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 上午11:01:42
* @desciption 实体对象(持久化对象)：用于实现与表中数据的映射
* 
* 查询数据：(table:tms_projects--->List<Project>)
* 保存数据：(insertObject(Project project))
* 实体对象要求:
* 1) 实体类名不用复数
* 2) 实体类中的属性都使用对象类型
* 3) 实体类中属性名要与表中字段名一致，类型要匹配。
* 
*  添加序列化版本id
*  1)何为序列化
*  2)序列化的应用场景
*  3)序列化的版本id
*  4)序列化时安全的
*/
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530204558619796625L;
	private Integer id;
	private String name;
	private String code;
	private Date beginDate;//java.util.Date
	private Date endDate;//java.util.Date
	/***/
	private Integer valid;
	/**项目备注 */
	private String note;
	/**创建时间  */
	private Date createTime;
	/**修改时间  */
	private Date modifiedTime;
	/**创建用户   */
	private String createdUser;
}
