package easyUIDemo.bean;

public class Page {

	private int pageindex;
	private int pageSize;
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int pageindex, int pageSize) {
		super();
		this.pageindex = pageindex;
		this.pageSize = pageSize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
