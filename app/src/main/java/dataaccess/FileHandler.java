package dataaccess;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

/**
 * Created by VDARSSH on 5/30/2015.
 */
public class FileHandler {
    public void writeFile(Context context,String filename) throws IOException {
        filename = "hello_file";
        String string = "hello world!";

        FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        fos.write(string.getBytes());
        fos.close();
    }

    public String readFile(Context context,int resource) throws IOException {
        StringBuffer  fileBuffer=new StringBuffer("");

        InputStream fis = context.getResources().openRawResource(resource);
        int a=1;
        while(a>0){
            a=fis.read();
            fileBuffer.append((char)a);
        }

        fis.close();
        String result=new String(fileBuffer);

        return result;
    }
}
