package com.example.laboratorio05;


import android.os.Parcel;
import android.os.Parcelable;

public class AccountEntity implements Parcelable {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String username;
    private String password;

    // Constructor vacío
    public AccountEntity() {}

    // Constructor que toma un Parcel y llena los datos
    protected AccountEntity(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        email = in.readString();
        phone = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<AccountEntity> CREATOR = new Creator<AccountEntity>() {
        @Override
        public AccountEntity createFromParcel(Parcel in) {
            return new AccountEntity(in);
        }

        @Override
        public AccountEntity[] newArray(int size) {
            return new AccountEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(username);
        dest.writeString(password);
    }

    // Getters y Setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}