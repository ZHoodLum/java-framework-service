package advanced.clipboardCopydemo;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static advanced.clipboardCopydemo.ForeachFileWork.writeContent;

/**
 * @author：ZDY
 * @Date：Created on 2021/6/24 23:14
 * @Description:
 */
public class MainFor {
    static AtomicLong copyIndex = new AtomicLong(0);
    static int count = 0;
    static String lastcontent = "";
    static int num = 0;

    public static void main(String[] args) {
        for (; ; ) {
//            if (copyIndex.get() % 100 == 0) {
//                System.out.println("拷貝了這麽多個文件： " + copyIndex.get());
//            }
            String lines = "";
            List<String> lineList = null;
            try {
                lines = ClipboardTools.getClipboardString();
                lineList = Splitter.on("/r/n").splitToList(lines);

                if (lastcontent.equals(lines)) {
                    count++;
                } else {
                    count = 0;
                }
                lastcontent = lines;
                if (count > 10) {
                    break;
                }
                System.out.println("第" + num++ + "文件  路径：" + lineList.get(0));
                if (lineList.size() >= 2) {
                    writeContent(lineList.get(0), lineList.subList(1, lineList.size()));
                }
            } catch (Exception e) {
                System.out.println("文件獲取内容失敗  路径：" + lineList.get(0));
            }
        }
    }
}
