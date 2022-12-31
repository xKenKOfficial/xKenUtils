package com.github.xKenKOfficial.Utils.Utils.All;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil
{
    public static void copy(final InputStream source, final File file) {
        try {
            final OutputStream out = new FileOutputStream(file);
            final byte[] buf = new byte[1024];
            int len = 0;
            while ((len = source.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            out.close();
            source.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
