package com.enovatiors.shashithdarshana.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by VDARSSH on 6/14/2015.
 */
public class Utility {

        public static void setFont(TextView txtview,Context context) {
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/sinhala.ttf");
            txtview.setTypeface(font);
        }



}
