package login.georgie.com.haoapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import login.georgie.com.haoapp.Model.Order;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="HaoAppDB";
    private static final int DB_VER=1;
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Order> getCarts()
    {
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"HouseName","HouseID","NumberOfRooms","Price","Discount"};

        String sqlTable="OrderDetails";

        qb.setTables(sqlTable);

        Cursor c =qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result=new ArrayList<>();
        if(c.moveToFirst())
        {
            do {
                result.add(new Order(c.getString(c.getColumnIndex("HouseID")),
                        c.getString(c.getColumnIndex("HouseName")),
                        c.getString(c.getColumnIndex("NumberOfRooms")),
                        c.getString(c.getColumnIndex("Price")),
                        c.getString(c.getColumnIndex("Discount"))
                ));

            }while (c.moveToNext());
        }
        return result;
    }
    public void addToCart(Order order){
        SQLiteDatabase db = getReadableDatabase();
        String query=String.format("INSERT INTO OrderDetails(HouseID,HouseName,NumberOfRooms,Price,Discount) VALUES ('%s','%s','%s','%s','%s');",
                order.getHouseID(),
                order.getHouseName(),
                order.getNumberOfRooms(),
                order.getPrice(),
                order.getDiscount());


        db.execSQL(query);
    }

    public void clearCart(){
        SQLiteDatabase db = getReadableDatabase();
        String query=String.format("DELETE FROM OrderDetails");
        db.execSQL(query);
    }
}
