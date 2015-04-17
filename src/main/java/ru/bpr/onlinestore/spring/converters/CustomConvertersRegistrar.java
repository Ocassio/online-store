package ru.bpr.onlinestore.spring.converters;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

public class CustomConvertersRegistrar implements InitializingBean
{
    @Autowired
    private GenericConversionService conversionService;

    private Set<?> converters;

    /**
     * Configure the set of custom converter objects that should be added:
     * implementing {@link org.springframework.core.convert.converter.Converter},
     * {@link org.springframework.core.convert.converter.ConverterFactory},
     * or {@link org.springframework.core.convert.converter.GenericConverter}.
     */
    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ConversionServiceFactory.registerConverters(this.converters, this.conversionService);
    }
}
