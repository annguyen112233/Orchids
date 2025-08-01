package sum25.hsf302.exercise2_se184546;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sum25.hsf302.exercise2_se184546.file_enum.RoleType;
import sum25.hsf302.exercise2_se184546.pojo.Accounts;
import sum25.hsf302.exercise2_se184546.pojo.Categories;
import sum25.hsf302.exercise2_se184546.pojo.Orchids;
import sum25.hsf302.exercise2_se184546.pojo.Roles;
import sum25.hsf302.exercise2_se184546.service.AccountService;
import sum25.hsf302.exercise2_se184546.service.CategoryService;
import sum25.hsf302.exercise2_se184546.service.OrchidService;
import sum25.hsf302.exercise2_se184546.service.RoleService;

@SpringBootApplication
public class Hsf302Exercise2Se184546Application implements CommandLineRunner {
    @Autowired
    private RoleService roleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrchidService orchidService;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(Hsf302Exercise2Se184546Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (accountService.countAccounts() == 0) {
            Roles adminRole = new Roles();
            adminRole.setRoleName(RoleType.ADMIN);
            roleService.save(adminRole);

            Roles userRole = new Roles();
            userRole.setRoleName(RoleType.CUSTOMER);
            roleService.save(userRole);

            Categories orchidCategory = new Categories();
            orchidCategory.setCategoryName("Hoa Lan Tim");
            categoryService.save(orchidCategory);

            Categories orchidCategory2 = new Categories();
            orchidCategory2.setCategoryName("Hoa Lan Vàng");
            categoryService.save(orchidCategory2);

            Categories orchidCategory3 = new Categories();
            orchidCategory3.setCategoryName("Hoa Lan Trắng");
            categoryService.save(orchidCategory3);

            Accounts adminAccount = new Accounts();
            adminAccount.setRole(adminRole);
            adminAccount.setAccountName("admin");
            adminAccount.setEmail("admin@gmail.com");
            adminAccount.setPassword("admin123");
            accountService.save(adminAccount);

            Accounts userAccount = new Accounts();
            userAccount.setRole(userRole);
            userAccount.setAccountName("user");
            userAccount.setEmail("customer1@gmail.com");
            userAccount.setPassword("user123");
            accountService.save(userAccount);

            Orchids orchid1 = new Orchids();
            orchid1.setOrchidUrl("1.jpg");
            orchid1.setOrchidName("Lan Hồ Điệp");
            orchid1.setOrchidDescription("Hoa lan hồ điệp đẹp và quý phái");
            orchid1.setIsNatural("Nhân tạo");
            orchid1.setPrice(1500000);
            orchid1.setCategoryId(orchidCategory);
            orchidService.save(orchid1);

            Orchids orchid2 = new Orchids();
            orchid2.setOrchidUrl("2.jpg");
            orchid2.setOrchidName("Lan Trầm");
            orchid2.setOrchidDescription("Hoa lan trầm thơm ngát");
            orchid2.setIsNatural("Tự nhiên");
            orchid2.setPrice(1200000);
            orchid2.setCategoryId(orchidCategory2);
            orchidService.save(orchid2);

            Orchids orchid3 = new Orchids();
            orchid3.setOrchidUrl("3.jpg");
            orchid3.setOrchidName("Lan Ngọc Điểm");
            orchid3.setOrchidDescription("Hoa lan ngọc điểm với sắc trắng tinh khôi");
            orchid3.setIsNatural("Tự nhiên");
            orchid3.setPrice(1800000);
            orchid3.setCategoryId(orchidCategory3);
            orchidService.save(orchid3);

            Orchids orchid4 = new Orchids();
            orchid4.setOrchidUrl("4.jpg");
            orchid4.setOrchidName("Lan Vanda");
            orchid4.setOrchidDescription("Hoa lan Vanda với màu sắc rực rỡ");
            orchid4.setIsNatural("Nhân tạo");
            orchid4.setPrice(2000000);
            orchid4.setCategoryId(orchidCategory);
            orchidService.save(orchid4);

            Orchids orchid5 = new Orchids();
            orchid5.setOrchidUrl("5.jpg");
            orchid5.setOrchidName("Lan Cattleya");
            orchid5.setOrchidDescription("Hoa lan Cattleya với hương thơm ngọt ngào");
            orchid5.setIsNatural("Tự nhiên");
            orchid5.setPrice(1700000);
            orchid5.setCategoryId(orchidCategory2);
            orchidService.save(orchid5);

            Orchids orchid6 = new Orchids();
            orchid6.setOrchidUrl("6.jpg");
            orchid6.setOrchidName("Lan Dendrobium");
            orchid6.setOrchidDescription("Hoa lan Dendrobium với vẻ đẹp thanh thoát");
            orchid6.setIsNatural("Nhân tạo");
            orchid6.setPrice(1600000);
            orchid6.setCategoryId(orchidCategory3);
            orchidService.save(orchid6);

            Orchids orchid7 = new Orchids();
            orchid7.setOrchidUrl("7.jpg");
            orchid7.setOrchidName("Lan Mokara");
            orchid7.setOrchidDescription("Hoa lan Mokara với màu sắc tươi sáng");
            orchid7.setIsNatural("Tự nhiên");
            orchid7.setPrice(1400000);
            orchid7.setCategoryId(orchidCategory);
            orchidService.save(orchid7);

            Orchids orchid8 = new Orchids();
            orchid8.setOrchidUrl("8.jpg");
            orchid8.setOrchidName("Lan Phalaenopsis");
            orchid8.setOrchidDescription("Hoa lan Phalaenopsis với vẻ đẹp sang trọng");
            orchid8.setIsNatural("Nhân tạo");
            orchid8.setPrice(1900000);
            orchid8.setCategoryId(orchidCategory2);
            orchidService.save(orchid8);

            Orchids orchid9 = new Orchids();
            orchid9.setOrchidUrl("9.jpg");
            orchid9.setOrchidName("Lan Cymbidium");
            orchid9.setOrchidDescription("Hoa lan Cymbidium với màu sắc đa dạng");
            orchid9.setIsNatural("Tự nhiên");
            orchid9.setPrice(2100000);
            orchid9.setCategoryId(orchidCategory3);
            orchidService.save(orchid9);

            Orchids orchid10 = new Orchids();
            orchid10.setOrchidUrl("10.jpg");
            orchid10.setOrchidName("Lan Oncidium");
            orchid10.setOrchidDescription("Hoa lan Oncidium với vẻ đẹp độc đáo");
            orchid10.setIsNatural("Nhân tạo");
            orchid10.setPrice(1300000);
            orchid10.setCategoryId(orchidCategory);
            orchidService.save(orchid10);

            Orchids orchid11 = new Orchids();
            orchid11.setOrchidUrl("11.jpg");
            orchid11.setOrchidName("Lan Vũ Nữ");
            orchid11.setOrchidDescription("Hoa lan Vũ Nữ với vẻ đẹp dịu dàng");
            orchid11.setIsNatural("Tự nhiên");
            orchid11.setPrice(1550000);
            orchid11.setCategoryId(orchidCategory2);
            orchidService.save(orchid11);

            Orchids orchid12 = new Orchids();
            orchid12.setOrchidUrl("12.jpg");
            orchid12.setOrchidName("Lan Hồ Điệp");
            orchid12.setOrchidDescription("Hoa lan hồ điệp đỏ rực rỡ");
            orchid12.setIsNatural("Nhân tạo");
            orchid12.setPrice(1750000);
            orchid12.setCategoryId(orchidCategory3);
            orchidService.save(orchid12);

            Orchids orchid13 = new Orchids();
            orchid13.setOrchidUrl("13.jpg");
            orchid13.setOrchidName("Lan Ngọc Thạch");
            orchid13.setOrchidDescription("Hoa lan ngọc thạch với sắc xanh lục");
            orchid13.setIsNatural("Tự nhiên");
            orchid13.setPrice(1650000);
            orchid13.setCategoryId(orchidCategory);
            orchidService.save(orchid13);

            Orchids orchid14 = new Orchids();
            orchid14.setOrchidUrl("14.jpg");
            orchid14.setOrchidName("Lan Kim Điệp");
            orchid14.setOrchidDescription("Hoa lan kim điệp với màu vàng rực rỡ");
            orchid14.setIsNatural("Nhân tạo");
            orchid14.setPrice(1850000);
            orchid14.setCategoryId(orchidCategory2);
            orchidService.save(orchid14);

            Orchids orchid15 = new Orchids();
            orchid15.setOrchidUrl("15.jpg");
            orchid15.setOrchidName("Lan Hồng Vân");
            orchid15.setOrchidDescription("Hoa lan hồng vân với sắc hồng nhẹ nhàng");
            orchid15.setIsNatural("Tự nhiên");
            orchid15.setPrice(1950000);
            orchid15.setCategoryId(orchidCategory3);
            orchidService.save(orchid15);

            Orchids orchid16 = new Orchids();
            orchid16.setOrchidUrl("16.jpg");
            orchid16.setOrchidName("Lan Thanh Cổ");
            orchid16.setOrchidDescription("Hoa lan thanh cổ với vẻ đẹp cổ điển");
            orchid16.setIsNatural("Nhân tạo");
            orchid16.setPrice(2050000);
            orchid16.setCategoryId(orchidCategory);
            orchidService.save(orchid16);

            Orchids orchid17 = new Orchids();
            orchid17.setOrchidUrl("17.jpg");
            orchid17.setOrchidName("Lan Bạch Câu");
            orchid17.setOrchidDescription("Hoa lan bạch câu với sắc trắng tinh khiết");
            orchid17.setIsNatural("Tự nhiên");
            orchid17.setPrice(2150000);
            orchid17.setCategoryId(orchidCategory3);
            orchidService.save(orchid17);

            Orchids orchid18 = new Orchids();
            orchid18.setOrchidUrl("18.jpg");
            orchid18.setOrchidName("Lan Hồng Phấn");
            orchid18.setOrchidDescription("Hoa lan hồng phấn với sắc hồng dịu dàng");
            orchid18.setIsNatural("Nhân tạo");
            orchid18.setPrice(2250000);
            orchid18.setCategoryId(orchidCategory3);
            orchidService.save(orchid18);

            Orchids orchid19 = new Orchids();
            orchid19.setOrchidUrl("19.jpg");
            orchid19.setOrchidName("Lan Vàng Kim");
            orchid19.setOrchidDescription("Hoa lan vàng kim với màu vàng rực rỡ");
            orchid19.setIsNatural("Tự nhiên");
            orchid19.setPrice(2350000);
            orchid19.setCategoryId(orchidCategory);
            orchidService.save(orchid19);

            Orchids orchid20 = new Orchids();
            orchid20.setOrchidUrl("20.jpg");
            orchid20.setOrchidName("Lan Tím Ngọc");
            orchid20.setOrchidDescription("Hoa lan tím ngọc với sắc tím huyền bí");
            orchid20.setIsNatural("Nhân tạo");
            orchid20.setPrice(2450000);
            orchid20.setCategoryId(orchidCategory2);
            orchidService.save(orchid20);

        }
    }
}
