package com.getjacked.android.seriousgains;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ClientListFragment extends Fragment {

    private RecyclerView mClientRecyclerView;
    private ClientAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_client_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_client:
                Client client = new Client();
                ClientStorage.get(getActivity()).addClient(client);
                Intent intentClient = ClientPagerActivity.newIntent(getActivity(), client.getId());
                startActivity(intentClient);
                return true;
            case R.id.menu_item_log_out:
                Context context = getContext();
                Toast toastOut = Toast.makeText(context, R.string.log_out_toast, Toast.LENGTH_SHORT);
                toastOut.show();
                Intent intentOut = new Intent(context, LoginActivity.class);
                startActivity(intentOut);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);

        mClientRecyclerView = (RecyclerView) view.findViewById(R.id.client_recycler_view);
        mClientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ClientStorage clientStorage = ClientStorage.get(getActivity());
        List<Client> clients = clientStorage.getClientList();

        if (mAdapter == null) {
            mAdapter = new ClientAdapter(clients);
            mClientRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setClientList(clients);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNameTextView;
        private ImageView mThumbnail;
        private Client mClient;

        public ClientHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mNameTextView = (TextView)itemView.findViewById(R.id.list_item_client_name_text_view);
            mThumbnail = (ImageView)itemView.findViewById(R.id.list_item_client_thumbnail);
        }

        public void bindClient(Client client) {
            mClient = client;
            mNameTextView.setText(mClient.getFirstName() + " " + mClient.getLastName());
            // Not sure how to get the thumbnail from the picture inside. would probably have to add a
            // picture constructor to Client. don't have time
        }

        @Override
        public void onClick(View v) {

            Intent intent = ClientPagerActivity.newIntent(getActivity(), mClient.getId());
            startActivity(intent);

        }
    }

    private class ClientAdapter extends RecyclerView.Adapter<ClientHolder> {
        private List<Client> mClientList;

        public ClientAdapter(List<Client> clients) {
            mClientList = clients;
        }

        @Override
        public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_client, parent, false);
            return new ClientHolder(view);
        }

        @Override
        public void onBindViewHolder(ClientHolder holder, int position) {
            Client client = mClientList.get(position);
            holder.bindClient(client);
        }

        @Override
        public int getItemCount() {
            return mClientList.size();
        }

        public void setClientList(List<Client> clientList) {
            mClientList = clientList;
        }
    }
}