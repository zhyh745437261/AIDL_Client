package aidl.zhyh.mtc.com.aidl_server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhyh on 17-11-7.
 */

public class person implements Parcelable {

    private String name;
    private int age;
    private String sex;

    public person(){

    }

    public person(Parcel parcel){
        this.name = parcel.readString();
        this.age = parcel.readInt();
        this.sex = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.age);
        parcel.writeString(this.sex);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex(){
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static final Creator<person> CREATOR =new Creator<person>() {
        @Override
        public person createFromParcel(Parcel parcel) {
            return new person(parcel);
        }

        @Override
        public person[] newArray(int i) {
            return new person[i];
        }
    };
}
