package com.hxgfk.sql;

import java.sql.*;

public class SQLStatementExecuter {
    private final Statement statement;
    private final Connection connection;

    public SQLStatementExecuter(DataBaseConnectionBridge bridge) throws SQLException {
        this.connection = bridge.getConnection();
        this.statement = this.connection.createStatement();
    }

    public ResultSet executeQuery(String command) throws SQLException {
        return this.statement.executeQuery(command);
    }

    public boolean execute(String command) throws SQLException{
        return this.statement.execute(command);
    }

    public Statement getStatement(){
        return this.statement;
    }

    public void close() throws SQLException {
        this.statement.close();
        this.connection.close();
    }
}
