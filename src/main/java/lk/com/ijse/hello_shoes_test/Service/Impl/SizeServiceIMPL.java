package lk.com.ijse.hello_shoes_test.Service.Impl;

import jakarta.transaction.Transactional;
import lk.com.ijse.hello_shoes_test.DTO.SizeDTO;
import lk.com.ijse.hello_shoes_test.Entity.Size;
import lk.com.ijse.hello_shoes_test.Service.SizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SizeServiceIMPL implements SizeService {
    @Override
    public boolean saveSize(SizeDTO sizeDTO) {
        return false;
    }

    @Override
    public boolean deleteSize(String item_code, String sizeId) {
        return false;
    }

    @Override
    public boolean updateSize(String id, SizeDTO sizeDTO) {
        return false;
    }

    @Override
    public List<SizeDTO> getAllSizes() {
        return null;
    }

    @Override
    public List<String> getItemIds() {
        return null;
    }

    @Override
    public Size getDataWithSizeAndItemID(String itemCode, String itemSize) {
        return null;
    }
}
