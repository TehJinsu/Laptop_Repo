package com.example.moviedb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MovieDb extends SQLiteOpenHelper {
    private static int dbVersion = 1;
    private static MovieDb movieDb;

    public static synchronized MovieDb getMovieDb(Context context) {
        if (movieDb == null) {
            movieDb = new MovieDb(context.getApplicationContext());
        }
        return movieDb;
    }

    private MovieDb(Context context) {
        super(context, "MovieDb", null, dbVersion);
    }

    //configure items such as enabling foreign keys
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    //if no database onCreate will be called
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createMovie = "create table Movie (" +
                "id integer primary key autoincrement," +
                "name varchar(50)," +
                "director varchar(50)," +
                "genre varchar(50)," +
                "release_year int," +
                "rating decimal (3,1))";
        db.execSQL(createMovie);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 2) {
            db.execSQL("alter table Movie add column plat_summary varchar(250)");
        }

        if (oldVersion < 3) {
            db.execSQL("alter table Movie add column screenwriter varchar(250)");
        }

        if (oldVersion < 4) {
            db.execSQL("create table Genre (int id primary key, genre varchar(50))");
        };
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select id, name, director, genre, release_year, rating from Movie", null
        );
        try {
            if (cursor.moveToFirst()) {
                do {
                    Movie movie = new Movie(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4),
                            cursor.getDouble(5));
                    movies.add(movie);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception ex) {
            Log.d("MovieDb", "Error in getAllMovies()");
        }
        finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return movies;
    }
}
