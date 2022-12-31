package com.github.xKenKOfficial.Utils.Utils.All;

public class ChatUtil
{
    public static String fixColor(final String msg) {
        return msg.replaceAll("&", "§").replace(">>", "»").replace("<<", "«").replace("{N}", "\n");
    }
}
