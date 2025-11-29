package com.interface_.DB;

public class OracleDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("connect oracle....");
    }

    @Override
    public void close() {
        System.out.println("close oracle....");
    }
}
