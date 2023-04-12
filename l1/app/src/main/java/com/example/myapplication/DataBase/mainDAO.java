package com.example.myapplication.DataBase;


//import static java.nio.charset. .CodingErrorAction.REPLACE;
import static androidx.room.OnConflictStrategy.REPLACE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Models.Notes;

import java.util.List;

@Dao
public interface mainDAO {

    @Insert(onConflict = REPLACE)
    void insert (Notes notes);

    @Query("SELECT * FROM notes ORDER BY id DESC")//сортировка заметок от я до а DESC
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, nodes = :nodes WHERE id = :id")//обновить записи в таблице по id
    void update(int id, String title, String nodes);

    @Delete
    void delete (Notes notes);

}
