package ua.lviv.iot.uklon.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adress")
public class Adress {


    private Integer id;
    private Streets streets;
    private Integer houseNumber;
    private String houseLetter;
    private City cityId;

    public Adress() {
    }

    public Adress(Integer id, Streets streets, Integer houseNumber, String houseLetter, City cityId) {
        this.id = id;
        this.streets = streets;
        this.houseNumber = houseNumber;
        this.houseLetter = houseLetter;
        this.cityId = cityId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "streets_id", referencedColumnName = "id", nullable = false)
    public Streets getStreets() {
        return streets;
    }

    public void setStreets(Streets streets) {
        this.streets = streets;
    }

    @Column(name = "house_number")
    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Column(name = "house_letter")
    public String getHouseLetter() {
        return houseLetter;
    }

    public void setHouseLetter(String houseLetter) {
        this.houseLetter = houseLetter;
    }

    @ManyToOne
    @JoinColumn(name = "city_id",
            referencedColumnName = "id", nullable = false)
    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return id.equals(adress.id) &&
                streets.equals(adress.streets) &&
                houseNumber.equals(adress.houseNumber) &&
                Objects.equals(houseLetter, adress.houseLetter) &&
                cityId.equals(adress.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streets, houseNumber, houseLetter, cityId);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", streets=" + streets +
                ", houseNumber=" + houseNumber +
                ", houseLetter='" + houseLetter + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}