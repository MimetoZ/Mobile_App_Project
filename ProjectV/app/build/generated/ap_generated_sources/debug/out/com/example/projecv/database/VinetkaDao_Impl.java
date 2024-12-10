package com.example.projecv.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projecv.modles.Vinetki;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VinetkaDao_Impl implements VinetkaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Vinetki> __insertionAdapterOfVinetki;

  private final SharedSQLiteStatement __preparedStmtOfDeleteVinetka;

  private final SharedSQLiteStatement __preparedStmtOfUpdateVinetka;

  public VinetkaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVinetki = new EntityInsertionAdapter<Vinetki>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `vinetki` (`id`,`vinetkaNumber`,`carClass`,`emissionClass`,`startDate`,`endDate`,`sum`,`status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Vinetki value) {
        stmt.bindLong(1, value.getId());
        if (value.getVinetkaNumber() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getVinetkaNumber());
        }
        if (value.getCarClass() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCarClass());
        }
        if (value.getEmissionClass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmissionClass());
        }
        if (value.getStartDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStartDate());
        }
        if (value.getEndDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEndDate());
        }
        if (value.getSum() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSum());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStatus());
        }
      }
    };
    this.__preparedStmtOfDeleteVinetka = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM vinetki WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateVinetka = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE vinetki SET vinetkaNumber = ?, carClass = ?, emissionClass = ?,startDate = ?, endDate = ?,sum = ?, status = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertContact(final Vinetki vinetki) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfVinetki.insert(vinetki);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteVinetka(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteVinetka.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteVinetka.release(_stmt);
    }
  }

  @Override
  public void updateVinetka(final int id, final String vinetkaNumber, final String carClass,
      final String emissionClass, final String startDate, final String endDate, final String sum,
      final String status) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateVinetka.acquire();
    int _argIndex = 1;
    if (vinetkaNumber == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, vinetkaNumber);
    }
    _argIndex = 2;
    if (carClass == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, carClass);
    }
    _argIndex = 3;
    if (emissionClass == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, emissionClass);
    }
    _argIndex = 4;
    if (startDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, startDate);
    }
    _argIndex = 5;
    if (endDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, endDate);
    }
    _argIndex = 6;
    if (sum == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sum);
    }
    _argIndex = 7;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 8;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateVinetka.release(_stmt);
    }
  }

  @Override
  public List<Vinetki> getAllContacts() {
    final String _sql = "SELECT * FROM vinetki";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfVinetkaNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "vinetkaNumber");
      final int _cursorIndexOfCarClass = CursorUtil.getColumnIndexOrThrow(_cursor, "carClass");
      final int _cursorIndexOfEmissionClass = CursorUtil.getColumnIndexOrThrow(_cursor, "emissionClass");
      final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
      final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
      final int _cursorIndexOfSum = CursorUtil.getColumnIndexOrThrow(_cursor, "sum");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Vinetki> _result = new ArrayList<Vinetki>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Vinetki _item;
        _item = new Vinetki();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpVinetkaNumber;
        if (_cursor.isNull(_cursorIndexOfVinetkaNumber)) {
          _tmpVinetkaNumber = null;
        } else {
          _tmpVinetkaNumber = _cursor.getString(_cursorIndexOfVinetkaNumber);
        }
        _item.setVinetkaNumber(_tmpVinetkaNumber);
        final String _tmpCarClass;
        if (_cursor.isNull(_cursorIndexOfCarClass)) {
          _tmpCarClass = null;
        } else {
          _tmpCarClass = _cursor.getString(_cursorIndexOfCarClass);
        }
        _item.setCarClass(_tmpCarClass);
        final String _tmpEmissionClass;
        if (_cursor.isNull(_cursorIndexOfEmissionClass)) {
          _tmpEmissionClass = null;
        } else {
          _tmpEmissionClass = _cursor.getString(_cursorIndexOfEmissionClass);
        }
        _item.setEmissionClass(_tmpEmissionClass);
        final String _tmpStartDate;
        if (_cursor.isNull(_cursorIndexOfStartDate)) {
          _tmpStartDate = null;
        } else {
          _tmpStartDate = _cursor.getString(_cursorIndexOfStartDate);
        }
        _item.setStartDate(_tmpStartDate);
        final String _tmpEndDate;
        if (_cursor.isNull(_cursorIndexOfEndDate)) {
          _tmpEndDate = null;
        } else {
          _tmpEndDate = _cursor.getString(_cursorIndexOfEndDate);
        }
        _item.setEndDate(_tmpEndDate);
        final String _tmpSum;
        if (_cursor.isNull(_cursorIndexOfSum)) {
          _tmpSum = null;
        } else {
          _tmpSum = _cursor.getString(_cursorIndexOfSum);
        }
        _item.setSum(_tmpSum);
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item.setStatus(_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
