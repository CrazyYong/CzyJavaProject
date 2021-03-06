package IO;

import java.io.*;

/**
 * Created by czy on 2018/7/30.
 * BufferReader BufferWriter
 */
public class A6 {
    public static void main(String[] args){
        String filePath="F:/123.txt";
        String filePath2="F:/abc.txt";

        File file=new File(filePath);
        File file2=new File(filePath2);
        copyFile(file,file2);
    }

    private static void copyFile(File oldFile,File newFile){
        Reader reader=null;
        BufferedReader bufferedReader=null;

        Writer writer=null;
        BufferedWriter bufferedWriter=null;

        try {
            reader=new FileReader(oldFile);
            bufferedReader=new BufferedReader(reader);

            writer=new FileWriter(newFile);
            bufferedWriter=new BufferedWriter(writer);

            String result=null;//每次读取一行的内容
            while((result=bufferedReader.readLine())!=null){
                bufferedWriter.write(result);//把内容写入文件
                bufferedWriter.newLine();//换行，result是一行数据,所以每写一行就要换行
            }
            bufferedWriter.flush();//强制把数组内容写入文件

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();//关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bufferedReader.close();//关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
