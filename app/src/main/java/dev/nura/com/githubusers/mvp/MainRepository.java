package dev.nura.com.githubusers.mvp;

import java.util.List;

import dev.nura.com.githubusers.interfaces.MainContract;
import dev.nura.com.githubusers.pojo.User;
import dev.nura.com.githubusers.rest.ApiClass;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nura on 12.11.2018.
 */
public class MainRepository implements MainContract.Repository {

    private Disposable disposable;
    private MainContract.Presenter mPresenter;

    public MainRepository(MainContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void loadUsers() {
        disposable = ApiClass.getApiService().getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        mPresenter.onUsersLoaded(users);
//                        mPresenter.onError(throwable);
                    }
                });
    }

    @Override
    public void stopLoading() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
