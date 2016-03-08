package com.esquel.extraInfo;

import java.util.HashMap;
import java.util.Map;

import org.apache.cordova.CordovaActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;
 
public class ExtraInfo extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
            throws JSONException {
        Activity activity = this.cordova.getActivity();
        if (action.equals("getExtra")) {
            Intent i = activity.getIntent();
            if (i.hasExtra(Intent.EXTRA_TEXT)) {
                callbackContext.success(i.getStringExtra(Intent.EXTRA_TEXT));
            } else {
                callbackContext.error("");
            }
            return true;
        }
        return false;
    }
}