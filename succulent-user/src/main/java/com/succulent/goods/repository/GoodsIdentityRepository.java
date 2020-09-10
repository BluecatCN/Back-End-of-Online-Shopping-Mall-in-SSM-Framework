package com.succulent.goods.repository;

//import com.mall.goods.lib.entity.GoodsIdentity;
import com.succulent.goods.entity.GoodsIdentity;

import java.util.List;

public interface GoodsIdentityRepository {

    Integer insert(GoodsIdentity goods);

    List<GoodsIdentity> findAll(GoodsIdentity goods);

    GoodsIdentity findById(String id);

    Integer updateById(GoodsIdentity goods);

}
