package test_components;

public class Utilities {

    public static String title = "ToolsQA Demo Site";
    public static String searchedWord = "MAXI DRESS";
    public static String productName = "RED SATIN ROUND NECK BACKLESS MAXI DRESS";
    public static String color = "Mauve";
    public static String size = "Large";

    public static String errorFilterMsg = "Products are not filtered properly!";
//    public static String errorTitleMsg = "Title is not as expected";

    public static String pageLoadFail(String page) {
        return "Title " + page + " is not as expected!";
    }

}
