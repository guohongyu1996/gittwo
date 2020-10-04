package yidong.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yidong.biz.OrderServiceInf;
import yidong.vo.Order;
import yidong.vo.PagePara;
import yidong.vo.user.OrderItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderControl {
    @Autowired
    private OrderServiceInf orderServiceInf;

    @RequestMapping("selectallstatusorder")
    public String selectAllStatusOrder(HttpServletRequest req){

        String page=req.getParameter("page");
        String status=req.getParameter("status");
        Order order = new Order();
        if(status==null||status.equals("")){
            order.setStatus(0);
        }else{
            order.setStatus(Integer.parseInt(status));
        }


        PagePara pp=new PagePara();
        if(page!=null){
            pp.setCurrentPageNo(Integer.parseInt(page));
        }
        Integer allcount=orderServiceInf.selectAllStatusCount(order);
        System.out.println(allcount);
        pp.setRecordAllCount(allcount);
        pp.setvalue();
        List<Order> list=orderServiceInf.selectAllStatusOrder(order,pp);
        for(int i=0;i<list.size();i++){
            List<OrderItem> items=orderServiceInf.selectOrderItems(list.get(i));
            list.get(i).setOrderItems(items);
        }
        req.setAttribute("orderlist", list);
        req.setAttribute("pp", pp);
        req.setAttribute("statu", status);

        return "adminjsps/admin/order/list";
    }
    @RequestMapping("selectadminoneorder")
    public String selectAdminOneOrder(HttpServletRequest req){
        String oid=req.getParameter("oid");
        Order o=new Order();
        o.setOid(oid);
        Order order=orderServiceInf.selectOneOrder(o);
        List<OrderItem> items=orderServiceInf.selectOrderItems(order);
        order.setOrderItems(items);
        req.setAttribute("order", order);
        return "adminjsps/admin/order/desc";
    }
    @RequestMapping("cancleorder")
    public String cancleOrder(HttpSession session, HttpServletRequest req){
        String oid=req.getParameter("oid");
        Order o=new Order();
        o.setOid(oid);
        orderServiceInf.deleteOrder(o);


        String page=req.getParameter("page");
        String status=req.getParameter("status");
        Order order = new Order();
        if(status==null||status.equals("")){
            order.setStatus(0);
        }else{
            order.setStatus(Integer.parseInt(status));
        }


        PagePara pp=new PagePara();
        if(page!=null){
            pp.setCurrentPageNo(Integer.parseInt(page));
        }
        Integer allcount=orderServiceInf.selectAllStatusCount(order);
        System.out.println(allcount);
        pp.setRecordAllCount(allcount);
        pp.setvalue();
        List<Order> list=orderServiceInf.selectAllStatusOrder(order,pp);
        for(int i=0;i<list.size();i++){
            List<OrderItem> items=orderServiceInf.selectOrderItems(list.get(i));
            list.get(i).setOrderItems(items);
        }
        req.setAttribute("orderlist", list);
        req.setAttribute("pp", pp);
        req.setAttribute("statu", status);

        return "adminjsps/admin/order/list";
    }
    @RequestMapping("fahuo")
    public String sendhuo(HttpServletRequest req){

        String oid=req.getParameter("oid");

        Order o=new Order();
        o.setOid(oid);

        orderServiceInf.updateFaHuo(o);

        String page=req.getParameter("page");
        String status=req.getParameter("status");
        Order order = new Order();
        if(status==null||status.equals("")){
            order.setStatus(0);
        }else{
            order.setStatus(Integer.parseInt(status));
        }


        PagePara pp=new PagePara();
        if(page!=null){
            pp.setCurrentPageNo(Integer.parseInt(page));
        }
        Integer allcount=orderServiceInf.selectAllStatusCount(order);
        System.out.println(allcount);
        pp.setRecordAllCount(allcount);
        pp.setvalue();
        List<Order> list=orderServiceInf.selectAllStatusOrder(order,pp);
        for(int i=0;i<list.size();i++){
            List<OrderItem> items=orderServiceInf.selectOrderItems(list.get(i));
            list.get(i).setOrderItems(items);
        }
        req.setAttribute("orderlist", list);
        req.setAttribute("pp", pp);
        req.setAttribute("statu", status);

        return "adminjsps/admin/order/list";
    }

}
