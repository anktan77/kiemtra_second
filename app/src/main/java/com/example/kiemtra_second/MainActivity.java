package com.example.kiemtra_second;

import static com.example.libs.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.libs.interfaceRepository.Methods;
import com.example.libs.models.Content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView lvContent;
    ArrayList<Content.Data> arrayContent;
    ContentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContent = (ListView) findViewById(R.id.listviewContent);
        arrayContent = new ArrayList<>();
        adapter = new ContentAdapter(this,R.layout.item_content,arrayContent);

        getContents();

        clickItem();

    }

    private void clickItem() {
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,CrudActivity.class);
                intent.putExtra("data", (Serializable) arrayContent.get(position));
                startActivity(intent);
            }
        });
    }

    private void getContents() {
        Methods methods = getRetrofit().create(Methods.class);
        Call<Content> call = methods.getContents();
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {
                Content.Data[] contentList =  response.body().getData();
                for (Content.Data dt: contentList){
                    arrayContent.add(new Content.Data(dt.getCreatedAt(),dt.getGroupName(),dt.getImageUrl(),dt.get__v(),
                            dt.get_id(),dt.getTitle(),dt.getContent(),dt.getUpdatedAt()));
                }
                lvContent.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
                Log.v("log",t.getMessage());
            }
        });
    }



    public void CreateContent(View view) {
        Intent intent = new Intent(MainActivity.this, CrudActivity.class);
        startActivity(intent);
    }
}