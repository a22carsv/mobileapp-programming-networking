package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";

    private ArrayList<Mountain> mountainList = new ArrayList<>();

    private RecyclerView recyclerView;

    private MountainAdapter mountainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mountainAdapter = new MountainAdapter(mountainList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mountainAdapter);

        new JsonTask(this).execute(JSON_URL);
        new JsonFile(this, this).execute("mountains.json");
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String ID = jsonObject.getString("ID");
                    String type = jsonObject.getString("type");
                    String company = jsonObject.getString("company");
                    String location = jsonObject.getString("location");
                    String category = jsonObject.getString("category");
                    int size = jsonObject.getInt("size");
                    int cost = jsonObject.getInt("cost");
                    mountainList.add(new Mountain(ID, name, type, company, location, category, size, cost));
                }
                mountainAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
