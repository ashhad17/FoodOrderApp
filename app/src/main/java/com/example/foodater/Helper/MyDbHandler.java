package com.example.foodater.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodater.Domain.FoodDomain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context,Params.DB_NAME1,null,Params.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//            db.execSQL("DROP TABLE "+Params.TABLE_NAME+" ;");

            db.execSQL("CREATE TABLE " + Params.TABLE_ORDER + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.TABLE_CART + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_ITMNUM + " INTEGER )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_PIZZA + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_POPULAR + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_BURGER + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_DRINK + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_HOTDOG + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            db.execSQL("CREATE TABLE " + Params.CATEGORY_DONUT + "("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY," + Params.KEY_TITLE
                    + " TEXT, " + Params.KEY_FEE + " TEXT ,"+ Params.KEY_PIC + " TEXT, " + Params.KEY_DISC + " TEXT )");
            System.out.println("Tables create");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addPizza(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_PIZZA, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();


    }
    public void addOrders(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
//        values.put(Params.KEY_ORDNUM, food.getNumberInCart());


        db.insert(Params.TABLE_ORDER, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();
    }
    public void addBurger(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_BURGER, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();


    }
    public void addHotDog(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_HOTDOG, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();


    }
    public void addDrink(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_DRINK, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();


    }
    public void addDonut(FoodDomain food){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_DONUT, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();


    }

    public ArrayList<FoodDomain> getAllPizza(){
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_PIZZA;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public ArrayList<FoodDomain> getAllBurgur(){
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_BURGER;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public ArrayList<FoodDomain> getAllHotdog(){
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_HOTDOG;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public ArrayList<FoodDomain> getAllDrink(){
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_DRINK;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public ArrayList<FoodDomain> getAllDonut(){
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_DONUT;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public List<FoodDomain> getAllPopular(){
        List<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.CATEGORY_POPULAR;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
                food.setDescription(cursor.getString(4));
                foodList.add(food);
            }while(cursor.moveToNext());
        }
        return foodList;
    }
    public List<FoodDomain> getAllCart(){
        List<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_CART;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
//                food.setDescription(cursor.getString(4));
                food.setNumberInCart(Integer.parseInt(cursor.getString(4)));
//                foodList.add(food);
                foodList.add(food);
                System.out.println("carttitile"+food.getTitle());

            }while(cursor.moveToNext());
        }
        System.out.println("foodlist"+foodList);
        return foodList;
    }
    public List<FoodDomain> getAllOrders() {
        List<FoodDomain> foodList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_ORDER;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst()){
            do{
                FoodDomain food = new FoodDomain();
                food.setId(Integer.parseInt(cursor.getString(0)));
                food.setTitle(cursor.getString(1));
                food.setFee(Double.valueOf(cursor.getString(2)));
                food.setPic(cursor.getString(3));
//                food.setDescription(cursor.getString(4));
//                food.setNumberInCart(cursor.getInt(4));

//                foodList.add(food);
                foodList.add(food);
                System.out.println("carttitile"+food.getTitle()+"\nPic"+food.getPic()+"\nFee"+food.getFee());

            }while(cursor.moveToNext());
        }
        System.out.println("foodlist"+foodList);
        return foodList;
    }

    public void addPopular(FoodDomain food) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
        values.put(Params.KEY_DISC, food.getDescription());


        db.insert(Params.CATEGORY_POPULAR, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();
    }

    public void addToCart(FoodDomain food) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_TITLE, food.getTitle());
        values.put(Params.KEY_FEE, food.getFee());
        values.put(Params.KEY_PIC, food.getPic());
//        values.put(Params.KEY_DISC, food.getDescription());
        values.put(Params.KEY_ITMNUM, food.getNumberInCart());
        db.insert(Params.TABLE_CART, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();
    }
    public int updateCart(ArrayList<FoodDomain> foodDomains,int position) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put(Params.KEY_TITLE, food.getTitle());
//        values.put(Params.KEY_FEE, food.getFee());
//        values.put(Params.KEY_PIC, food.getPic());
//        values.put(Params.KEY_DISC, food.getDescription());
        values.put(Params.KEY_ITMNUM, foodDomains.get(position).getNumberInCart());
//        Log.d("dbharry", "Successfully inserted");
//        db.close();
        return db.update(Params.TABLE_CART, values, Params.KEY_ID + "=?",
                new String[]{String.valueOf(foodDomains.get(position).getId())});

    }

//    public int updatefood(food food){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Params.KEY_TITLE, food.get());
//        values.put(Params.KEY_PHONE, food.getPhoneNumber());
//
//        //Lets update now
//        return db.update(Params.TABLE_NAME, values, Params.KEY_ID + "=?",
//                new String[]{String.valueOf(food.getId())});
//
//
//    }
    public void deleteInCartById(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_CART,Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void deleteById(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.CATEGORY_DRINK,Params.KEY_ID+"=?",new String[]{String.valueOf(1)});
        db.close();
    }

    public int getSizeCart() {
        String query = "SELECT  * FROM " + Params.TABLE_CART;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

public void deleteCartFull(){
    SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Params.TABLE_CART,null,null);
        db.close();
}
//    public void deletefood(food food){
//        SQLiteDatabase db=this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(food.getId())});
//        db.close();
//    }
//    public int getCount(){
//        String query = "SELECT  * FROM " + Params.TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor.getCount();
//
//    }
}
