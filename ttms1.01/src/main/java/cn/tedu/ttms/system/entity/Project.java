package cn.tedu.ttms.system.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
*  缓存中对象落地（持久化，保存对象的状态），将内存中的缓冲的对象的状态保存在本地文件，如redis，memechce，writeObejct()
*  JMI调用--跨JVM调用,
*  3)序列化的版本id
*  4)序列化时安全的
*/
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530204558619796625L;
	private Integer id = 20;
	private String name="da";
	private transient String code = "password";
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
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("obj.txt")));
		Project project = new Project();
		oos.writeObject(project);
		Object obj = new ObjectInputStream(new FileInputStream(new File("obj.txt"))).readObject();
		System.out.println(obj);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", code=" + code + ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", valid=" + valid + ", note=" + note + ", createTime=" + createTime + ", modifiedTime="
				+ modifiedTime + ", createdUser=" + createdUser + "]";
	}
	
}
