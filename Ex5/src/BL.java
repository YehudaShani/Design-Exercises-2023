import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class BL implements IBL {
    @Override
    public Product getProductById(long productId) {

        return DataSource.allProducts.stream().filter(p->p.getProductId()==productId).findFirst().get();
    }

    @Override
    public Order getOrderById(long orderId) {
        return DataSource.allOrders.stream().filter(p->p.getOrderId()==orderId).findFirst().get();

    }

    @Override
    public Customer getCustomerById(long customerId) {
        return DataSource.allCustomers.stream().filter(p->p.getId()==customerId).findFirst().get();
    }


    @Override
    public List<Product> getProducts(ProductCategory cat, double price) {
        return DataSource.allProducts.stream()
                .filter(p->p.getCategory().equals(cat) && p.getPrice()<=price)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .toList();
    }

    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                .filter(c->c.getTier()==3 && getCustomerOrders(c.getId()).size()>10)
                .sorted(Comparator.comparingDouble(Customer::getId).reversed())
                .toList();

    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders
                .stream()
                .filter(o->o.getCustomrId()==customerId)
                .sorted(Comparator.comparingDouble(Order::getOrderId).reversed())
                .toList();

    }

    @Override
    public long numberOfProductInOrder(long orderId) {
        return  DataSource.allOrderProducts.stream()
                .filter(o->o.getOrderId()==orderId)
                .count();
    }

    @Override
    public List<Product> getPopularOrderedProduct(int orderedtimes) {

        Map<Long,Integer> countOrder=
               DataSource.allOrderProducts
               .stream()
               .collect(groupingBy(OrderProduct::getProductId,summingInt(OrderProduct::getQuantity)));

        return countOrder.entrySet()
                .stream().filter(x->x.getValue()>=orderedtimes)
                .sorted(comparingByValue(reverseOrder()))
                .limit(10)
                .map(x->getProductById(x.getKey()))
                .toList();
    }



    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        //To do
        return null;
    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        //To do
        return null;
    }

    @Override
    public Product getMaxOrderedProduct() {
        //To do
        return null;

    }
    @Override
    public double sumOfOrder(long orderID) {
        //To do
        return 0;
    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        //To do
        return null;
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        //To do
        return null;

    }

}
