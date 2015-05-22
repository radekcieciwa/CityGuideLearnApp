package com.bearddev.cityguide.model.vendors;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bearddev.cityguide.model.Place;
import com.bearddev.cityguide.model.Route;
import com.bearddev.cityguide.model.RoutePlace;
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

    private RuntimeExceptionDao<Place, Integer> placeDao;
    private RuntimeExceptionDao<Route, Integer> routeDao;
    private RuntimeExceptionDao<RoutePlace, Integer> routePlaceDao;

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

        DataGenerator.generatePlaces(this, 10);
        DataGenerator.generateRoutes(this, 4);
        DataGenerator.generatePlaceAssociationsForEachRoute(this, 4);
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
        if (placeDao == null) {
            placeDao = getRuntimeExceptionDao(Place.class);
        }

        return placeDao;
    }

    public RuntimeExceptionDao<Route, Integer> getRouteDao() {
        if (routeDao== null) {
            routeDao = getRuntimeExceptionDao(Route.class);
        }
        return routeDao;
    }

    public RuntimeExceptionDao<RoutePlace, Integer> getRoutePlaceDao() {
        if (routePlaceDao == null) {
            routePlaceDao = getRuntimeExceptionDao(RoutePlace.class);
        }
        return routePlaceDao;
    }

    @Override
    public void close() {
        super.close();
        placeDao = null;
        routeDao = null;
        routePlaceDao = null;
    }
}
