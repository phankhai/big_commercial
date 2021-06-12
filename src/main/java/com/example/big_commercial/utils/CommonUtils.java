package com.example.big_commercial.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.nimbusds.oauth2.sdk.util.StringUtils;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by son.nguyen on 7/10/2020.
 */
public class CommonUtils {
    public static void main(String[] args) {
        System.out.println(genSmsOTP());
    }

    public static boolean isValidEmail(String email) {
        if (StringUtils.isBlank(email)) return false;
        return rfc2822.matcher(email.toLowerCase()).matches();
    }

    public static String toValidPhoneNumber(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return null;
        }
        try {
            String DEFAULT_COUNTRY = "DEFAULT_COUNTRY";
            Phonenumber.PhoneNumber pn = PhoneNumberUtil.getInstance().parse(mobile, DEFAULT_COUNTRY);
            if (!PhoneNumberUtil.getInstance().isValidNumber(pn)) {
                return null;
            }
            String validPhone = PhoneNumberUtil.getInstance().format(pn, PhoneNumberUtil.PhoneNumberFormat.E164);
            return validPhone;
        } catch (NumberParseException e) {
            return null;
        }
    }

    public static Date convertTimeInMilliToDate(Long timeInMilli) {
        return convertUnixTimeToDate(timeInMilli != null ? timeInMilli / 1000 : null, false);
    }

    public static Date convertTimeInMilliToDate(Long timeInMilli, Boolean isEndDate) {
        return convertUnixTimeToDate(timeInMilli != null ? timeInMilli / 1000 : null, isEndDate);
    }

    public static Date convertUnixTimeToDate(Long unixTime) {
        return convertUnixTimeToDate(unixTime, false);
    }

    public static Date convertUnixTimeToDate(Long unixTime, Boolean isEndDate) {
        if (unixTime != null) {
            Date date = new Date(unixTime * 1000);
            if (isEndDate) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.SECOND, 86399);
                return calendar.getTime();
            }
            return date;
        } else {
            if (isEndDate) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 86399);
                return calendar.getTime();
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, -12);
                return calendar.getTime();
            }
        }
    }

    public static String genPassword() {
        int length = 4;
        Random rand = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(PASSWD_CHARSET.charAt(rand.nextInt(PASSWD_CHARSET.length())));
        }
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(PASSWD_CHARSET.charAt(rand.nextInt(PASSWD_CHARSET.length()))).toUpperCase());
        }

        sb.append(rand.nextInt(PASSWD_DIGIT_CHARSET.length()));
        return sb.toString();
    }

    public static String genSmsOTP() {
        StringBuffer sb = new StringBuffer();
        int length = 4;
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(OTP_DIGIT_CHARSET.charAt(rand.nextInt(OTP_DIGIT_CHARSET.length())));
        }
        return sb.toString();
    }

    public static String convertDateTimeToString(Date date) {
        String dateTimeStr = null;
        if (date != null) {
            dateTimeStr = mmmDYhhMMSSFormat.format(date);
        }
        return dateTimeStr;
    }

    public static String convertDateToString(Date date) {
        String dateTimeStr = null;
        if (date != null) {
            dateTimeStr = dMYFormat.format(date);
        }
        return dateTimeStr;
    }

    public static Date convertStringToDate(String dateStr) throws ParseException {
        Date date = null;
        if (dateStr != null) {
            date = dMYFormat.parse(dateStr);
        }
        return date;
    }

    public static Date convertStringToDateTime(String dateStr) throws ParseException {
        Date date = null;
        if (dateStr != null) {
            date = mmmDYhhMMSSFormat.parse(dateStr);
        }
        return date;
    }

    public static String genCode(String prefix, Long id, Long objId) {
        StringBuffer sb = new StringBuffer();
        sb.append(prefix).append(id).append(objId);
        return sb.toString().toUpperCase();
    }

    public static String toSlug(String input) {
        String noWhiteSpace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String genCode4Order(Long orderTotal) {
        String dateTimeStr = yyMMddFormat.format(Calendar.getInstance().getTime());
        return dateTimeStr.concat(String.format("%04d", orderTotal));
    }

    //At least 8 characters
    //Contain at least one lower case character
    //Contain at least one upper case character
    //no whitespace
    public static boolean isValidPassword(String password) {
        if (StringUtils.isBlank(password)) return false;
        return passwordPattern.matcher(password).matches();
    }

    private static final Pattern rfc2822 = Pattern.compile(
            "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
    );
    public static final String PASSWD_CHARSET = "abcdefghijklmnopqrstuvwxyz";
    public static final String PASSWD_DIGIT_CHARSET = "23456789";
    public static final String OTP_DIGIT_CHARSET = "1234567890";
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
    static SimpleDateFormat mmmDYhhMMSSFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
    static SimpleDateFormat dMYFormat = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat yyMMddFormat = new SimpleDateFormat("yyMMdd");
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
}
