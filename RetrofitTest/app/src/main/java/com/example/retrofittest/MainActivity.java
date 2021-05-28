package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    EditText et;
    Retrofit retrofit;
    List<Book> bookslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerview);
        et = findViewById(R.id.bookname);
       retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/")
               .addConverterFactory(ScalarsConverterFactory.create()).build();
    }

    public void search(View view) {
        String bookname = et.getText().toString();
        BookService service = retrofit.create(BookService.class);
        Call<String> response = service.getresponse(bookname);
        bookslist = new ArrayList<>();

        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String jsondata = response.body();
               // Toast.makeText(MainActivity.this, jsondata, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(jsondata);
                    JSONArray itemsjsonarray = jsonObject.getJSONArray("items");
                    for (int i=0; i<itemsjsonarray.length();i++){
                        JSONObject indexobject = itemsjsonarray.getJSONObject(i);
                        JSONObject volumeinfo = indexobject.getJSONObject("volumeInfo");
                        String booktitle = volumeinfo.getString("title");
                        Book b = new Book(booktitle);
                        bookslist.add(b);

                    }
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                     BooksAdapter adapter = new BooksAdapter(bookslist ,MainActivity.this);
                     rv.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, ""+bookslist.size(), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {


            }
        });
    }
}