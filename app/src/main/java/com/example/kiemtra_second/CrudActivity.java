package com.example.kiemtra_second;

import static com.example.libs.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libs.interfaceRepository.Methods;
import com.example.libs.models.Content;
import com.example.libs.models.PostData;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CrudActivity extends AppCompatActivity {
    EditText edtTitle,edtContent, edtGroupName;
    Button btnEdit,btnDelete, btnCreate;
    ImageView pic;
    TextView txtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtContent = (EditText) findViewById(R.id.edtContent);
        edtGroupName = (EditText) findViewById(R.id.edtGroupName);
        btnEdit = (Button) findViewById(R.id.btnEdit) ;
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        pic = (ImageView) findViewById(R.id.imagePic2);

        Intent intent = getIntent();
        Content.Data data = (Content.Data) intent.getSerializableExtra("data");
        if (data != null){
            edtTitle.setText(data.getTitle());
            edtContent.setText(data.getContent());
            edtGroupName.setText(data.getGroupName());
            Picasso.with(CrudActivity.this).load(data.getImageUrl()).into(pic);
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();
                String groupName = edtGroupName.getText().toString();
                Methods methods = getRetrofit().create(Methods.class);
                Call<Content.Data> call = methods.putContent(data.get_id(),new Content.Data(data.getCreatedAt(),groupName,data.getImageUrl(),data.get__v(), data.get_id(),title,content,data.getUpdatedAt()));
                call.enqueue(new Callback<Content.Data>() {
                    @Override
                    public void onResponse(Call<Content.Data> call, Response<Content.Data> response) {
                        Toast.makeText(CrudActivity.this, "cập nhật thành công", Toast.LENGTH_SHORT).show();
                        Intent itent = new Intent(CrudActivity.this,MainActivity.class);
                        startActivity(itent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Content.Data> call, Throwable t) {
                        Log.v("log",t.getMessage());
                    }
                });
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Methods methods = getRetrofit().create(Methods.class);
                Call<Content.Data> call = methods.deleteContent(data.get_id());
                call.enqueue(new Callback<Content.Data>() {
                    @Override
                    public void onResponse(Call<Content.Data> call, Response<Content.Data> response) {
                        Log.v("log","thành công");
                        Toast.makeText(CrudActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        Intent itent = new Intent(CrudActivity.this,MainActivity.class);
                        startActivity(itent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Content.Data> call, Throwable t) {
                        Log.v("log",t.getMessage());
                    }
                });
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String content = edtContent.getText().toString();
                String groupName = edtGroupName.getText().toString();
                PostData post = new PostData();
                post.setContent(content);
                post.setTitle(title);
                post.setGroupName(groupName);
                post.setImageUrl("https://img.nhandan.com.vn/Files/Images/2020/07/26/nhat_cay-1595747664059.jpg");
                Methods methods = getRetrofit().create(Methods.class);
                Call<Content> call = methods.postContent(post);
                call.enqueue(new Callback<Content>() {
                    @Override
                    public void onResponse(Call<Content> call, Response<Content> response) {
                        Toast.makeText(CrudActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        Intent itent = new Intent(CrudActivity.this,MainActivity.class);
                        startActivity(itent);
                        finish();
                    }
                    @Override
                    public void onFailure(Call<Content> call, Throwable t) {

                    }
                });

            }
        });
    }
}