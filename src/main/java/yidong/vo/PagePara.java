package yidong.vo;

public class PagePara {

	private int currentPageNo=1;         		//当前要显示的页码
	private final int onePageCount=2;       	//每页要显示的记录数
    private int recordAllCount;        	    	//记录总数	ֵ
	private int pageAllCount;          			//共有多少页     		
    private int iStart;							//起始条数
    private int iEnd;							//结束条数
    
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getRecordAllCount() {
		return recordAllCount;
	}
	public void setRecordAllCount(int recordAllCount) {
		this.recordAllCount = recordAllCount;
	}
	public int getPageAllCount() {
		return pageAllCount;
	}
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}
	public int getiStart() {
		return iStart;
	}
	public void setiStart(int iStart) {
		this.iStart = iStart;
	}
	public int getiEnd() {
		return iEnd;
	}
	public void setiEnd(int iEnd) {
		this.iEnd = iEnd;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
    
    public void setvalue(){
    	if(currentPageNo<1){
    		currentPageNo=1;
    	}
    	pageAllCount=(recordAllCount - 1) / onePageCount + 1;
    	if(currentPageNo>pageAllCount){
    		currentPageNo=pageAllCount;
    	}
    	iStart=(currentPageNo - 1) * onePageCount + 1;
    	iEnd=iStart+onePageCount;
    }

}
