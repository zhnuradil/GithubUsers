package dev.nura.com.githubusers.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by nura on 11.11.2018.
 */
public final class User {

    @SerializedName("login")
    private String name;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public User(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(avatarUrl, user.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, avatarUrl);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
