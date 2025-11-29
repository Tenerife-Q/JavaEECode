package com.interface_.DB;

public class Interface {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        test(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        test(oracleDB);
    }

    public static void test(DBInterface db){
        db.connect();
        db.close();
    }
}
