package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json)  {
        if (json == null){
            return  null;
        }
        Sandwich s = null;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> ingredients = new ArrayList<String>();
        try {


            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObject1 = jsonObject.getJSONObject("name");
            String name = jsonObject1.getString("mainName");
            JSONArray jsonArray = jsonObject1.getJSONArray("alsoKnownAs");
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getString(i));
            }
            String placeoforigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray jsonArray1 = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < jsonArray1.length(); i++) {
                ingredients.add(jsonArray1.getString(i));
            }
            s = new Sandwich(name,list,placeoforigin,description,image,ingredients);
            
        }catch (JSONException e){
            
        }
        return s;
    }
}
