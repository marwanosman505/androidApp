package uk.ac.le.co2103.part2;

import android.media.Image;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(tableName = "shoppinglists")
public class ShoppingList {

    @PrimaryKey(autoGenerate = true)
    private long listId;
    private String name;
    private byte[] image;


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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ShoppingList(String name) {
        this.name = name;
    }

}
