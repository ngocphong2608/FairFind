package com.tma.ttphong.fairfind;

import java.io.Serializable;

/**
 * Created by ttphong on 9/1/2016.
 */
public class Product implements Serializable{
    private int mImageResourceId;
    private int mNumberMessage;

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    public int getNumberMessage() {
        return mNumberMessage;
    }

    public void setNumberMessage(int numberMessage) {
        mNumberMessage = numberMessage;
    }
}
