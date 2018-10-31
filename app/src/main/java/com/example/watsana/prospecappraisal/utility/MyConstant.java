package com.example.watsana.prospecappraisal.utility;

public class MyConstant {

    // FileZilla
    private String hostString = "ftp.swiftcodingthai.com";
    private String userString = "pro@swiftcodingthai.com";
    private String passwordString = "Abc12345";
    private int postAnInt = 21;

    //    URL
    private String urlAddsp_mainString = "http://swiftcodingthai.com/pro/addDataLogin.php";


    //    Array
    private String[] login_sp_mainString = new String[]{
            "id_code",
            "user_survey_name",
            "user_survey_number",
            "user_survey_book",
            "user_survey_date",
            "user_estimate_name",
            "user_estimate_number",
            "user_estimate_book",
            "user_estimate_date ",
            "user_two_name",
            "user_two_number",
            "user_two_book",
            "user_two_date",
            "assessor_name",
            "assessor_number",
            "assessor_book",
            "assessor_date",
            "power_manager_name",
            "power_manager_number",
            "power_manager_book",
            "power_manager_date",
            "power_power_name",
            "power_power_number",
            "power_power_book",
            "power_power_date",
            "power_two_name",
            "power_two_number",
            "power_two_book",
            "power_two_date",
            "admin_name1",
            "admin_name2",
            "agency_party",
            "agency_branch",
            "agency_center"
    };
    private String[] typeDocStrings = new String[]{
            "โปรดเลือกประเภท",
            "โฉลดที่ดิน",
            "โฉนดตราจอง",
            "นส.3ก",
            "นส.3",
            "อช.2",
            "อื่นๆ"
    };

//    Getter
    public String getHostString() {
        return hostString;
    }

    public String getUserString() {
        return userString;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public int getPostAnInt() {
        return postAnInt;
    }

    public String[] getLogin_sp_mainString() {
        return login_sp_mainString;
    }

    public String getUrlAddsp_mainString() {
        return urlAddsp_mainString;
    }

    public String[] getTypeDocStrings() {
        return typeDocStrings;
    }

}//Main Class

