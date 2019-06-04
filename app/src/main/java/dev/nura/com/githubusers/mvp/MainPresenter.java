package dev.nura.com.githubusers.mvp;

import java.util.List;

import dev.nura.com.githubusers.interfaces.MainContract;
import dev.nura.com.githubusers.pojo.User;

/**
 * Created by nura on 12.11.2018.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private MainContract.Repository mRepo;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        this.mRepo = new MainRepository(this);
    }

    @Override
    public void onViewStarted() {
        mRepo.loadUsers();
    }

    @Override
    public void onDestroy() {
        mRepo.stopLoading();
    }

    @Override
    public void onUsersLoaded(List<User> users) {
        mView.showUsers(users);
    }

    @Override
    public void onError(Throwable t) {
        mView.showError(t);
    }
}
