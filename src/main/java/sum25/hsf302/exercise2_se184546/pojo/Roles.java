package sum25.hsf302.exercise2_se184546.pojo;

import jakarta.persistence.*;
import sum25.hsf302.exercise2_se184546.file_enum.RoleType;

import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private RoleType roleName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private List<Accounts> accounts;

    public Roles() {
    }

    public Roles(int roleId, RoleType roleName, List<Accounts> accounts) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.accounts = accounts;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleType getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleType roleName) {
        this.roleName = roleName;
    }
}
