package com.example.rockeypandit.pogo.CardsFolder;

public class Cards {

    private String userId , name, profileImageUrl;
    public Cards(String userId,String name,String profileImageUrl){
        this.userId=userId;
        this.profileImageUrl=profileImageUrl;
        this.name=name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setProfileImageUrl(String name) {

        this.profileImageUrl = profileImageUrl;
    }


}
