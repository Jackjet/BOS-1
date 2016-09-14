package cn.tf.bos.web.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import cn.tf.bos.page.PageRequestBean;
import cn.tf.bos.service.bc.StaffService;
import cn.tf.bos.service.bc.StandardService;
import cn.tf.bos.service.user.UserService;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction  extends ActionSupport  {
	@Resource(name="userService")
	protected UserService userService;

	
	@Resource(name="standardService")
	protected StandardService standardService;
	
	
	@Resource(name="staffService")
	protected StaffService staffService;
	
	
	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	// 封装PageRequestBean
		public PageRequestBean initPageRequestBean(DetachedCriteria detachedCriteria) {
			// 将分页查询参数 ，封装 PageRequestBean 对象中
			PageRequestBean pageRequestBean = new PageRequestBean();
			pageRequestBean.setPage(page);
			pageRequestBean.setRows(rows);

			pageRequestBean.setDetachedCriteria(detachedCriteria);
			return pageRequestBean;
		}
	
	
}