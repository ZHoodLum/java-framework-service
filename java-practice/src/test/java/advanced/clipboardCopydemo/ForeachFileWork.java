package advanced.clipboardCopydemo;

import com.google.common.base.Joiner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * @className: ForeachFiles* @description:
 * @author: caoyangjie
 * @date: 2021/6/24
 *
 */
public class ForeachFileWork {
    public static void main(String[] args) throws Exception {
        List<String> ignoreFile = Arrays.asList("\\img\\","\\fonts\\", ".gif", ".ttf", ".pptx", ".ico", "\\.", "\\.git\\", "\\target\\", ".iml", ".jar", "\\test\\", "sonar-project.properties", ".zip", ".gz", ".so", ".iml", ".png", ".jpg", ".bmp", ".xlsx", ".xls", ".docx", ".doc", "ESBlock", ".log", ".out", ".eot");
        //源文件目录
        String filePath = "E:\\eclipse-ide-oneplus\\uploadFile";
        //copy到哪个目录
        String homePath = "D:\\IdeaProject\\smart\\sourcecopy\\uploadFile";
        File dir = new File(filePath);
        System.out.println(getFileList(filePath, new ArrayList<>()).stream().filter(file -> !ignore(file, ignoreFile)).collect(Collectors.toList()).size());
        getFileList(filePath, new ArrayList<>()).stream().filter(file -> !ignore(file, ignoreFile)).forEach(file -> {
            String writeFilePath = file.getAbsolutePath().replace(filePath, homePath);
            List<String> readLines = null;
            try {
                readLines = Files.readAllLines(file.toPath());
            } catch (IOException e) {
                readLines = new ArrayList<>();
            } finally {
            }
            readLines.add(0, writeFilePath);
            try {
                ClipboardTools.setClipboardString(Joiner.on("/r/n").join(readLines));
                System.out.println("文件路径： " + writeFilePath);
            } catch (Exception e) {
                System.out.println("文件过大跳过：" + writeFilePath);
            }
            String lines = ClipboardTools.getClipboardString();
//            String lines = "";
//            List<String> lineList = Splitter.on("/r/n").splitToList(lines);
//            if (lineList.size() >= 2) {
//                try {
//                    writeContent(lineList.get(0), lineList.subList(1, lineList.size()));
//                } catch (IOException e) {
//                }
//            }
        });
    }


    public static List<File> getFileList(String strPath, List<File> filelist) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath(), filelist);
                } else {
                    filelist.add(files[i]);
                }
            }

        }
        return filelist;
    }

    static boolean ignore(File file, List<String> ignore) {
        AtomicBoolean returnValue = new AtomicBoolean(false);
        ignore.forEach(it -> {
            returnValue.set(returnValue.get() || file.getAbsolutePath().contains(it) || file.getAbsolutePath().endsWith(it));
        });
        return returnValue.get();
    }

    static void writeContent(String realPath, List<String> allLine) throws IOException {
        new File(realPath.substring(0, realPath.lastIndexOf(File.separator))).mkdirs();
        File file = new File(realPath);
        if (file.exists()) {
            file.delete();
            System.out.println("刪除文件" + file.getName());
        }
        Files.write(file.toPath(), allLine, StandardOpenOption.CREATE_NEW);

        System.out.println("successed-----");

    }
}
