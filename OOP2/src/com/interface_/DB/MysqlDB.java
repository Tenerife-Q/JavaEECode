package com.interface_.DB;

public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("connect mysql....");
    }

    @Override
    public void close() {
        System.out.println("close mysql....");
    }
}
