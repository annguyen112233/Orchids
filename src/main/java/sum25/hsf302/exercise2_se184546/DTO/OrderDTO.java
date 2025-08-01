package sum25.hsf302.exercise2_se184546.DTO;

import lombok.Data;
import sum25.hsf302.exercise2_se184546.file_enum.OrderStatus;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.pojo.Orders;

import java.time.format.DateTimeFormatter;

@Data
public class OrderDTO {
    private int orderId;
    private String orderDateFormatted;
    private OrderStatus orderStatus;
    private String totalAmount;

    // Thêm các trường hiển thị
    private String accountName;
    private String orchidName;
    private int quantity; // Số lượng từ Order_Detail


    // ✅ Trường mới cho trạng thái tiếng Việt
    private String orderStatusVietnamese;

    public OrderDTO(Orders order) {
        this.orderId = order.getOrderId();
        this.orderDateFormatted = order.getOrderDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.orderStatus = order.getOrderStatus();
        this.totalAmount = order.getTotalAmount();

        // ✅ Gán trạng thái tiếng Việt
        this.orderStatusVietnamese = order.getOrderStatus().getVietnamese();

        if (order.getAccountId() != null) {
            this.accountName = order.getAccountId().getAccountName();
        } else {
            this.accountName = "Không rõ";
        }

        if (order.getOrderDetails() != null && !order.getOrderDetails().isEmpty()) {
            Orchids orchids = order.getOrderDetails().get(0).getOrchidId();
            if (orchids != null) {
                this.orchidName = orchids.getOrchidName();
            } else {
                this.orchidName = "Không rõ";
            }
        } else {
            this.orchidName = "Không rõ";
        }
        if (order.getOrderDetails() != null && !order.getOrderDetails().isEmpty()) {
            var orderDetail = order.getOrderDetails().get(0); // Lấy phần tử đầu tiên
            Orchids orchids = orderDetail.getOrchidId();

            if (orchids != null) {
                this.orchidName = orchids.getOrchidName();
            } else {
                this.orchidName = "Không rõ";
            }

            this.quantity = orderDetail.getQuantity(); // 👉 Thêm dòng này
        } else {
            this.orchidName = "Không rõ";
            this.quantity = 0;
        }

    }


}
