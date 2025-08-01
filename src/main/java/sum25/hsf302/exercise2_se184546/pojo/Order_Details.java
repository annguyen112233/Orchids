package sum25.hsf302.exercise2_se184546.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class Order_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int orderDetailsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orchid_id", referencedColumnName = "orchid_id")
    private Orchids orchidId;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders orderId;

    public Order_Details() {
    }

    public Order_Details(int orderDetailsId, Orchids orchidId, double price, int quantity, Orders orderId) {
        this.orderDetailsId = orderDetailsId;
        this.orchidId = orchidId;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Orchids getOrchidId() {
        return orchidId;
    }

    public void setOrchidId(Orchids orchidId) {
        this.orchidId = orchidId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }


}
