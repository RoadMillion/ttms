package beans.product;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.product.service.impl.ProjectServiceImpl;
import cn.tedu.ttms.system.entity.Project;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月10日 下午2:57:55
* @desciption 测试类
*/

public class TestProjectService {
	AbstractApplicationContext ctx ;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
	}
//	@Test
	/**
	 * 获取业务对象
	 * 调用业务对象方法
	 */
	public void testFindObjects() {
		System.out.println("testFindObjects");
		ProjectServiceImpl dao = ctx.getBean(ProjectServiceImpl.class);
		System.out.println(dao);
		System.out.println("getProjectService");
		List<Project> list = dao.findObjects();
		System.out.println("get the list");
		/**
		 * 断言list不为null
		 */
		Assert.assertNotNull(list);
		/**
		 * 断言实际值与期望值相同
		 */
		Assert.assertEquals(3, list.size());
		System.out.println(list.size());
		Iterator<Project> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	@Test
	public void te() {
		ProjectServiceImpl service = ctx.getBean(ProjectServiceImpl.class);
		Map<String,Object> map = service.findPageObjects(2);
		Assert.assertNotNull(map);
		System.out.println(((List<Project>)map.get("list")).size());
		PageObject page = (PageObject)map.get("pageObject");
		System.out.println(page + "," + page.getPageCount());
		
	}
	@After
	public void destroy() {
		ctx.close();
	}
	
}
