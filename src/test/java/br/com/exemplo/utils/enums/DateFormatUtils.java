package br.com.exemplo.utils.enums;

public enum DateFormatUtils {
    DD_MM_YYYY("dd-MM-yyyy"),
    DD_MM_YYYY_BARRA("dd/MM/yyyy"),
    DD_MM_YY("dd-MM-yy"),

    MM_DD_YYYY("MM-dd-yyyy"),
    MM_DD_YY("MM-dd-yy"),

    YYYY_MM_DD("yyyy-MM-dd"),

    YYYY_MM_DD_HH_MM_SS ("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD_HH_MM_SS_SSS ("yyyy-MM-dd HH:mm:ss.SSS"),
    YYYY_MM_DD_HH_MM_SS_SSSZ ("yyyy-MM-dd HH:mm:ss.SSSZ"),
    YYYY_MM_DD_T_HH_MMZ ("yyyy-MM-dd'T'HH:mm'Z'"),

    EEEEE_DD_MMMMM_YYYY("EEEEE dd MMMMM yyyy"),

    PATTERN_SCREENSHOT ("yyyyMMddHHmmss")
    ;

    private final String pattern;

    DateFormatUtils(String pattern){
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return pattern;
    }
}

