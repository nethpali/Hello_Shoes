package lk.com.ijse.hello_shoes_test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "sales_details")
public class SalesDetails {
    @Id
    private String orderDetailId;
    private String item_Name;
    private int quantity;
    private double unit_Cost;
    private double unit_Price;
    private double subTotal;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_code")
    private Inventory inventory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Sales sales;
}
