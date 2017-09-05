package com.getjacked.android.seriousgains;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* A singleton for storing a list of Clients */

public class ClientStorage {

    private static ClientStorage sClientStorage;
    private List<Client> mClientList;



    public static ClientStorage get(Context context){
        if (sClientStorage == null){
            sClientStorage = new ClientStorage(context);
        }
        return sClientStorage;
    }
    // Example Clients?
    private ClientStorage(Context context){
        mClientList = new ArrayList<>();
        int c = 0;
        do {
            Client client = new Client();
            client.setFirstName("Joe");
            client.setLastName("Shmo #" + c);
            c++;
        }
        while (
                c < 10
                );
    }

    public List<Client> getClientList(){
        return mClientList;
    }

    public Client getClient(UUID id){
        for (Client client : mClientList){
            if (client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }
}
