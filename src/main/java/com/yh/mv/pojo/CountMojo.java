package com.yh.mv.pojo;

import com.yh.mv.log.LoggerBridge;
import com.yh.mv.log.MavenLoggerBridge;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * 统计项目目录下文件总数量
 *
 * @author yanhuan
 */
@Mojo(name = "count", defaultPhase = LifecyclePhase.PACKAGE)
public class CountMojo extends AbstractMojo {

    private final LoggerBridge logger = new MavenLoggerBridge(this, false);

    @Parameter(property = "path")
    private String path;

    private int fileSum;

    private int dirSum;

    private int javaSum;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("sout path:" + path);
        System.out.println("sout sum:" + countFile(path));
    }

    private String countFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    fileSum += 1;
                    String name = f.getName();
                    if (name.endsWith(".java")) {
                        javaSum += 1;
                    }
                } else {
                    dirSum += 1;
                    countFile(f.getAbsolutePath());
                }
            }
        }
        return "fileSum:" + fileSum + ", dirSum:" + dirSum + ", javaSum:" + javaSum;
    }

}
