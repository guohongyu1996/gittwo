package yidong.dao;

import org.apache.ibatis.annotations.Param;
import yidong.vo.Order;
import yidong.vo.PagePara;
import yidong.vo.user.OrderItem;
import yidong.vo.user.User;

import java.util.List;

public interface OrderDaoInf {

    public void insertOrder(Order order);
    public void insetOrderItem(OrderItem orderitem);
    public List<Order> selectMyOrder(@Param("user") User user, @Param("pp") PagePara pp);
    public Integer selectMyOrderAllCount(User user);
    public List<OrderItem> selectOrderItems(Order order);
    public Order selectOneOrder(Order o);

    public Integer selectAllStatusCount(Order order);

    public List<Order> selectAllStatusOrder(@Param("order")Order order, @Param("pp")PagePara pp);

    public void deleteOrder(Order order);

    public void updatePayOrder(Order order);

    public void updateFaHuo(Order o);

    public void updateShouHuo(Order o);
}
