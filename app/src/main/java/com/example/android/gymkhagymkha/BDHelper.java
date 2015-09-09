package com.example.android.gymkhagymkha;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {

	private static final String BD_NAME = "gymkhagymkha.sqlite";
	private static final int BD_VERSION = 1;
	
	public BDHelper(Context context) {
		super(context, BD_NAME, null, BD_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
						
		db.execSQL(BDManager.CREATE_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS agenda"); 
		this.onCreate(db);
	}

}
