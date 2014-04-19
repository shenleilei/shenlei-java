package com.amaker.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings.System;
/**
 * 
 * @author 郭宏志
 * 数据库工具类
 */
public class DBHelper extends SQLiteOpenHelper{
    // 数据库名称常量
    private static final String DATABASE_NAME = "Wireless_db";
    // 数据库版本常量
    private static final int DATABASE_VERSION = 2;
    // 表名称常量
    public static final String TABLES_TableTbl = "TableTbl";
    public static final String TABLES_MenuTbl = "MenuTbl";
	// 构造方法
	public DBHelper(Context context) {
		// 创建数据库
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
	}

	// 创建时调用
	public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLES_TableTbl + " ("
                + Tables._ID + " INTEGER PRIMARY KEY,"
                + Tables.NUM + " TEXT,"
                + Tables.FLAG + " TEXT,"
                + Tables.DESCRIPTION + " TEXT"
                + ");");
        
        db.execSQL("CREATE TABLE " + TABLES_MenuTbl + " ("
                + Menus._ID + " INTEGER PRIMARY KEY,"
                + Menus.TYPE_ID + " INTEGER,"
                + Menus.NAME + " TEXT,"
                + Menus.PRICE + " INTEGER,"
                + Menus.PIC + " TEXT,"
                + Menus.REMARK + " TEXT"
                + ");");
	}

	// 版本更新时调用
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 删除表
		db.execSQL("DROP TABLE IF EXISTS TableTbl");
		onCreate(db);
		java.lang.System.out.print("DROP TABLE IF EXISTS TableTbl");
		db.execSQL("DROP TABLE IF EXISTS MenuTbl");
		onCreate(db);
		java.lang.System.out.print("DROP TABLE IF EXISTS MenuTbl");
	}

}
