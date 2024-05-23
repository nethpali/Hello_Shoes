package lk.com.ijse.hello_shoes_test.Controller;


import lk.com.ijse.hello_shoes_test.DTO.InventoryDto;
import lk.com.ijse.hello_shoes_test.Entity.Inventory_Gender;
import lk.com.ijse.hello_shoes_test.Service.InventoryService;
import lk.com.ijse.hello_shoes_test.Util.UtilMatter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/health")
    public String healthTest(){
        return "Inventory Health check";
    }

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public InventoryDto save(
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("status") String status,
            @RequestPart("gender") String gender,
            @RequestPart("occasion") String occasion,
            @RequestPart("supplier_id") String supplier_id
    ) throws ChangeSetPersister.NotFoundException {

        InventoryDto inventoryDTO = new InventoryDto();
        inventoryDTO.setItem_code(inventoryService.generateNextId(occasion,gender));
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_picture(item_pic);
        inventoryDTO.setCategory(category);
        inventoryDTO.setGender(Inventory_Gender.valueOf(gender));
        inventoryDTO.setOccasion(occasion);
        return inventoryService.saveInventory(inventoryDTO,supplier_id);
    }

    @GetMapping
    public List<InventoryDto> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean updateInventory(
            @RequestPart("item_code") String item_code,
            @RequestPart("item_desc") String item_desc,
            @RequestPart("item_qty") String item_qty,
            @RequestPart("item_pic") String item_pic,
            @RequestPart("category") String category,
            @RequestPart("size") String size,
            @RequestPart("unit_price_sale") String unit_price_sale,
            @RequestPart("unit_price_buy") String unit_price_buy,
            @RequestPart("expected_profit") String expected_profit,
            @RequestPart("profit_margin") String profit_margin,
            @RequestPart("status") String status
    ) throws ChangeSetPersister.NotFoundException {

        InventoryDto inventoryDTO = new InventoryDto();
        inventoryDTO.setItem_code(item_code);
        inventoryDTO.setItem_desc(item_desc);
        inventoryDTO.setItem_picture(UtilMatter.convertBase64(item_pic));
        inventoryDTO.setCategory(category);
        inventoryDTO.setUnit_price_sales(Double.parseDouble(unit_price_sale));
        inventoryDTO.setUnit_price_buy(Double.parseDouble(unit_price_buy));
        inventoryDTO.setExpected_profit(Double.parseDouble(expected_profit));
        inventoryDTO.setProfit_margin(Double.parseDouble(profit_margin));

        return inventoryService.updateInventory(item_code, inventoryDTO);
    }

    @DeleteMapping("/delete")
    public boolean deleteInventory(String item_code) throws ChangeSetPersister.NotFoundException {
        return inventoryService.deleteInventory(item_code);
    }

    @GetMapping("/selectInventory")
    public InventoryDto selectInventory(String item_code) throws ChangeSetPersister.NotFoundException {
        return inventoryService.selectInventoryById(item_code);
    }

    @PostMapping("/updateImg")
    public boolean updateImg(
            @RequestPart("item_code") String item_code,
            @RequestPart("item_pic") String item_pic
    ) throws ChangeSetPersister.NotFoundException {
        return inventoryService.updateImg(item_code, UtilMatter.convertBase64(item_pic));
    }
}
