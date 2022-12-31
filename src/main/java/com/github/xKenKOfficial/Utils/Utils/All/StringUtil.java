package com.github.xKenKOfficial.Utils.Utils.All;

public class StringUtil
{
    public static String stringBuilder(final String[] args, final int numberOfArg) {
        String msg = "";
        for (int i = numberOfArg; i < args.length; ++i) {
            msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg))))))) + args[i];
            if (i <= args.length - 2) {
                msg = String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(String.valueOf(msg))))))) + " ";
            }
        }
        return msg;
    }
}
