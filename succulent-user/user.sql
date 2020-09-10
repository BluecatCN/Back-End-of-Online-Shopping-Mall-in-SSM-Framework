CREATE DATABASE IF NOT EXISTS succulent default charset utf8;
USE succulent;


-- 用户身份
DROP TABLE IF EXISTS user_identity;
CREATE TABLE user_identity(
    id          VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    wx_open_id  VARCHAR(32) UNIQUE               COMMENT '',
    wx_union_id VARCHAR(32) UNIQUE               COMMENT '',
    phone       VARCHAR(11) UNIQUE               COMMENT '',
    passcode    VARCHAR(32)                      COMMENT '',
    token       VARCHAR(32)                      COMMENT '',
    stat        TINYINT UNSIGNED                 COMMENT '',
    id_code     VARCHAR(32) UNIQUE               COMMENT '',
    date        INT UNSIGNED                     COMMENT ''
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';

-- 用户信息
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
    uid             VARCHAR(32) NOT NULL PRIMARY KEY  COMMENT '',
    name            VARCHAR(16) CHARACTER SET utf8mb4 COMMENT '',
    avatar          VARCHAR(256)                      COMMENT '',
    avatar_wx       VARCHAR(256)                      COMMENT '',
    intro           VARCHAR(512)                      COMMENT '',
    gender          TINYINT UNSIGNED                  COMMENT '',
    birthdate       INT UNSIGNED                      COMMENT '',
    date            INT UNSIGNED                      COMMENT '',
    dist            INT UNSIGNED                      COMMENT '',
    country         VARCHAR(32)                       COMMENT '',
    province        VARCHAR(32)                       COMMENT '',
    city            VARCHAR(32)                       COMMENT ''
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';


DROP TABLE IF EXISTS user_balance;
CREATE TABLE user_balance(
    uid             VARCHAR(32) NOT NULL PRIMARY KEY  COMMENT '',
    value           INT UNSIGNED                      COMMENT '',
    stat            TINYINT UNSIGNED                  COMMENT ''
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';

-- 收货地址
DROP TABLE IF EXISTS user_address;
CREATE TABLE user_address(
    id          VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    uid         VARCHAR(32) NOT NULL             COMMENT '',
    name        VARCHAR(32)                      COMMENT '',
    phone       VARCHAR(32)                      COMMENT '',
    country     VARCHAR(64)                      COMMENT '',
    province    VARCHAR(64)                      COMMENT '',
    city        VARCHAR(64)                      COMMENT '',
    zip         VARCHAR(64)                      COMMENT '',
    dist        VARCHAR(64)                      COMMENT '',
    note        VARCHAR(256)                     COMMENT '',
    main        TINYINT UNSIGNED                 COMMENT '',
    stat        TINYINT UNSIGNED                 COMMENT '',
    date        INT UNSIGNED                     COMMENT '',
    INDEX(uid)
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';

DROP TABLE IF EXISTS user_order;
CREATE TABLE user_order(
    id          VARCHAR(32) NOT NULL PRIMARY KEY COMMENT '',
    uid         VARCHAR(32) NOT NULL             COMMENT '',
    price       INT UNSIGNED                     COMMENT '',
    address_id  VARCHAR(32)                      COMMENT '',
    stat        TINYINT UNSIGNED                 COMMENT '',
    date        INT UNSIGNED                     COMMENT '',
    INDEX(uid)
) ENGINE=Innodb DEFAULT CHARSET='utf8' COMMENT='';