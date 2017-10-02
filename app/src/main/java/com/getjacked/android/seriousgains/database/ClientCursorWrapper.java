package com.getjacked.android.seriousgains.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.getjacked.android.seriousgains.Client;

import java.util.UUID;

/**
 * [Death by Jen Titus plays in the distance]
 */

public class ClientCursorWrapper extends CursorWrapper {
    public ClientCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Client getClient() {
        String uuidString = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.UUID));
        String firstName = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.FIRSTNAME));
        String lastName = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.LASTNAME));
        String pronouns = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.PRONOUNS));
        int weight = getInt(getColumnIndex(ClientDBSchema.ClientTable.Cols.WEIGHT));
        String height = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.HEIGHT));
        String streetAddress = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.STREETADDRESS));
        String city = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.CITY));
        String state = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.STATE));
        int zipCode = getInt(getColumnIndex(ClientDBSchema.ClientTable.Cols.ZIPCODE));
        String creditCardNumber = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.CREDITCARDNUMBER));
        String creditCardType = getString(getColumnIndex(ClientDBSchema.ClientTable.Cols.CREDITCARDTYPE));
        int cVC = getInt(getColumnIndex(ClientDBSchema.ClientTable.Cols.CVC));

        Client client = new Client(UUID.fromString(uuidString));
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPronouns(pronouns);
        client.setWeight(weight);
        client.setHeight(height);
        client.setStreetAddress(streetAddress);
        client.setCity(city);
        client.setState(state);
        client.setZipCode(zipCode);
        client.setCreditCardNumber(creditCardNumber);
        client.setCreditCardType(creditCardType);
        client.setCVC(cVC);

        return client;
    }
}
