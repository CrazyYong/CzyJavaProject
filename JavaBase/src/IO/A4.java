package IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;


/**
 * boolean file.exists() //文件是否存在

 boolean file.isFile() //是否是文件

 boolean file.isDirectory() //是否是目录

 boolean file.isHidden()   //是否隐藏（windows上可以设置某个文件是否隐藏）

 boolean file.isAbsolute() //是否为绝对路径

 boolean file.canRead()  //是否可读

 boolean file.canWrite() //是否可写

 boolean file.canExecute()  //是否可执行
 */

/**
 * 获取文件的信息
 * String file.getName() //获取文件的名字，只是名字，没有路径

 String file.getParent() //获取父目录的绝对路径，返回值是一个字符串。如果文件有父目录，那么返回父目录的绝对路径，(比如：`E:\cat`) , 如果文件本身就在磁盘的根目录，那么返回磁盘的路径，(比如:`E:\`)。

 File file.getParentFile() //获取父文件，返回值是一个File对象。

 long time = file.lastModified() ; //返回文件最后一次修改的时间
 Date dt = new Date(time);

 boolean renameTo(File file) //文件命名

 long file.length() //返回文件的大小，单位字节

 boolean file.delete() //删除文件

 String[] file.list() //获取该目录下的所有的文件的名字。如果`file`为文件，返回值为`null`,在使用时记得判空；但是如果`file`为目录，那么返回这个目录下所有文件的名字，只是名字，不含路径；如果`file`是一个空目录，返回一个长度为0的数组；从上面的结果可以看出，`list()` 方法，只是对`file`为目录时有效，当`file`为一个文件的时候，该方法毫无意义。

 File[] file.listFiles() //获取该目录下的所有的文件。如果`file`为文件，返回值为`null`,在使用时记得判空；但是如果`file`为目录，那么返回这个目录下所有的文件 ；如果`file`是一个空目录，返回一个长度为0的数组；从上面的结果可以看出，`listFiles()` 方法，只是对`file`为目录时有效，当`file`为一个文件的时候，该方法毫无意义。
 */

public class A4 {
    public static void main(String[] args){
        createThree();

        String filePath = "F:/" ;
        File file = new File( filePath ) ;
//        getFile(file);
//        getFileByFilter(file);
        getFileByFilterPicture(file);


    }

    /**
     * 构造函数1
     */
    private void createOne(){
        String filePath1 = "D:/cat.png" ;//绝对路径
        File file = new File( filePath1 ) ;

    }

    /**
     * 构造函数2
     */
    private void createTwo(){
        String parentFilePath = "E:/cat" ;

        String childFilePath = "small_cat.txt" ;//相对路径

//创建parentFile文件
        File parentFile = new File( parentFilePath ) ;
        parentFile.mkdir() ;

//如果parentFile不存在，就会报异常
        File file = new File( parentFilePath  , childFilePath ) ;
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造函数3
     */
    private static void createThree(){
        String parentFilePath = "D:/cat" ;
        //构造父文件
        File parent = new File( parentFilePath ) ;
        parent.mkdir();

        //如果parent文件不存在 就会报异常
        File file = new File(parent,"small_cat.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取该文件夹下的文件的名字
        String[] names=parent.list();

        for(String name:names){
            System.out.println("name:"+name);
        }

        File[] files = parent.listFiles();
        for(File file1:files){
            System.out.println("file:"+file1.getAbsolutePath());
        }
    }

    /**
     *扫描F盘所有的文件
     * @param file
     */
    private static void getFile(File file){
        File[] files = file.listFiles();
        for (File f:files){
            if(f.isHidden())continue;
            if(f.isDirectory()){
                getFile(f);
            }else {
                System.out.println( f.getAbsolutePath()  + "  " + f.getName() );
            }
        }
    }

    /**
     * file.list(FilenameFilter filter) ;

       file.listFiles( FilenameFilter filter) ;

        file.listFiles(FileFilter filter)
     * 带过滤功能的扫描
     * @param file
     */
    private static  void getFileByFilter(File file){
        MyFileFilter myFileFilter=new MyFileFilter();
        File[] files =file.listFiles(myFileFilter);
        for(File f:files){
            if(f.isHidden()) continue;
             System.out.println(f.getAbsolutePath());
        }
    }

    /**
     * 过滤文件名
     * 扫描出指定路径的所有图片
     * @param file
     */
    private static void getFileByFilterPicture( File file ){
        MyFilenameFilter myFileFilter = new MyFilenameFilter( ".png") ;

        File[] files = file.listFiles( myFileFilter ) ;
        for( File f : files ){
            if ( f.isHidden() ) continue ;

            System.out.println( f.getAbsolutePath() );
        }
    }

    /**
     * FileFilter是io包里面的一个接口，从名字上可以看出，这个类是文件过滤功能的。
       需要重写accept方法
     */
    static class MyFileFilter implements FileFilter{
        MyFileFilter(){

        }

//pathname：文件的绝对路径+ 文件名 , 比如：F:\安来宁 - 难得.mp3  ， 或者： F:\文件夹1
        @Override
        public boolean accept(File pathname) {
            if(pathname.isDirectory()){
                return true;
            }
            return false;
        }
    }


    /**
     * FilenameFilter
     FileFilter是io包里面的一个接口，从名字上可以看出，这个类是文件名字过滤功能的。
     需要重写里面的accept方法。
     */
    static class MyFilenameFilter implements FilenameFilter {
        //type为需要过滤的条件，比如如果type=".jpg"，则只能返回后缀为jpg的文件
        private String type;
        MyFilenameFilter( String type){
            this.type = type ;
        }

        @Override
        public boolean accept(File dir, String name) {
            //dir表示文件的当前目录，name表示文件名；
            return name.endsWith(type) ;
        }

    }
}
