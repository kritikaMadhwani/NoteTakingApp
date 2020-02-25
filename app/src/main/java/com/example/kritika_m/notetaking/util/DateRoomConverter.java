package com.example.kritika_m.notetaking.util;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by kritika_m on 02/22/2020.
 */

public class DateRoomConverter {

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}
