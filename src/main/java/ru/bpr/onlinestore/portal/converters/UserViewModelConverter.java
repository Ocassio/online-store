package ru.bpr.onlinestore.portal.converters;

import org.springframework.core.convert.converter.Converter;
import ru.bpr.onlinestore.portal.models.UserViewModel;
import ru.bpr.onlinestore.portal.services.models.User;

public class UserViewModelConverter implements Converter<User, UserViewModel>
{
    @Override
    public UserViewModel convert(User source)
    {
        UserViewModel target = new UserViewModel();

        target.setId(Integer.toString(source.getId()));
        target.setEmail(source.getEmail());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setAddress(source.getAddress());

        return target;
    }
}
