package com.github.xKenKOfficial.Utils.Utils.All;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil
{
    public static SimpleDateFormat sdf;

    public static String secondsToTimestamp(int seconds) {
        int d = 0;
        int h = 0;
        int m = 0;
        int div = 86400;
        if (seconds >= div) {
            final int remainder = Integer.remainderUnsigned(seconds, div);
            d = seconds / div;
            seconds = remainder;
        }
        div = 3600;
        if (seconds >= div) {
            final int remainder = Integer.remainderUnsigned(seconds, div);
            h = seconds / div;
            seconds = remainder;
        }
        div = 60;
        if (seconds >= div) {
            final int remainder = Integer.remainderUnsigned(seconds, div);
            m = seconds / div;
            seconds = remainder;
        }
        String output = "";
        if (d > 0) {
            output = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(d)))))) + "d";
        }
        if (h > 0) {
            output = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(output)))))) + h + "h";
        }
        if (m > 0) {
            output = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(output)))))) + m + "m";
        }
        if (seconds > 0) {
            output = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(output)))))) + seconds + "s";
        }
        return output;
    }

    public static int timestampToSeconds(final String timestamp) {
        final String[] split = timestamp.split("");
        int d = 0;
        int h = 0;
        int m = 0;
        int s = 0;
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equalsIgnoreCase("d")) {
                int length = 0;
                for (int j = 1; j < 100 && i - j >= 0 && !Character.isLetter(split[i - j].charAt(0)); ++j) {
                    ++length;
                }
                if (length != 0) {
                    String string = "";
                    for (int k = i - length; k < i; ++k) {
                        string = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(string)))))) + split[k];
                    }
                    d = Integer.parseInt(string);
                }
            }
            else if (split[i].equalsIgnoreCase("h")) {
                int length = 0;
                for (int j = 1; j < 100 && i - j >= 0 && !Character.isLetter(split[i - j].charAt(0)); ++j) {
                    ++length;
                }
                if (length != 0) {
                    String string = "";
                    for (int k = i - length; k < i; ++k) {
                        string = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(string)))))) + split[k];
                    }
                    h = Integer.parseInt(string);
                }
            }
            else if (split[i].equalsIgnoreCase("m")) {
                int length = 0;
                for (int j = 1; j < 100 && i - j >= 0 && !Character.isLetter(split[i - j].charAt(0)); ++j) {
                    ++length;
                }
                if (length != 0) {
                    String string = "";
                    for (int k = i - length; k < i; ++k) {
                        string = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(string)))))) + split[k];
                    }
                    m = Integer.parseInt(string);
                }
            }
            else if (split[i].equalsIgnoreCase("s")) {
                int length = 0;
                for (int j = 1; j < 100 && i - j >= 0 && !Character.isLetter(split[i - j].charAt(0)); ++j) {
                    ++length;
                }
                if (length != 0) {
                    String string = "";
                    for (int k = i - length; k < i; ++k) {
                        string = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(string)))))) + split[k];
                    }
                    s = Integer.parseInt(string);
                }
            }
        }
        return d * 24 * 60 * 60 + h * 60 * 60 + m * 60 + s;
    }

    public static long getTimeWithString(final String s) {
        final Pattern pattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[, \\s]*)?(?:([0-9]+)\\s*mo[a-z]*[, \\s]*)?(?:([0-9]+)\\s*d[a-z]*[, \\s]*)?(?:([0-9]+)\\s*h[a-z]*[, \\s]*)?(?:([0-9]+)\\s*m[a-z]*[, \\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
        final Matcher matcher = pattern.matcher(s);
        long czas = 0L;
        boolean found = false;
        while (matcher.find()) {
            if (matcher.group() != null && !matcher.group().isEmpty()) {
                for (int i = 0; i < matcher.groupCount(); ++i) {
                    if (matcher.group(i) != null && !matcher.group(i).isEmpty()) {
                        found = true;
                        break;
                    }
                }
                if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
                    czas += 31536000 * Integer.valueOf(matcher.group(1));
                }
                if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                    czas += 2592000 * Integer.valueOf(matcher.group(2));
                }
                if (matcher.group(3) != null && !matcher.group(3).isEmpty()) {
                    czas += 86400 * Integer.valueOf(matcher.group(3));
                }
                if (matcher.group(4) != null && !matcher.group(4).isEmpty()) {
                    czas += 3600 * Integer.valueOf(matcher.group(4));
                }
                if (matcher.group(5) != null && !matcher.group(5).isEmpty()) {
                    czas += 60 * Integer.valueOf(matcher.group(5));
                }
                if (matcher.group(6) == null) {
                    continue;
                }
                if (matcher.group(6).isEmpty()) {
                    continue;
                }
                czas += Integer.valueOf(matcher.group(6));
            }
        }
        if (!found) {
            return -1L;
        }
        return czas * 1000L;
    }

    public static String getDate(final long czas) {
        return TimeUtil.sdf.format(new Date(czas));
    }

    public static long getTimeWithArgs(final String czas) {
        final long sekundy = 1000 * Integer.valueOf(czas.split(";")[0]);
        final long minuty = 1000 * Integer.valueOf(czas.split(";")[1]) * 60;
        final long godziny = 1000 * Integer.valueOf(czas.split(";")[2]) * 60 * 60;
        final long dni = 1000 * Integer.valueOf(czas.split(";")[3]) * 60 * 60 * 24;
        final long miesiace = 1000 * Integer.valueOf(czas.split(";")[4]) * 60 * 60 * 24 * 30;
        final long lata = 1000 * Integer.valueOf(czas.split(";")[5]) * 60 * 60 * 24 * 30 * 12;
        final long wieki = 1000 * Integer.valueOf(czas.split(";")[6]) * 60 * 60 * 24 * 30 * 12 * 100;
        final long czasBana = System.currentTimeMillis() + sekundy + minuty + godziny + dni + miesiace + lata + wieki;
        return czasBana;
    }

    static {
        TimeUtil.sdf = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
    }
}
