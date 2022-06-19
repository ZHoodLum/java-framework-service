package com.example.ikanalyzer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author：Zik
 * @Date：Created in 2020/9/9
 * @Description:
 */


public class getFilePath {
    @Test
    public void getFilePathTest() throws IOException {

        File dir = new File("");// 参数为空
        String projectPath2 = dir.getCanonicalPath();
        System.out.println("projectPath2==" + projectPath2);
    }
}
