package com.kamus.android.app;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseManager {
	private static final String ROW_ID = "_id";
	private static final String ROW_INDO = "indonesia";
	private static final String ROW_JAWA = "jawa";
	private static final String NAMA_DB = "kamus";
	private static final String NAMA_TABEL = "tb_kamus";
	private static final int DB_VERSION = 1;
	
	private static final String CREATE_TABLE = "create table "+ NAMA_TABEL+ " (" + ROW_ID + " integer PRIMARY KEY autoincrement, "+ ROW_INDO+ " text,"+ ROW_JAWA + " text)";
	
	private final Context context;
	private DatabaseOpenHelper dbHelper;
	private SQLiteDatabase db;
	
	public DatabaseManager(Context ctx){
		this.context = ctx;
		dbHelper = new DatabaseOpenHelper(ctx);
		db = dbHelper.getWritableDatabase();
	}
	
	private static class DatabaseOpenHelper extends SQLiteOpenHelper{
		public DatabaseOpenHelper(Context context){
			super(context,NAMA_DB,null,DB_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db){
			db.execSQL(CREATE_TABLE);
			ContentValues values = new ContentValues();
			values.put(ROW_INDO,"Makan");
			values.put(ROW_JAWA, "Mangan");
			db.insert(NAMA_TABEL, null, values);
			values.put(ROW_INDO, "Minum");
			values.put(ROW_JAWA, "Ngombe");
			db.insert(NAMA_TABEL,null,values);
			values.put(ROW_INDO, "Ketawa");
			values.put(ROW_JAWA, "Ngguyu");
			db.insert(NAMA_TABEL, null, values);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){
			db.execSQL("DROP TABLE IF EXISTS "+NAMA_DB);
			onCreate(db);
		}
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public void addKamus(String nama, String hobi){
		ContentValues values = new ContentValues();
		values.put(ROW_INDO, nama);
		values.put(ROW_JAWA, hobi);
		
		try{
			db.insert(NAMA_TABEL, null, values);
		} catch(Exception e){
			Log.e("DB_ERROR", e.toString());
			e.printStackTrace();
		}
	}
	
	public ArrayList<ArrayList<Object>> ambilSemuaBaris(){
		ArrayList<ArrayList<Object>> dataArray = new ArrayList<ArrayList<Object>>();
		Cursor cur;
		try{
			cur = db.query(NAMA_TABEL, new String[] {ROW_INDO,ROW_JAWA}, null, null, null, null, null);
			cur.moveToFirst();
			if(!cur.isAfterLast()){
				do{
					ArrayList<Object> dataList = new ArrayList<Object>();
					dataList.add(cur.getString(0));
					dataList.add(cur.getString(1));
					dataArray.add(dataList);
					Log.e("data", cur.getString(0));
					Log.e("data", cur.getString(1));
				} while(cur.moveToNext());
			}
		}catch(Exception e){
			e.printStackTrace();
			Log.e("DB_Error", e.toString());
			Toast.makeText(context, "gagal ambil semua baris: "+e.toString(), Toast.LENGTH_SHORT).show();
		}
		return dataArray;
	}
	
	public ArrayList<Object> terjemahkan(String in){
		ArrayList<Object> arrbaris = new ArrayList<Object>();
		Cursor cursor;
		try{
			cursor = db.rawQuery("SELECT * FROM "+NAMA_TABEL+" WHERE "+ROW_INDO+" LIKE '%"+in+"%'", null);
			cursor.moveToFirst();
			if(!cursor.isAfterLast()){
				do{
					arrbaris.add(cursor.getLong(0));
					arrbaris.add(cursor.getString(1));
					arrbaris.add(cursor.getString(2));
				}while(cursor.moveToNext());
				String r = String.valueOf(arrbaris);
				Toast.makeText(context, "haha"+r, Toast.LENGTH_SHORT).show();
			}
		} catch(Exception e){
			e.printStackTrace();
			Log.e("error",e.toString());
			Toast.makeText(context, "hhii"+e.toString(), Toast.LENGTH_SHORT).show();
		}
		return arrbaris;
	}
}