package lk.com.ijse.hello_shoes_test.Service.Impl;

import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.Service.SupplierService;

import java.util.List;

public class SupplierServiceIMPL implements SupplierService {
    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        return null;
    }

    @Override
    public boolean updateSupplier(String id, SupplierDto supplierDto) {
        return false;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public List<SupplierDto> getAllCustomer() {
        return null;
    }
}
