package advanced.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author：ZDY
 * @Date：Created on 2021/4/8 13:56
 * @Description:
 */
public class uploadFileFolder {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "\\src\\main\\resources\\IO\\test.txt");

        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
        }

//        Path path = Paths.get(projectPath + "\\src\\main\\resources\\IO\\Filecreate\\asda\\dsadas");
        Path path = Paths.get( "\\src");
        try {
            Path createPath = Files.createDirectories(path);
            System.out.println("创建的路径是" + createPath);
            String ver = "V1.1.1";
            File file2 = new File(createPath + File.separator + "test" + ver + ".txt");
            file2.createNewFile();
            System.out.println(file2.getAbsoluteFile());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
