package com.succulent.goods.controller;

//import com.mall.goods.lib.entity.GoodsIdentity;
//import com.mall.goods.lib.macro.GoodsStat;
//import com.mall.goods.service.GoodsService;
import com.succulent.goods.dto.GoodsInsert;
import com.succulent.goods.entity.GoodsStat;
import com.succulent.goods.service.GoodsService;
import com.succulent.goods.entity.GoodsIdentity;
import com.succulent.goods.service.GoodsServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(value = "/com/succulent/goods")
@RestController
public class GoodsController {

    @Resource
    GoodsService goodsServiceImpl;

    @GetMapping
    public Object query(GoodsIdentity dto) {
        dto.setStat(GoodsStat.NORMAL.getValue());
        Object aa=goodsServiceImpl.query(dto);
        System.out.println(aa);
        return goodsServiceImpl.query(dto);
    }
    @PostMapping
    Object create(GoodsInsert dto, MultipartFile cover) throws Exception
    { return goodsServiceImpl.create(dto,cover); }

    @PutMapping
    Object updateById(GoodsInsert dto, MultipartFile cover) throws Exception {
        return goodsServiceImpl.updateById(dto,cover);
    }

}
