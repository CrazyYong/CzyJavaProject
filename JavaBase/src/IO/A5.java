package IO;

import java.io.*;

/**
 * Created by czy on 2018/7/30.
 * 复制文件
 * 嵌套缓冲流 BufferedInputStream BufferedOutputStream
 */
public class A5 {
    public static void main(String[] args) throws IOException {

        String filePath = "F:/123.png" ;
        String filePath2 = "F:/abc.png" ;
        File file = new File( filePath ) ;
        File file2 = new File( filePath2 ) ;
        copyFile( file , file2 );

    }

    public static void copyFile(File oldFile,File newFile){
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream =null;

        OutputStream outputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        try {
            //1,在InputStream上套一个BufferedInputStream
            inputStream=new FileInputStream(oldFile);
            bufferedInputStream = new BufferedInputStream(inputStream);
            //2,在Outputtream上套一个BufferedOutputStream
            outputStream=new FileOutputStream(newFile);
            bufferedOutputStream=new BufferedOutputStream(outputStream);


            byte[] b=new byte[1024];//表示一次最多度1kb的内容
            int length=0;//代表实际读取的字节数
            try {
                while ((length=bufferedInputStream.read(b))!=-1){
                    //length表示实际读取的字节数
                    bufferedOutputStream.write(b,0,length);
                }
                //缓冲区内容写入文件
                bufferedOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if( bufferedOutputStream != null ){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
