import java.io.File;
import java.io.FileFilter;
//对FileFilter接口进行重写
public class MyFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if(pathname.isDirectory())
            return true;
        return pathname.getName().toLowerCase().endsWith(".txt");
    }

}