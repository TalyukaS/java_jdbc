package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Добавление записи в базу
        Db db = new Db();
        try {
            db.insertArticles("5 Статья", "А это пятая статья самого Стаса", "9.01.2021", "Stas");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
