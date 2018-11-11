package dev.nura.com.githubusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        List<User> users = new ArrayList<>();
        for(int x = 1; x <= 10; x++) {
            User user = new User("John " + x, "https://avatars0.githubusercontent.com/u/1?v=4");
            users.add(user);
        }
        UserRecyclerAdapter adapter = new UserRecyclerAdapter(this, users);
        recyclerView.setAdapter(adapter);
    }
}
