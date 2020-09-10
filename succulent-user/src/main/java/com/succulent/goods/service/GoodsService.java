package com.succulent.goods.service;

//import com.mall.goods.admin.dto.GoodsInsert;
//import com.mall.goods.lib.entity.GoodsIdentity;
import com.succulent.goods.dto.GoodsInsert;
import com.succulent.goods.entity.GoodsIdentity;
import org.springframework.web.multipart.MultipartFile;

public interface GoodsService {

    Object query(GoodsIdentity dto);

    Object create(GoodsInsert dto, MultipartFile cover) throws Exception;

    Object updateById(GoodsInsert dto, MultipartFile cover) throws Exception;

    //Object create(GoodsInsert dto);
}
