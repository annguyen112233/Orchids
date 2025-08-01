package sum25.hsf302.exercise2_se184546.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "orchids")
public class Orchids {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orchid_id")
    private int orchidId;
    @Column(name = "is_natural",columnDefinition = "nvarchar(60)")
    private String isNatural;
    @Column(name = "orchid_description",columnDefinition = "nvarchar(60)")
    private String orchidDescription;
    @Column(name = "orchid_name",columnDefinition = "nvarchar(60)")
    private String orchidName;
    @Column(name = "orchid_url")
    private String orchidUrl;
    @Column(name = "price")
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Categories categoryId;


    public Orchids() {
    }

    public Orchids(int orchidId, String isNatural, String orchidDescription, String orchidName, String orchidUrl, double price, Categories categoryId) {
        this.orchidId = orchidId;
        this.isNatural = isNatural;
        this.orchidDescription = orchidDescription;
        this.orchidName = orchidName;
        this.orchidUrl = orchidUrl;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getOrchidId() {
        return orchidId;
    }

    public void setOrchidId(int orchidId) {
        this.orchidId = orchidId;
    }

    public String getIsNatural() {
        return isNatural;
    }

    public void setIsNatural(String isNatural) {
        this.isNatural = isNatural;
    }

    public String getOrchidDescription() {
        return orchidDescription;
    }

    public void setOrchidDescription(String orchidDescription) {
        this.orchidDescription = orchidDescription;
    }

    public String getOrchidName() {
        return orchidName;
    }

    public void setOrchidName(String orchidName) {
        this.orchidName = orchidName;
    }

    public String getOrchidUrl() {
        return orchidUrl;
    }

    public void setOrchidUrl(String orchidUrl) {
        this.orchidUrl = orchidUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
    }
}
