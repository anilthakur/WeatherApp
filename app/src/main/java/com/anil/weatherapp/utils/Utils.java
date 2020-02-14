package com.anil.weatherapp.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Anil Kumar on 2020-02-11
 */
public class Utils {
    public static byte[] recoverImageFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }

        return output.toByteArray();
    }

   public static String dayofweek(String date) {
       String[] arrOfStr = date.split("/", 5);
       int y = Integer.parseInt(arrOfStr[2]);
       int m = Integer.parseInt(arrOfStr[1]);
       int d = Integer.parseInt(arrOfStr[0]);
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        y -= (m < 3) ? 1 : 0;
        int day = (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;

        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return"Tuesday";
            case 3:
                return"Wednesday";
            case 4:
                return"Thursday";
            case 5:
                return"Friday";
            case 6:
                return"Saturday";
            case 7:
                return"Sunday";
        }
        return "";
    }

    public static String convertDateFormat(String date) {
        DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            Date mydate = srcDf.parse(date);
            DateFormat destDf = new SimpleDateFormat("dd/MM/yyyy");
            return destDf.format(mydate);

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
