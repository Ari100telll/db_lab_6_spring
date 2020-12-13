package ua.lviv.iot.uklon.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_state")
public class OrderState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "state")
    private String state;

    public OrderState() {
    }

    public OrderState(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderState)) return false;
        OrderState that = (OrderState) o;
        return id.equals(that.id) &&
                state.equals(that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }

    @Override
    public String toString() {
        return "OrderState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}