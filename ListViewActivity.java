package com.demo.demolistview;

/**
 * Adriano Alves
 * 04 10 2016
 * Simple Demo about ListView on Android
 *
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity
{
    List<MyImages> myImagesList = new ArrayList<>();
    ListView listView;
    // array can be replaced for a List<>
    String test[]= {"aaaaaa","bbbbbb","ccccc","dddddd","eeeeee","fffffff"};;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Integer[] images ={R.drawable.awaken,R.drawable.camera2,R.drawable.ic_launcher,
                           R.drawable.image2993,R.drawable.photo_camera_warning,
                           R.drawable.yellowsigncamera};

        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(itemClickListener);
        populateList(images,test);
        populateListView();

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(ListViewActivity.this, "You Clicked at " + test[position], Toast.LENGTH_SHORT).show();

            }
        });
        */


    }
    /********************* populateList() *****************/
    public void populateList(Integer[] ids, String[] strings)
    {
        for (int i =0 ;i < ids.length;i++)
        {
            myImagesList.add(new MyImages(strings[i], ids[i]));
        }
    }
    /**************** populateListView *******************/
    public void populateListView()
    {
        ArrayAdapter<MyImages> adapter = new MyAdapter();
        //ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    /** inner class  ArrayAdapter *****/
    private class MyAdapter extends ArrayAdapter<MyImages>
    {
        public MyAdapter()
        {
            super(ListViewActivity.this,R.layout.layout_row_list_view, myImagesList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View itemView = convertView;
            if (itemView==null)
            {
                itemView = getLayoutInflater().inflate(R.layout.layout_row_list_view,parent,false);
            }

            //find image
            MyImages image = myImagesList.get(position);
            // populate view
            ImageView itemImage = (ImageView)itemView.findViewById(R.id.iv_list_view_row_icon);
            itemImage.setImageResource(image.getImageID());
            TextView itemName = (TextView)itemView.findViewById(R.id.tv_list_view_row_name);
            itemName.setText(image.getImageName());

            return itemView;
        }
    }
    /********************* OnItemClickListener ************************/
    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Toast.makeText(ListViewActivity.this, "You Clicked at " + test[position], Toast.LENGTH_SHORT).show();
        }
    };
}
