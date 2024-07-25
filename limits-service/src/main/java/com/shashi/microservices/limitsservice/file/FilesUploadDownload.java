package com.shashi.microservices.limitsservice.file;

public class FilesUploadDownload {
    private String filename;
    private Double fileSize;

    public FilesUploadDownload(String filename, Double fileSize) {
        this.filename = filename;
        this.fileSize = fileSize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FilesUploadDownload{" +
                "filename='" + filename + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
