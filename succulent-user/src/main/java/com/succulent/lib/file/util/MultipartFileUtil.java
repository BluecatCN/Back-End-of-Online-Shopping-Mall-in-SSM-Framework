package com.succulent.lib.file.util;

import com.succulent.user.common.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class MultipartFileUtil {
    private static Logger logger = LoggerFactory.getLogger(MultipartFileUtil.class);

    public static void check(MultipartFile multipartFile) throws Exception {
        if (multipartFile == null) {
            throw new Exception();
        }
    }

    public static void save(MultipartFile multipartFile, String fileName, String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            logger.info(dir + "不存在，即将创建目录");
            if (!dir.mkdirs()) {
                logger.info(dir + "目录创建失败");
            }
        }
        try {
            multipartFile.transferTo(new File(directory + "/" + fileName));
        } catch (Exception e) {
            logger.info(dir + "目录保存失败");
            e.printStackTrace();
        }
    }

    public static String genFileName(String contentType) {
        String name;
        if (contentType != null) {
            String[] strs = contentType.split("/");
            name = RandomUtil.genObjectId() + "." + strs[strs.length - 1];
        } else {
            name = RandomUtil.genObjectId();
        }
        return name;
    }

}
