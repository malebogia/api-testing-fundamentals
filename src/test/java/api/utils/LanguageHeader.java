package api.utils;

public enum LanguageHeader {

    BG("bg"),
    EN("en");

    private String code;

    LanguageHeader(String code ){
        this.code = code;
    }


    public String getCode() {
        return code;
    }
}
