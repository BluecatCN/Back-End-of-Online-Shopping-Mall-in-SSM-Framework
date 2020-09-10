CREATE DATABASE IF NOT EXISTS succulent default charset utf8;
USE succulent;

DROP TABLE IF EXISTS goods_identity;
CREATE TABLE goods_identity(
    id              VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    title           VARCHAR(32)                      COMMENT '',
    cover           VARCHAR(32)                      COMMENT '',
    discount        INT UNSIGNED DEFAULT 0           COMMENT '',
    intro           VARCHAR(2048)                    COMMENT '',
    type            TINYINT UNSIGNED                 COMMENT '',
    category_id     VARCHAR(32)                      COMMENT '',
    seq             INT UNSIGNED                     COMMENT '',
    stat            TINYINT UNSIGNED                 COMMENT '',
    date            INT UNSIGNED                     COMMENT ''
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';

DROP TABLE IF EXISTS goods_sku;
CREATE TABLE goods_sku(
    id              VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    goods_id        VARCHAR(32) NOT NULL             COMMENT '',
    price           INT UNSIGNED NOT NULL            COMMENT '',
    stock           INT UNSIGNED NOT NULL            COMMENT '',
    version         INT UNSIGNED DEFAULT 0           COMMENT '',
    INDEX(goods_id)
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';

DROP TABLE IF EXISTS goods_order;
CREATE TABLE goods_order(
    id              VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    uid             VARCHAR(32) NOT NULL             COMMENT '',
    trans_id        VARCHAR(32)                      COMMENT '',
    amount          INT UNSIGNED DEFAULT 0           COMMENT '',
    discount        INT UNSIGNED DEFAULT 0           COMMENT '',
    body            VARCHAR(128)                     COMMENT '',
    comment         VARCHAR(128)                     COMMENT '',
    stat            TINYINT UNSIGNED                 COMMENT '',
    date            BIGINT UNSIGNED                  COMMENT '',
    version         INT UNSIGNED DEFAULT 0           COMMENT '',
    INDEX(uid),
    INDEX(trans_id)
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';