package dev.nura.com.githubusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import dev.nura.com.githubusers.adapters.UserRecyclerAdapter;
import dev.nura.com.githubusers.interfaces.MainContract;
import dev.nura.com.githubusers.mvp.MainPresenter;
import dev.nura.com.githubusers.pojo.User;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_user);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        presenter = new MainPresenter(this);
        presenter.onViewStarted();
    }

    @Override
    public void showUsers(List<User> users) {
        recyclerView.setAdapter(new UserRecyclerAdapter(this, users));
    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }
}
