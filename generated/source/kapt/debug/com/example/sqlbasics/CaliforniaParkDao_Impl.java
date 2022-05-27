package com.example.sqlbasics;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CaliforniaParkDao_Impl implements CaliforniaParkDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CaliforniaPark> __insertionAdapterOfCaliforniaPark;

  public CaliforniaParkDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCaliforniaPark = new EntityInsertionAdapter<CaliforniaPark>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `park` (`id`,`name`,`city`,`area_acres`,`park_visitors`,`established`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CaliforniaPark value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getCity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCity());
        }
        stmt.bindLong(4, value.getAcres());
        if (value.getVisitors() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getVisitors());
        }
        stmt.bindLong(6, value.getEstablished());
        if (value.getType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getType());
        }
      }
    };
  }

  @Override
  public Object insertAll(final List<CaliforniaPark> parks,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCaliforniaPark.insert(parks);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<CaliforniaPark>> continuation) {
    final String _sql = "SELECT * FROM park";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CaliforniaPark>>() {
      @Override
      public List<CaliforniaPark> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfAcres = CursorUtil.getColumnIndexOrThrow(_cursor, "area_acres");
          final int _cursorIndexOfVisitors = CursorUtil.getColumnIndexOrThrow(_cursor, "park_visitors");
          final int _cursorIndexOfEstablished = CursorUtil.getColumnIndexOrThrow(_cursor, "established");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final List<CaliforniaPark> _result = new ArrayList<CaliforniaPark>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CaliforniaPark _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final int _tmpAcres;
            _tmpAcres = _cursor.getInt(_cursorIndexOfAcres);
            final Integer _tmpVisitors;
            if (_cursor.isNull(_cursorIndexOfVisitors)) {
              _tmpVisitors = null;
            } else {
              _tmpVisitors = _cursor.getInt(_cursorIndexOfVisitors);
            }
            final long _tmpEstablished;
            _tmpEstablished = _cursor.getLong(_cursorIndexOfEstablished);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _item = new CaliforniaPark(_tmpId,_tmpName,_tmpCity,_tmpAcres,_tmpVisitors,_tmpEstablished,_tmpType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
