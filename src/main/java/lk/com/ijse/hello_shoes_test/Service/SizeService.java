package lk.com.ijse.hello_shoes_test.Service;

import lk.com.ijse.hello_shoes_test.DTO.SizeDTO;
import lk.com.ijse.hello_shoes_test.Entity.Size;

import java.util.List;

public interface SizeService {
    boolean saveSize(SizeDTO sizeDTO);
    boolean deleteSize(String item_code, String sizeId);
    boolean updateSize(String id, SizeDTO sizeDTO);
    List<SizeDTO> getAllSizes();
    List<String> getItemIds();
    Size getDataWithSizeAndItemID(String itemCode, String itemSize);
}
