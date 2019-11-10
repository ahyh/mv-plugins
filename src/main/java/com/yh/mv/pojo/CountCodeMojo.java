package com.yh.mv.pojo;

import com.yh.mv.utils.FileUtils;
import com.yh.mv.vo.FileCodeSumVo;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * 统计java代码行数，分为源代码和testCode
 *
 * @author yanhuan
 */
@Mojo(name = "countCode", defaultPhase = LifecyclePhase.PACKAGE)
public class CountCodeMojo extends AbstractMojo {

    @Parameter(property = "path")
    private String path;

    @Parameter(property = "sourceDirectory")
    private String sourceDirectory;

    @Parameter(property = "testSourceDirectory")
    private String testSourceDirectory;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("sout path:" + path);
        System.out.println("sout sourceDirectory:" + sourceDirectory);
        System.out.println("sout testSourceDirectory:" + testSourceDirectory);
        try {
            long srcSum = 0L;
            FileCodeSumVo srcVo = new FileCodeSumVo(sourceDirectory, new File(sourceDirectory), srcSum);
            FileUtils.getLineSum(srcVo);
            System.out.println("file path:" + sourceDirectory + "sum code:" + srcVo.getSum());

            long testSum = 0L;
            FileCodeSumVo testVo = new FileCodeSumVo(testSourceDirectory, new File(testSourceDirectory), testSum);
            FileUtils.getLineSum(testVo);
            System.out.println("file path:" + testSourceDirectory + "sum code:" + testVo.getSum());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
