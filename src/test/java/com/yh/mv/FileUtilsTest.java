package com.yh.mv;

import com.yh.mv.utils.FileUtils;
import com.yh.mv.vo.FileCodeSumVo;
import org.junit.Test;

import java.io.File;

public class FileUtilsTest {

    @Test
    public void testFileUtils() throws Exception {
        String file = "D:\\myCode\\basessm\\src\\main\\java\\com\\yanhuan\\yhssm\\domain";
        long sum = 0L;
        FileCodeSumVo fileCodeSumVo = new FileCodeSumVo();
        fileCodeSumVo.setFile(new File(file));
        fileCodeSumVo.setSum(0L);
        FileUtils.getLineSum(fileCodeSumVo);
        System.out.println(fileCodeSumVo.getSum());
    }
}
