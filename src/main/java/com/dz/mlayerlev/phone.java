package com.dz.mlayerlev;

public class phone  {
    private String name;
    private String phoneNumber;
    private String homeAddress;
    private String email;

    public phone(String PhoneInfo) {
        String[] info = PhoneInfo.split("\\|");
        name = info[0];
        phoneNumber = info[1];
        homeAddress = info[2];
        email = info[3];
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name +
                "|" + phoneNumber +
                "|" + homeAddress +
                "|" + email;
    }
}
