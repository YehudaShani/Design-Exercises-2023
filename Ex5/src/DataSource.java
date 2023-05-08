import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class DataSource {

    public static List<Customer> allCustomers;
    public static List<Order> allOrders;
    public static List<Product> allProducts;
    public static List<OrderProduct> allOrderProducts;
    // Update this path according to your data files location
    public static String basePath = "C:\\Users\\David Ohhana\\Desktop\\College\\OO design and programming\\Design-Exercises-2023\\Ex5\\src\\data_files\\".replace('\\','/');
    //public static String basePath ="";
    public static String customersPath = basePath + "customers.txt";
    public static String ordersPath = basePath + "orders.txt";
    public static String productsPath = basePath + "products.txt";
    public static String orderProductPath = basePath + "orderProduct.txt";

    static {
        try {
            allCustomers = readCustomersfromFile();
            allOrders = readOrdersfromFile();
            allProducts = readProductsfromFile();
            allOrderProducts = readOrderProductsfromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomersfromFile() throws IOException {
        Stream<Customer> customer = Files.
                readString(Path.of(customersPath))
                .lines()
                .map(line -> new Customer(line));
        return customer.collect(toList());
    }

    public static List<Order> readOrdersfromFile() throws IOException {
        Stream<Order> order = Files.
                lines(Path.of(ordersPath))
                .map(line -> new Order(line));

        return order.toList();
    }

    public static List<Product> readProductsfromFile() throws IOException {
        Stream<Product> productStream = Files.
                lines(Path.of(productsPath))
                .map(line ->  new Product(line));
        return productStream.toList();
    }

    public static List<OrderProduct> readOrderProductsfromFile() throws IOException {
        Stream<OrderProduct> orderProductStream = Files.
                lines(Path.of(orderProductPath))
                .map(line -> new OrderProduct(line));
        return orderProductStream.toList();
    }
}


