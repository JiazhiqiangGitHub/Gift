package lanou.gift.hot;

import android.graphics.Bitmap;

/**
 * Created by dllo on 16/10/25.
 */
public class HotBean {
    String name;
    String price;
    String people;
    Bitmap picture;
    Bitmap love;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public Bitmap getLove() {
        return love;
    }

    public void setLove(Bitmap love) {
        this.love = love;
    }
}
