package ru.bpr.onlinestore.portal.exception;

public class ConvertModelException extends RuntimeException
{
    public ConvertModelException(Throwable cause)
    {
        super(cause);
    }

    public ConvertModelException(String message)
    {
        super(message);
    }

    public ConvertModelException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
