package lk.com.ijse.hello_shoes_test.Controller;

import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/health")
    public String healthTest(){
        return "supplier Health Test";
    }


    @PostMapping("/save")
    public SupplierDto saveSupplier(@RequestBody SupplierDto supplierDto){
        supplierDto.setSupplier_code(UUID.randomUUID().toString());
        return supplierService.saveSupplier(supplierDto);
    }

    @PutMapping(value="/update",consumes= MediaType.APPLICATION_JSON_VALUE)
    public boolean updateSupplier(@RequestBody SupplierDto supplierDto){
        return supplierService.updateSupplier(supplierDto.getSupplier_code(), supplierDto);

    }
}
