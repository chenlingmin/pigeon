package xyz.yishe.pigeon.common.bean;


import org.apache.commons.lang3.builder.ToStringBuilder;
import xyz.yishe.pigeon.common.converter.BeanConverter;

import java.io.Serializable;

/**
 * @author owen
 * @date 2018-12-11 2:30
 */
public class BaseBean implements BeanConverter, Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
