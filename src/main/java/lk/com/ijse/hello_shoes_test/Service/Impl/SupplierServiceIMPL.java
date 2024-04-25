package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.Dao.CustomerDao;
import lk.com.ijse.hello_shoes_test.Dao.SupplierDao;
import lk.com.ijse.hello_shoes_test.Service.SupplierService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {
    private final SupplierDao supplierDao;
    private final Mapping mapper;
    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        return mapper.toSupplierDto(supplierDao.save(mapper.toSupplierEntity(supplierDto)));
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
