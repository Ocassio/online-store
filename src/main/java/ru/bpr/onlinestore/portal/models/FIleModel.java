package ru.bpr.onlinestore.portal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"bytes"})
public class FIleModel
{
    private String fileName;
    private String fileType;

    private byte[] bytes;

    public FIleModel()
    {
    }

    public FIleModel(String fileName, String fileType, byte[] bytes)
    {
        this.fileName = fileName;
        this.fileType = fileType;
        this.bytes = bytes;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileType()
    {
        return fileType;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public void setBytes(byte[] bytes)
    {
        this.bytes = bytes;
    }
}
