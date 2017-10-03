package com.getjacked.android.seriousgains;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.getjacked.android.seriousgains.database.ClientCursorWrapper;
import com.getjacked.android.seriousgains.database.ClientDBHelper;
import com.getjacked.android.seriousgains.database.ClientDBSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* A singleton for storing a list of Clients */

public class ClientStorage {

    private static ClientStorage sClientStorage;
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static ClientStorage get(Context context){
        if (sClientStorage == null){
            sClientStorage = new ClientStorage(context);
        }
        return sClientStorage;
    }
    private ClientStorage(Context context){

        mContext = context.getApplicationContext();
        mDatabase = new ClientDBHelper(mContext).getWritableDatabase();
    }

    public void addClient(Client c){
        ContentValues contentValues =getContentValues(c);
        mDatabase.insert(ClientDBSchema.ClientTable.NAME, null, contentValues);
    }

    public List<Client> getClientList(){
        List<Client> clients = new ArrayList<>();
        ClientCursorWrapper cursor = queryClients(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                clients.add(cursor.getClient());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return clients;
    }

    public Client getClient(UUID id){
        ClientCursorWrapper cursor = queryClients
                (ClientDBSchema.ClientTable.Cols.UUID + " = ?", new String[] {id.toString()});
        try {
            if (cursor.getCount() == 0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getClient();
        }
        finally {
            cursor.close();
        }
    }

    public File getPhotoFile (Client client){
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFilesDir == null){
            return null;
        }
        return new File (externalFilesDir, client.getPicture());
    }

    public void updateClient (Client client){
        String uuidString = client.getId().toString();
        ContentValues values = getContentValues(client);

        mDatabase.update
                (ClientDBSchema.ClientTable.NAME, values, ClientDBSchema.ClientTable.Cols.UUID
                        + " = ?", new String[] {uuidString});

    }

    private static ContentValues getContentValues(Client client){
        ContentValues values = new ContentValues();
        values.put(ClientDBSchema.ClientTable.Cols.UUID, client.getId().toString());
        values.put(ClientDBSchema.ClientTable.Cols.FIRSTNAME, client.getFirstName());
        values.put(ClientDBSchema.ClientTable.Cols.LASTNAME, client.getLastName());
        values.put(ClientDBSchema.ClientTable.Cols.PRONOUNS, client.getPronouns());
        values.put(ClientDBSchema.ClientTable.Cols.WEIGHT, client.getWeight());
        values.put(ClientDBSchema.ClientTable.Cols.HEIGHT, client.getHeight());
        values.put(ClientDBSchema.ClientTable.Cols.STREETADDRESS, client.getStreetAddress());
        values.put(ClientDBSchema.ClientTable.Cols.CITY, client.getCity());
        values.put(ClientDBSchema.ClientTable.Cols.STATE, client.getState());
        values.put(ClientDBSchema.ClientTable.Cols.ZIPCODE, client.getZipCode());
        values.put(ClientDBSchema.ClientTable.Cols.CREDITCARDNUMBER, client.getCreditCardNumber());
        values.put(ClientDBSchema.ClientTable.Cols.CREDITCARDTYPE, client.getCreditCardType());
        values.put(ClientDBSchema.ClientTable.Cols.CVC, client.getCVC());

        return values;
    }

    private ClientCursorWrapper queryClients(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                ClientDBSchema.ClientTable.NAME,
                null, //selects all columns
                whereClause,
                whereArgs,
                null, // groupby
                null, // having
                null // orderby
        );

        return new ClientCursorWrapper(cursor);
    }
}
