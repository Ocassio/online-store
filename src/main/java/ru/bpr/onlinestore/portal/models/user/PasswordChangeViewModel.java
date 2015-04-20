package ru.bpr.onlinestore.portal.models.user;

public class PasswordChangeViewModel
{
    private String password;
    private String oldPassword;

    public PasswordChangeViewModel()
    {
    }

    public PasswordChangeViewModel(String password, String oldPassword)
    {
        this.password = password;
        this.oldPassword = oldPassword;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getOldPassword()
    {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }
}
