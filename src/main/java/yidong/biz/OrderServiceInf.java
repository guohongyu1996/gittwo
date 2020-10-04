package yidong.biz;

import yidong.vo.Order;
import yidong.vo.PagePara;
import yidong.vo.user.OrderItem;

import java.util.List;

public interface OrderServiceInf {
    public void insertOrder(Order order);
    public List<OrderItem> selectOrderItems(Order order);

    public Integer selectAllStatusCount(Order order);

    public List<Order> selectAllStatusOrder(Order order, PagePara pp);

    public Order selectOneOrder(Order o);

    public void deleteOrder(Order order);

    public void updateFaHuo(Order o);
}
