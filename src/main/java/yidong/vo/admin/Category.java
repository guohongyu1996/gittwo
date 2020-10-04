package yidong.vo.admin;

public class Category {

	private Integer cid;//自己的id
	private String cname;//图书分类名称
	private Integer idpid;//1级分类id
	private String descs;//分类说明
	private int status;//状态 0为已删除 1为可用

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public Integer getIdpid() {
		return idpid;
	}

	public void setIdpid(Integer idpid) {
		this.idpid = idpid;
	}



	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}
}
