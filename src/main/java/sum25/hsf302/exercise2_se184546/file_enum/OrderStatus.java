package sum25.hsf302.exercise2_se184546.file_enum;

import java.util.concurrent.CancellationException;

public enum OrderStatus {
    CONFIRM,
    PENDING,
    PROCESSING,
    CANCELLED,
    DELIVERED;

    public String getVietnamese() {
        return switch (this) {
            case CONFIRM -> "Đã xác nhận";
            case PENDING -> "Đang chờ";
            case PROCESSING -> "Đang xử lý";
            case DELIVERED -> "Đã giao";
            case CANCELLED -> "Đã hủy";
        };
    }
}
