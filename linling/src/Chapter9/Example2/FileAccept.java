package Chapter9.Example2;

import java.io.FilenameFilter;
import java.io.File;

public class FileAccept implements FilenameFilter {  //实现FilenameFilter接口
    private String extendName;   //extendName 存储需要匹配的文件扩展名

    public void setExtendName(String s) {   //设置要匹配的文件扩展名
       extendName="."+s;
    }

    public boolean accept(File dir,String name) { //重写接口中的方法,判断给定的文件名是否以指定的扩展名结尾。
       return name.endsWith(extendName);
    }
}
