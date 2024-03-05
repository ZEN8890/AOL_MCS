package com.example.aol_mcs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView dollRecyclerView;
    private DollAdapter dollAdapter;
    private final ArrayList<Doll> dollList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Initialize UI components
        dollRecyclerView = findViewById(R.id.dollRecyclerView);
        dollRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dollAdapter = new DollAdapter(dollList, selectedDoll -> {
            // Handle doll item click, e.g., redirect to doll detail page
            redirectToDollDetail(selectedDoll);
            return null;
        });
        dollRecyclerView.setAdapter(dollAdapter);

        // Fetch doll data from JSON using Volley
        fetchDollDataFromJson();
    }

    private void fetchDollDataFromJson() {
        String url = "https://api.npoint.io/9d7f4f02be5d5631a664";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> parseJsonResponse(response),
                error -> showToast("Error fetching doll data: " + error.getMessage()));

        // Add the request to the RequestQueue.
        Volley.newRequestQueue(this).add(request);
    }

    private void parseJsonResponse(JSONObject response) {
        try {
            JSONArray jsonArray = response.getJSONArray("dolls");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject dollObject = jsonArray.getJSONObject(i);

                // Extract relevant doll data from JSON
                int dollId = dollObject.getInt("id");
                String dollName = dollObject.getString("name");
                String dollCover = dollObject.getString("cover");

                // Create Doll object and add to the list
                Doll doll = new Doll(dollId, dollName, dollCover);
                dollList.add(doll);
            }

            // Update RecyclerView with doll data
            dollAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            showToast("Error parsing JSON: " + e.getMessage());
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void redirectToDollDetail(Doll selectedDoll) {
        // Implement redirection to Doll Detail Page
        // You can use Intent to start a new activity and pass relevant data
        // For example:
        Intent intent = new Intent(this, Doll.class);
        intent.putExtra("dollId", selectedDoll.getId());
        startActivity(intent);
    }
}



