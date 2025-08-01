package sum25.hsf302.exercise2_se184546.file_enum;

import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN("Quản trị viên"),
    CUSTOMER("Khách hàng");

    private final String label;

    RoleType(String label) {
        this.label = label;
    }

}