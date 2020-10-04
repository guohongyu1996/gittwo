package yidong.vo.user;

public class OrderItem {

	
	private Integer orderitemid;//ID
	private Integer quantity;//数量
	private Double subtotal;//金额小计
	private Integer bid;//图书ID
	private String bname;//图书名称
	private Double currprice;//当前价
	private byte[] image_B;//小图
	private String oid;//订单ID
	public Integer getOrderitemid() {
		return orderitemid;
	}
	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Double getCurrprice() {
		return currprice;
	}
	public void setCurrprice(Double currprice) {
		this.currprice = currprice;
	}

	public byte[] getImage_B() {
		return image_B;
	}

	public void setImage_B(byte[] image_B) {
		this.image_B = image_B;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	
	
}
