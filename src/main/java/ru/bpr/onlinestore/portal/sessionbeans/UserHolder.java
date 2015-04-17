package ru.bpr.onlinestore.portal.sessionbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.bpr.onlinestore.portal.services.models.User;

@Component
@Scope(value = "globalSession", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserHolder
{
    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
