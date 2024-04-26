package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.SupplierDto;
import lk.com.ijse.hello_shoes_test.Dao.CustomerDao;
import lk.com.ijse.hello_shoes_test.Dao.SupplierDao;
import lk.com.ijse.hello_shoes_test.Entity.Customer;
import lk.com.ijse.hello_shoes_test.Entity.Supplier;
import lk.com.ijse.hello_shoes_test.Service.SupplierService;
import lk.com.ijse.hello_shoes_test.Util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Supplier> supplier = supplierDao.findById(id);
        if (supplier.isPresent()) {

            supplier.get().setSupplier_name(supplierDto.getSupplier_name());
            supplier.get().setCategory(supplierDto.getCategory());
            supplier.get().setAddress_01(supplierDto.getAddress_01());
            supplier.get().setAddress_02(supplierDto.getAddress_02());
            supplier.get().setAddress_03(supplierDto.getAddress_03());
            supplier.get().setAddress_04(supplierDto.getAddress_04());
            supplier.get().setAddress_05(supplierDto.getAddress_05());
            supplier.get().setAddress_06(supplierDto.getAddress_06());
            supplier.get().setContact_no_01(supplierDto.getContact_no_01());
            supplier.get().setContact_no_02(supplierDto.getContact_no_02());
            supplier.get().setEmail(supplierDto.getEmail());

            return true;
        }
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
