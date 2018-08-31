package com.xhs.www.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xuhan  build  2018/8/30
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
//@MappedTypes(String.class)
public class TestTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter+"by type handler");
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        System.out.println(columnName+"getNullableResult");

        return rs.getString(columnName)+"by result type handler";
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println(columnIndex+"1111111");
        return rs.getString(columnIndex);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println(columnIndex+"1111111");
        return cs.getString(columnIndex);
    }
}
