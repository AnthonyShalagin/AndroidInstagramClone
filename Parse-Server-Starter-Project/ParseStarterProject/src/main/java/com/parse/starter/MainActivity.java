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

    ParseObject tweet = new ParseObject("Tweet");
    tweet.put("username", "tweet");
    tweet.put("anthonyshalagin", "This is my first tweet");

    tweet.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("Tweet", "Sucessful");
        } else {
          Log.i("Tweet", "Failed, error: " + e.toString());
        }
      }
    });

    ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
    query.getInBackground("dXZiQmYm3b", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {
          object.put("anthonyshalagin", "Changed the tweet contents");
          object.saveInBackground();


        }
      }
    });
    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}