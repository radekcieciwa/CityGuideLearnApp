package com.bearddev.cityguide.model.vendors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bearddev.cityguide.model.Place;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by radek on 13.05.15.
 */
public class ORMLiteHelper extends OrmLiteSqliteOpenHelper
{
    private static final String DB_NAME = "city_guide.db";
    private static final int DB_VERSION = 1;

    private RuntimeExceptionDao<Place, Integer> simpleRuntimeDao;

    public ORMLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Place.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DataGenerator.generateEntries(getPlaceDao(), 10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Place.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RuntimeExceptionDao<Place, Integer> getPlaceDao() {
        if (simpleRuntimeDao == null) {
            simpleRuntimeDao = getRuntimeExceptionDao(Place.class);
        }

        return simpleRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        simpleRuntimeDao = null;
    }
}
