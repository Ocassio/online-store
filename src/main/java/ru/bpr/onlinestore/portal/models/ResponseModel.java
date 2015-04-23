package ru.bpr.onlinestore.portal.models;

import java.io.Serializable;

public class ResponseModel implements Serializable
{
    private boolean success;
    private Object data;
    private String error;

    public ResponseModel()
    {

    }

    public ResponseModel(boolean success)
    {
        this.success = success;
    }

    public ResponseModel(boolean success, String error)
    {
        this.success = success;
        this.error = error;
    }

    public ResponseModel(boolean success, Object data)
    {
        this.success = success;
        this.data = data;
    }

    public ResponseModel(boolean success, Object data, String error)
    {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }
}
