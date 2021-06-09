package com.dmj.pool.datasource;

import com.github.houbb.thread.pool.util.DriverClassUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zd
 * @since 1.0.0
 */
public class UnPooledDataSource extends AbstractDataSourceConfig {

    @Override
    public Connection getConnection() throws SQLException {
        DriverClassUtil.loadDriverClass(super.driverClass, super.jdbcUrl);

        return DriverManager.getConnection(super.getJdbcUrl(),
                super.getUser(), super.getPassword());
    }

}
