package ru.bpr.onlinestore.portal.offers.models;

import java.io.Serializable;

public class ResponseModel implements Serializable
{
    private boolean success;
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

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
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
