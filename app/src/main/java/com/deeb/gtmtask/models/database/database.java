package com.deeb.gtmtask.models.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.deeb.gtmtask.models.utils.Constants;

@Database(entities = {DataItem.class},version = 1)

public abstract class database extends RoomDatabase {
    public abstract DataDao dao();
    private static volatile database INSTANCE;

    public static database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            database.class, Constants.DATABASE_NAMME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
