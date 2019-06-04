package dev.nura.com.githubusers.interfaces;

import java.util.List;

import dev.nura.com.githubusers.pojo.User;

/**
 * Created by nura on 12.11.2018.
 */
public interface MainContract {

    interface Presenter {

        void onViewStarted();

        void onDestroy();

        void onUsersLoaded(List<User> users);

        void onError(Throwable t);

    }

    interface Repository {

        void loadUsers();

        void stopLoading();

    }

    interface View {

        void showUsers(List<User> users);

        void showError(Throwable t);

    }

}
