package com.example.rockeypandit.pogo.Matches;

public class MatchesObject {
    private String userId , name, profileImageUrl;
    public MatchesObject(String userId, String name, String profileImageUrl ){
        this.userId=userId;
        this.profileImageUrl=profileImageUrl;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
