package lk.com.ijse.hello_shoes_test.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
@ToString
@Getter
@Setter
public class Inventory implements SuperEntity{
    @Id
    private String item_code;
    private String item_desc;
    @Column(columnDefinition = "LONGTEXT")
    private String item_pic;
    private String category;
    @Enumerated(EnumType.STRING)
    private Inventory_Gender gender;
    private String occasion;

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private Set<SalesDetails> saleDetails = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private Set<SupplierInventory> supplierInventoryDetails = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private List<Size> sizes = new ArrayList<>();







}
