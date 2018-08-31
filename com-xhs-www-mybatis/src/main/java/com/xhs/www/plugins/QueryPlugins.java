package com.xhs.www.plugins;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;


import java.util.Properties;

/**
 * @author xuhan  build  2018/8/30
 */
@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class QueryPlugins implements Interceptor {

    private Properties properties = null;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(properties.getProperty("name"));
        System.out.println("拦截");
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
