package com.example.big_commercial.enums;


public enum ErrorCodeMap {
    FAILURE_EXCEPTION(-1),
    FAILURE_PHONE_EXISTED(1),
    FAILURE_FULLNAME_EMPTY(2),
    FAILURE_GENDER_EMPTY(3),
    FAILURE_PHONE_EMPTY(4),
    FAILURE_PASSWORD_EMPTY(5),
    FAILURE_USER_EXISTED(6),
    FAILURE_USER_NOT_EXISTED(6),
    FAILURE_INVALID_PHONE(7),
    FAILURE_INVALID_EMAIL(8),
    FAILURE_USER_ID_EMPTY(9),
    FAILURE_NOT_FULL_QUESTION(10),
    FAILURE_TOKEN_INVALID(11),
    FAILURE_EMAIL_EMPTY(12),
    FAILURE_RETYPEPASSWORD_NOTMATCH_PASSWORD(13),
    FAILURE_INVALID_ORG_BUSINESS_TYPE(14),
    FAILURE_LOGON_ID_EMPTY(15),
    FAILURE_INVALID_LOGON_ID(16),
    FAILURE_INVALID_INPUT_PARAM(17),
    FAILURE_INVALID_PASSWORD(18),
    FAILURE_WRONG_PASSWORD(19),
    FAILURE_COUNTRY_ID_EMPTY(20),
    FAILURE_CITY_ID_EMPTY(21),
    FAILURE_STATE_ID_EMPTY(22),
    FAILURE_ADDRESS_EMPTY(23),
    FAILURE_BUSINESS_TYPE_EMPTY(24),
    FAILURE_EMAIl_EXISTED(25),
    FAILURE_INVALID_STORE(26),
    FAILURE_INVALID_OTP_EXPIRE(27),
    FAILURE_INVALID_OTP_VALUE(28),
    FAILURE_DEGREE_EMPTY(29),
    FAILURE_CAREER_EMPTY(30),
    FAILURE_IDENTITY_NUMBER_EMPTY(31),
    FAILURE_MARRIED_EMPTY(32),
    FAILURE_INVALID_ORDER(33),
    FAILURE_INVALID_ORGANIZATION(34),
    FAILURE_NEED_CONTRACT(35),
    FAILURE_INVALID_CONTRACT_STATE(36),
    FAILURE_INVALID_ORDER_STATUS(37),
    FAILURE_PERMISSION_DENY(38),
    FAILURE_SURVEY_COMPLETED(39),
    FAILURE_FILE_EMPTY(40),
    FAILURE_BUSINESS_SUBTYPE_EMPTY(41),
    FAILURE_BIRTHDAY_EMPTY(42),
    FAILURE_BANK_NUMBER_EMPTY(43),
    FAILURE_BANK_NAME_EMPTY(44),
    FAILURE_BANK_ACCOUNT_NAME_EMPTY(45),
    FAILURE_INVALID_MONEY(46),
    FAILURE_MONEYINPUT_GREATER_THAN_EXTRAMONEY(47),
    FAILURE_DEACTIVE_MEMBER(48),
    FAILURE_PRODUCT_CODE_EMPTY(49),
    FAILURE_PRODUCT_NAME_EMPTY(50),
    FAILURE_EXCEL_PRODUCT_SHEET_NOT_FOUND(51),
    FAILURE_EXCEL_SKUS_SHEET_NOT_FOUND(52),
    FAILURE_EXCEL_FILE_NOT_FOUND(53),
    FAILURE_CATALOGUE_NOT_FOUND(54),
    FAILURE_CATEGORY_NOT_FOUND(55),
    FAILURE_PRODUCT_EXISTED(56),
    FAILURE_PRODUCT_NOT_FOUND(57),
    FAILURE_SKU_EXISTED(58),
    FAILURE_SKU_NOT_FOUND(59),
    FAILURE_PART_NUMBER_EXISTED(60),
    FAILURE_PART_NUMBER_WITH_BLANK(61),
    FAILURE_CODE_EXISTED(62),
    FAILURE_CODE_WITH_BLANK(63),
    FAILURE_SLUG_EXISTED(64),
    FAILURE_INVALID_CATEGORY_HAS_PRODUCT(65),
    FAILURE_SLUG_WITH_BLANK(66),
    FAILURE_NEWS_CATEGORY_NOT_FOUND(67),
    FAILURE_NEWS_NOT_FOUND(68),
    ;
    private final int value;
    private ErrorCodeMap(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
