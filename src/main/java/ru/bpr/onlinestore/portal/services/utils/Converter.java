package ru.bpr.onlinestore.portal.services.utils;


public interface Converter
{
    <T> T covert(Object source, Class<T> expected);
}
