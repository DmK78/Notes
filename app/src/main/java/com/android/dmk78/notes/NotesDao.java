package com.android.dmk78.notes;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes ORDER BY dayOfWeek DESC")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNote (Note note);

    @Delete
    void deletNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNotes();
}
