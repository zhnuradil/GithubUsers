package dev.nura.com.githubusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

//        for(int x = 1; x <= 10; x++) {
//            User user = new User("John " + x, "https://avatars0.githubusercontent.com/u/1?v=4");
//            users.add(user);
//        }
        final UserRecyclerAdapter adapter = new UserRecyclerAdapter(this, users);
        recyclerView.setAdapter(adapter);

        Call<List<User>> userList =  ApiClass.getApiService().getUsers();
        userList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()) {
                    System.out.println("### size:" + response.body().size());
                    users = response.body();
                    adapter.update(users);
                    System.out.println("### " + users.toString());
                } else {
                    System.out.println("### error code:" + response.body().size());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println("### fail: " + t);
            }
        });
    }
}
