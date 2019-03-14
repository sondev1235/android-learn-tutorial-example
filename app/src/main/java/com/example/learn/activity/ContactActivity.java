package com.example.learn.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.learn.R;
import com.example.learn.adapter.ContactAdapter;
import com.example.learn.models.Contact;
import com.example.learn.service.MyService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    ListView lvCustome;
    ArrayList<Contact> arrayList;
    ContactAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        new getContactData().execute();
    }

    private void init() {
        progressBar = findViewById(R.id.progress_circular);
        lvCustome = findViewById(R.id.lv_custome);
    }

    private class getContactData extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {
            return MyService.getServer("http://5c89247941fb3f001434bd43.mockapi.io/api/v1/contact");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                arrayList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Contact contact = new Contact();
                    contact.setId(jsonObject.getInt("id"));
                    contact.setName(jsonObject.getString("name"));
                    contact.setPhone(jsonObject.getString("phone"));
                    arrayList.add(contact);
                }
                adapter = new ContactAdapter(ContactActivity.this, arrayList);
                progressBar.setVisibility(View.GONE);
                lvCustome.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
