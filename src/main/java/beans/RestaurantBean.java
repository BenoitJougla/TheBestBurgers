package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Restaurant")
@Table(name = "RESTAURANT")
public class RestaurantBean implements Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Reference obligatoire")
    @Column(name = "name")
    private String name;
    @NotNull(message = "Reference obligatoire")
    @Column(name = "latitude")
    private double latitude;
    @NotNull(message = "Reference obligatoire")
    @Column(name = "longitude")
    private double longitude;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BurgerBean> burgers;

    public List<BurgerBean> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<BurgerBean> burgers) {
        this.burgers = burgers;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
