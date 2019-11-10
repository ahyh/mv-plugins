package com.yh.mv.vo;

import java.io.File;

public class FileCodeSumVo {

    private String filePath;

    private File file;

    private long sum;

    public FileCodeSumVo() {
    }

    public FileCodeSumVo(String filePath, File file, long sum) {
        this.filePath = filePath;
        this.file = file;
        this.sum = sum;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
