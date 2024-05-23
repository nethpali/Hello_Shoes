package lk.com.ijse.hello_shoes_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="sales")
public class Sales implements SuperEntity {
    @Id
    private String order_id;
    private String customer_name;
    private String item_desc;
    private int size;
    private double unit_price;
    private double item_qty;
    private double total_price;
    private Date purchase_date;
    private String payment_method;
    private double added_points;
    private String cashier_name;


    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private Set<SalesDetails> saleDetails = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_code")
    private Customer customer;
}
