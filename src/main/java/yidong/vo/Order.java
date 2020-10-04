package yidong.vo;

import yidong.vo.user.OrderItem;

import java.util.Date;
import java.util.List;


public class Order {

	private String oid;//订单ID
	private Date ordertime;//下单时间
	private Double total;//合计金额
	private Integer status;//订单状态 1 未付款、2 未发货、3 未收货、4 交易成功、5 已取消
	private String address;//收货地址
	private Integer userid;//会员id
	
	private List<OrderItem> orderItems;//存储订单条目
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
}
