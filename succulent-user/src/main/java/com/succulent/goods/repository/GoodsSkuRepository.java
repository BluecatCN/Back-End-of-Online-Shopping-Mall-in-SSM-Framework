package com.succulent.goods.repository;

//import com.mall.goods.lib.entity.GoodsSku;
//import com.mall.goods.lib.qo.GoodsSkuStockUpdateById;
import com.succulent.goods.entity.GoodsSku;
import com.succulent.goods.qo.GoodsSkuStockUpdateById;

import java.util.List;

public interface GoodsSkuRepository {

    Integer insert(GoodsSku sku);

    GoodsSku findById(String id);

    List<GoodsSku> findByGoodsId(String goodsId);

    Integer updateById(GoodsSku sku);

    Integer updateStockById(GoodsSkuStockUpdateById qo);

}
