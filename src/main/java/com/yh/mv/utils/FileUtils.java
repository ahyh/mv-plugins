package com.yh.mv.utils;

import com.yh.mv.vo.FileCodeSumVo;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static void getLineSum(FileCodeSumVo vo) throws Exception {
        File file = vo.getFile();
        if (!file.isFile()) {
            File[] files = file.listFiles();
            for (File f : files) {
                vo.setFile(f);
                getLineSum(vo);
            }
        } else {
            long count = Files.lines(Paths.get(file.getAbsolutePath()), Charset.defaultCharset()).count();
            vo.setSum(vo.getSum() + count);
        }
    }
}
