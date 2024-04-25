package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.CustomerDto;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto saveSupplier(SupplierDto supplierDto);
    boolean updateSupplier(String id, SupplierDto supplierDto);
    boolean deleteSupplier(String id);

    List<SupplierDto> getAllCustomer();
}
