CREATE TABLE IF NOT EXISTS `big_commercial`.`user`(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    userId VARCHAR (10) NOT NULL,
    email VARCHAR (50) NOT NULL,
    password VARCHAR (100) NOT NULL,
    first_name VARCHAR (50),
    last_name VARCHAR (50),
    company VARCHAR (50),
    img_url VARCHAR (255),
    phone VARCHAR (10),
    store_credit DECIMAL (12,2),
    role VARCHAR (10) NOT NULL,
    join_date DATETIME (6) NOT NULL,
    last_login DATETIME (6),
    last_login_display DATETIME (6),
    authorities TINYBLOB,
    is_active BIT (1),
    is_not_locked BIT (1)
)