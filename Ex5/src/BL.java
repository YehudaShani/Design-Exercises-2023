/*
* David Ohhana 316003417
* Yehuda Shani 23794253
*
*
*
* */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByKey;
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
                .sorted(Comparator.comparingDouble(Product::getProductId))
                .collect(toList());
    }

    @Override
    public List<Customer> popularCustomers() {
        return DataSource.allCustomers.stream()
                .filter(c->c.getTier()==3 && getCustomerOrders(c.getId()).size()>10)
                .sorted(Comparator.comparingDouble(Customer::getId))
                .collect(toList());

    }

    @Override
    public List<Order> getCustomerOrders(long customerId) {
        return DataSource.allOrders
                .stream()
                .filter(o->o.getCustomrId()==customerId)
                .sorted(Comparator.comparingDouble(Order::getOrderId))
                .collect(toList());

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
                .sorted(comparingByKey())
                .limit(10)
                .map(x->getProductById(x.getKey()))
                .collect(toList());
    }



    @Override
    public List<Product> getOrderProducts(long orderId)
    {
        return DataSource.allOrderProducts
                .stream()
                .filter(o->o.getOrderId()==orderId)
                .map(o->getProductById(o.getProductId()))
                .sorted(Comparator.comparingLong(Product::getProductId))
                .collect(toList());

    }

    @Override
    public List<Customer> getCustomersWhoOrderedProduct(long productId) {
        return DataSource.allOrderProducts
                .stream()
                .filter(o->o.getProductId()==productId)
                .map(o->getOrderById(o.getOrderId()))
                .map(c->getCustomerById(c.getCustomrId()))
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(toList());
    }

    @Override
    public Product getMaxOrderedProduct() {
        return   DataSource.allOrderProducts
                .stream()
                .collect(groupingBy(OrderProduct::getProductId,counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(x->getProductById(x.getKey()))
                .orElse(null);



    }
    @Override
    public double sumOfOrder(long orderID) {
        return  DataSource.allOrderProducts
                .stream()
                .filter(o->o.getOrderId()==orderID)
                .mapToDouble(o->getProductById(o.getProductId()).getPrice()*o.getQuantity())
                .sum();

    }

    @Override
    public List<Order> getExpensiveOrders(double price) {
        return DataSource.allOrderProducts
                .stream()
                .filter(o->sumOfOrder(o.getOrderId())>price)
                //.peek(System.out::println)
                .map(o->getOrderById(o.getOrderId()))
                .distinct()
                .sorted(Comparator.comparingLong(Order::getOrderId))
                .collect(toList());
    }

    @Override
    public List<Customer> ThreeTierCustomerWithMaxOrders() {
        return Objects.requireNonNull(DataSource.allCustomers.stream()
                        .filter(c -> c.getTier() == 3)
                        .collect(toMap(identity(), c -> getCustomerOrders(c.getId()).size()))
                        .entrySet()
                        .stream()
                        .collect(groupingBy(Map.Entry::getValue))
                        .entrySet()
                        .stream()
                        .max(comparingByKey())
                        .orElse(null))
                .getValue()
                .stream()
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingLong(Customer::getId))
                .collect(toList());

    }

}
