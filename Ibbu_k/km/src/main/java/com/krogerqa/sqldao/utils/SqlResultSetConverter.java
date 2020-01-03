package com.krogerqa.sqldao.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class SqlResultSetConverter {
    public static String convertSqlResultSetToJson(ResultSet rs) {
        JsonArray json = new JsonArray();
        ResultSetMetaData rsmd;
        try {
            rsmd = rs.getMetaData();

            while (rs.next()) {
                int numColumns = rsmd.getColumnCount();
                JsonObject obj = new JsonObject();

                for (int i = 1; i < numColumns + 1; i++) {
                    String column_name = rsmd.getColumnName(i);

                    if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
                        obj.addProperty(column_name, (Number) rs.getArray(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
                        obj.addProperty(column_name,  rs.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
                        obj.addProperty(column_name, rs.getBoolean(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
                        obj.addProperty(column_name, (Number) rs.getBlob(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE ||
                        rsmd.getColumnType(i) == java.sql.Types.DECIMAL){
                        obj.addProperty(column_name, rs.getDouble(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
                        obj.addProperty(column_name, rs.getFloat(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
                        obj.addProperty(column_name, rs.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
                        if (rs.getNString(column_name)!=null)
                            obj.addProperty(column_name, rs.getNString(column_name));
                        else
                            obj.addProperty(column_name,"null");
                    } else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR ||
                            rsmd.getColumnType(i) == java.sql.Types.CHAR) {
                        obj.addProperty(column_name, rs.getString(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
                        obj.addProperty(column_name, rs.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
                        obj.addProperty(column_name, rs.getInt(column_name));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
                        obj.addProperty(column_name, String.valueOf(rs.getDate(column_name)));
                    } else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
                        obj.addProperty(column_name, String.valueOf(rs.getTimestamp(column_name)));
                    } else {
                        obj.addProperty(column_name, (Boolean) rs.getObject(column_name));
                    }
                }

                json.add(obj);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
