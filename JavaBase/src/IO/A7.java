package IO;

import java.io.*;

/**
 * 转换流InputStreamReader、OutputStreamWriter
 */
public class A7 {
    public static void main(String[] args){
        String filePath="F:/123.txt";
        String filePath2="F:/abc.txt";

        File file=new File(filePath);
        File file2=new File(filePath2);
        copyFile(file,file2);
    }

    private static void copyFile(File oldFile,File newFile){
        InputStream inputStream=null;
        InputStreamReader inputStreamReader=null;

        OutputStream outputStream=null;
        OutputStreamWriter outputStreamWriter=null;

        try {
            inputStream=new FileInputStream(oldFile);
            inputStreamReader=new InputStreamReader(inputStream);

            outputStream=new FileOutputStream(newFile);
            outputStreamWriter=new OutputStreamWriter(outputStream);

            int result=0;

            while ((result=inputStreamReader.read())!=-1){//一次只读一个字符
                System.out.println(result);
                outputStreamWriter.write(result);//一次只写一个字符
            }

            outputStreamWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( inputStreamReader != null ) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
