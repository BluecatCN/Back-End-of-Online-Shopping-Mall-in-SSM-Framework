package com.succulent.goods.service;

//import com.mall.goods.admin.dto.GoodsInsert;
//import com.mall.goods.lib.entity.GoodsIdentity;
//import com.mall.goods.lib.entity.GoodsSku;
//import com.mall.goods.lib.repository.GoodsIdentityRepository;
//import com.mall.goods.lib.repository.GoodsSkuRepository;
//import com.mall.lib.data.IdentityCode;
//import com.mall.lib.date.util.TimeUtility;
//import com.mall.lib.file.scheme.FileSchemeGoods;
//import com.mall.lib.file.spec.FileSpecGoods;
//import com.mall.lib.file.util.FileUtil;
//import com.mall.lib.file.util.MultipartFileUtil;
//import com.mall.lib.response.RespBody;
//import com.mall.lib.response.RespCode;
import com.succulent.goods.entity.GoodsSku;
import com.succulent.goods.repository.GoodsIdentityRepository;
import com.succulent.goods.repository.GoodsSkuRepository;
import com.succulent.lib.date.util.TimeUtility;
import com.succulent.lib.file.util.FileUtil;
import com.succulent.lib.file.util.MultipartFileUtil;
import com.succulent.lib.spec.FileSpecGoods;
import com.succulent.user.common.RandomUtil;
import com.succulent.user.common.RespBody;
import com.succulent.user.common.RespCode;
import com.succulent.goods.dto.GoodsInsert;
import com.succulent.goods.entity.GoodsIdentity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsIdentityRepository goodsIdentityRepository;
    @Resource
    GoodsSkuRepository goodsSkuRepository;

    @Override
    public RespBody query(GoodsIdentity dto) {
        return new RespBody(RespCode.SUCCESS, goodsIdentityRepository.findAll(dto));
    }

    @Override
    public Object create(GoodsInsert dto, MultipartFile cover) throws Exception {
        MultipartFileUtil.check(cover);
        dto.setId(RandomUtil.genObjectId());
        dto.setDate(TimeUtility.getCurrentTimestampSecond());
        dto.setCover(MultipartFileUtil.genFileName(cover.getContentType()));
        if (goodsIdentityRepository.insert(dto) > 0 &&
                        goodsSkuRepository.insert(dto.toInsertSku(RandomUtil.genObjectId())) > 0)
        { MultipartFileUtil.save(cover, dto.getCover(), FileSpecGoods.COVER);}
            return new RespBody(RespCode.SUCCESS);
    }

//    @Override
//    public Object create(GoodsInsert dto, MultipartFile cover) {
//        //MultipartFileUtil.check(cover, FileSpecGoods.COVER);
//
//        //dto.setId(IdentityCode.gen());
//        dto.setId(RandomUtil.genObjectId());
//        //dto.setCover(MultipartFileUtil.genFileName(cover.getContentType(), FileSchemeGoods.COVER));
//        dto.setDate(TimeUtility.getCurrentTimestampSecond());
//        if
//        (
//                goodsIdentityRepository.insert(dto) > 0 &&
//                //goodsSkuRepository.insert(dto.toInsertSku(IdentityCode.gen())) > 0
//                goodsSkuRepository.insert(dto.toInsertSku(RandomUtil.genObjectId())) > 0
//        )
//            //MultipartFileUtil.save(cover, dto.getCover(), FileSpecGoods.COVER);
//
////            return;
//        return new RespBody(RespCode.SUCCESS);;
//        return null;
//}



    @Override
    public Object updateById(GoodsInsert dto, MultipartFile cover) throws Exception {
        boolean deletedOldFile = false;
        if (cover != null) {
            MultipartFileUtil.check(cover);
            GoodsIdentity queried = goodsIdentityRepository.findAll(new GoodsIdentity(dto.getId())).get(0);
            deletedOldFile = FileUtil.delete(queried.getCover());
            if (deletedOldFile)
            { dto.setCover(MultipartFileUtil.genFileName(cover.getContentType())); }
        }
        if (    dto.getId() != null &&
                goodsIdentityRepository.updateById(dto) > 0 &&
                cover != null &&
                deletedOldFile )
            MultipartFileUtil.save(cover, dto.getCover(), FileSpecGoods.COVER);
        GoodsSku sku = dto.toUpdateSku();
        if (sku != null)
        {goodsSkuRepository.updateById(sku);}
        return new RespBody(RespCode.SUCCESS);
    }

}
