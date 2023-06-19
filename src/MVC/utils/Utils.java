package MVC.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;

public class Utils {
    public static void createDialog(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert warning = new Alert(type);
        warning.setTitle(title);
        warning.setHeaderText(headerText);
        warning.setContentText(contentText);
        warning.showAndWait();
    }
    public static String convertDate(String date){
        String result;
        String[] date_split = date.split("-");
        result = date_split[2]+"/"+date_split[1]+"/"+date_split[0];
        return result;
    }

    public static String convertTime(String time){
        String result;
        String[] timeArr = time.split(" ");
        String[] date = timeArr[0].split("-");
        result = timeArr[1] + " "+ date[2]+"/"+date[1]+"/"+date[0];
        return result;
    }

    public static boolean isValidTime(String time)
    {
//        String regex = "^(2[0-3]{2}|[01]?[0-9]{2}):([0-5]?[0-9]{2})$";
        String regex = "^(2[0-3]|[1][0-9]|[0][0-9]):(0[0-9]|[1-5][0-9]):(0[0-9]|[1-5][0-9])$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(time);
        return m.matches();
    }
}
