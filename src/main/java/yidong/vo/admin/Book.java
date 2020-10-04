package yidong.vo.admin;

import java.util.Date;

public class Book {

	private Integer bid;//	图书ID
	private String bname;//	图书名称
	private String author;//	图书作者
	private Double price;//	定价
	private Double currprice;//	当前价
	private Double discount;//	折扣
	private String press;//	出版社
	private Integer edition;//	版次
	private Integer pagenum;//	页数
	private Integer wordnum;//	字数
	private Date printtime;//	印刷时间
	private Date publishtime;//出版时间
	private Integer booksize;//	开本
	private String paper;//	纸质
	private Integer cid;//	分类ID
	private byte[] image_B;//	大图
	private byte[] image_W;//	小图
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCurrprice() {
		return currprice;
	}
	public void setCurrprice(Double currprice) {
		this.currprice = currprice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Integer getPagenum() {
		return pagenum;
	}
	public void setPagenum(Integer pagenum) {
		this.pagenum = pagenum;
	}
	public Integer getWordnum() {
		return wordnum;
	}
	public void setWordnum(Integer wordnum) {
		this.wordnum = wordnum;
	}
	public Date getPrinttime() {
		return printtime;
	}
	public void setPrinttime(Date printtime) {
		this.printtime = printtime;
	}
	public Integer getBooksize() {
		return booksize;
	}
	public void setBooksize(Integer booksize) {
		this.booksize = booksize;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public byte[] getImage_B() {
		return image_B;
	}

	public void setImage_B(byte[] image_B) {
		this.image_B = image_B;
	}

	public byte[] getImage_W() {
		return image_W;
	}

	public void setImage_W(byte[] image_W) {
		this.image_W = image_W;
	}

	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	
}
