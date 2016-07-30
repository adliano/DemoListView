package com.demo.demolistview;

/**
 * Created by adliano on 4/10/16.
 * class to boxing data used on ListView
 *
 */

public class MyImages
{
    private String imageName;
    private int imageID;

    public MyImages(String imageName, int imageID)
    {
        super();
        this.imageName = imageName;
        this.imageID = imageID;
    }

    public String getImageName()
    {
        return imageName;
    }

    public int getImageID()
    {
        return imageID;
    }
}
