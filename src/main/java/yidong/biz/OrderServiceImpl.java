package yidong.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yidong.dao.OrderDaoInf;
import yidong.vo.Order;
import yidong.vo.PagePara;
import yidong.vo.user.OrderItem;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInf{
    @Autowired
    private OrderDaoInf orderDaoInf;
    @Override
    public void insertOrder(Order order) {
        orderDaoInf.insertOrder(order);
    }

    @Override
    public List<OrderItem> selectOrderItems(Order order) {
        return orderDaoInf.selectOrderItems(order);
    }

    @Override
    public Integer selectAllStatusCount(Order order) {
        return orderDaoInf.selectAllStatusCount(order);
    }

    @Override
    public List<Order> selectAllStatusOrder(Order order, PagePara pp) {
        return orderDaoInf.selectAllStatusOrder(order,pp);
    }

    @Override
    public Order selectOneOrder(Order o) {
        return orderDaoInf.selectOneOrder(o);
    }

    @Override
    public void deleteOrder(Order order) {
         orderDaoInf.deleteOrder(order);
    }

    @Override
    public void updateFaHuo(Order o) {
      orderDaoInf.updateFaHuo(o);
    }
}
