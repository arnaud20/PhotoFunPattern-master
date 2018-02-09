package edu.up.cs371.epp.photofunpattern;

import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *   https://github.com/edcepp/PhotoFunPattern
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;
    private TextView originalTextView6;
    private ImageView myOriginalView;
    /*
    * onCreate This constructor lays out the user interface, initializes the
    * original image and links buttons to their actions.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        ImageView originalImageView =
                (ImageView) findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp =
                (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        myNewImageView = (ImageView) findViewById(R.id.newImage);

        myOriginalView = (ImageView) findViewById(R.id.originalImage);

        Button grayFilterButton =
                (Button) findViewById(R.id.grayFilterButton);
        grayFilterButton.setOnClickListener(new grayFilterButtonListener());
        Button brightnessFilterButton =
                (Button) findViewById(R.id.brightnessFilterButton);
        brightnessFilterButton.setOnClickListener
                (new brightnessFilterButtonListener());
         originalTextView6 = (TextView) findViewById(R.id.textView6);
    }

    private String[] myImageNames;
    private ArrayList<Bitmap> myImageBmps;

    private void initSpinner (){
        Spinner spinner = (Spinner) findViewById(R.id.imageNames);
        myImageNames =
                getResources().getStringArray(R.array.imageNames);
        ArrayAdapter adapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                myImageNames);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener
                (new MySpinnerListener());
    }



    private void initImageArray (){
        myImageBmps = new ArrayList<Bitmap>();
        TypedArray imageIds =
                getResources().obtainTypedArray(R.array.imageIdArray);

        for (int i=0; i<myImageNames.length; i++) {
            int id = imageIds.getResourceId(i, 0);
            if (id == 0)
                id = imageIds.getResourceId(0, 0);
            Bitmap bmp =
                    BitmapFactory.decodeResource(getResources(), id);
            myImageBmps.add(bmp);
        }
    }


    private class MySpinnerListener implements
            AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parentView,
                                   View selectedItemView,
                                   int position,
                                   long id){
            myOriginalView.setImageBitmap
                    (myImageBmps.get(position));
            BitmapDrawable originalDrawableBmp =
                    (BitmapDrawable) myOriginalView.getDrawable();
            myOriginalBmp = originalDrawableBmp.getBitmap();
        }

        public void onNothingSelected(AdapterView<?> parentView){

        }
    }




    /*
    * class grayFilterButtonListener this inner class defines the action for
    * the gray filter button.
    */
    private class grayFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            GrayFilter filter = new GrayFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));


            originalTextView6.setText("Gray Scale"); //set text for text view

        }
    }

    /*
    * class grayFilterButtonListener this inner class defines the action for the
    * brightness filter
    * button.
    */
    private class brightnessFilterButtonListener
            implements View.OnClickListener {
        public void onClick(View button) {
            BrightnessFilter filter = new BrightnessFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
            originalTextView6.setText("Brightened"); //set text for text view
        }
    }
}

