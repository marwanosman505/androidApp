package uk.ac.le.co2103.part2.domain;

import android.media.Image;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "shoppinglists")
public class ShoppingList {

    @PrimaryKey
    private long listId;
    private String name;
    private String image;

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ShoppingList(String nme) {
        this.name = nme;
    }

    public ShoppingList(){};
}
