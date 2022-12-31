package com.github.xKenKOfficial.Utils.Utils.All;

import java.util.ArrayList;
import java.util.List;

public class LoreUtil
{
    public static String fix(final String s)
    {
        return s.replaceAll("&", "§").replace(">>", "»").replace("<<", "«");
    }

    public static List<String> fixColors(final List<String> contents)
    {
        final List<String> cont = new ArrayList<String>();
        for (final String s : contents) {
            cont.add(fix(s));
        }
        return cont;
    }
}
