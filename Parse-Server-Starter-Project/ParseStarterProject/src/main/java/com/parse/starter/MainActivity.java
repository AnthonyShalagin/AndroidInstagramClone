/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    ParseObject score = new ParseObject("Score");   //Create Score attribute
//    score.put("username", "anthony");
//    score.put("score", 95);
//    score.saveInBackground(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//
//        if (e == null) {
//          Log.i("SaveInBackground", "Successful ");
//        } else {
//          Log.i("SaveInBackground", "Failed. Error: " + e.toString());
//        }
//
//      }
//    });


    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
    query.getInBackground("m0DcbMoybd", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          object.put("score", 20);
          object.saveInBackground();

          Log.i("ObjectValue", object.getString("username"));
          Log.i("ObjectValue", Integer.toString(object.getInt("score")));
        }
      }
    });
    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}