package com.example.bddapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.openaidandroidfeatures.Game

class Bdd (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DB_NAME,factory, DB_VERSION ){
    override fun onCreate(db: SQLiteDatabase) {
        var query = "CREATE TABLE "+TABLE_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT, score INTEGER, money INTEGER)"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE GAME;")
        onCreate(db)
    }

    fun insertGames(game: Game){
        var cvGames = ContentValues()
        cvGames.put("score",game.score)
        cvGames.put("money",game.money)
        var db = this.writableDatabase
        db.insert(TABLE_NAME,null,cvGames)
    }

    @SuppressLint("Range")
    fun getScore():MutableList<Game>{
        var resultat = mutableListOf<Game>()
        var db = this.readableDatabase
        var cur = db.rawQuery("SELECT * FROM Game",null,null)
        if(cur.moveToFirst()){
            do{
                var G = Game(
                    cur.getInt(cur.getColumnIndex("score")),
                )
                resultat.add(G)
            }while (cur.moveToNext())
        }
        return resultat
    }

    companion object{
        val TABLE_NAME = "GAME"
        val DB_NAME = "bdd_game"
        val DB_VERSION = 1
    }
}