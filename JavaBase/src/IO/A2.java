package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class A2 {
    public static void main(String[] args){
        A2 a2 =new A2();
        //电脑d盘中的abc.txt文档
        String filePath="D:/abc.txt";
        //要写入的内容
        String content="今天是2018/7/29";

        a2.writeFile(filePath,content);
    }

    private void writeFile(String filePath,String content){
        FileOutputStream fos=null;
        try {
            //1、根据文件路径创建输出流
            fos=new FileOutputStream(filePath);
            //2、把string转换为byte数组;
            byte[] array=content.getBytes();
            //3、把byte数组输出
            fos.write(array);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
