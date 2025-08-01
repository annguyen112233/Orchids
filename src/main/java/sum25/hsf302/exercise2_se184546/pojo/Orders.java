package sum25.hsf302.exercise2_se184546.pojo;

import jakarta.persistence.*;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Accounts accountId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @Column(name = "total_amount")
    private String totalAmount;
    // Trong Orders
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order_Details> orderDetails = new ArrayList<>();



    public Orders() {
    }

    public Orders(int orderId, Accounts accountId, LocalDateTime orderDate, OrderStatus orderStatus, String totalAmount, List<Order_Details> orderDetails) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Order_Details> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order_Details> orderDetails) {
        this.orderDetails = orderDetails;
    }


}