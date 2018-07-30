package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A3 {
    public static void main(String[] args){
        A3 a3 =new A3();

        //电脑d盘中的cat.png 图片的路径
        String filePath1 = "D:/abc.txt" ;

        //电脑e盘中的cat.png 图片的路径
        String filePath2 = "D:/abcnew.txt" ;

        //复制文件
        a3.copyFile( filePath1 , filePath2 );

    }

    private void copyFile(String filePath_old,String filePath_new){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            //1.根据path路径实例化一个输入流的对象
            fis=new FileInputStream(filePath_old);
            //2.返回这个输入流中可以被读的剩下的bytes字节的估计值
            int size=fis.available();
            //3.根据输入流中的字节数创建byte数组
            byte[] array = new byte[size];
            //4.把数据读取到数组中
            fis.read(array);
            //5根据文件路径创建输出流
            fos=new FileOutputStream(filePath_new);
            //6把byte数组输出
            fos.write(array);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
