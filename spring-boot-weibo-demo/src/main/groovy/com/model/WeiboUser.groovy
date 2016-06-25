package com.model

import net.sf.json.JSONException
import net.sf.json.JSONObject
import groovyx.net.http.HttpResponseDecorator

/**
 *  weibo user data mapping
 */
public class WeiboUser {

    private static final long serialVersionUID = -332738032648843482L;
    /**
     * user id
     */
    private String id;

    /**
     * NickyName
     */
    private String screenName;

    /**
     * gender
     */
    private String gender;

    public void setId(String id) {
        this.id = id;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public WeiboUser(JSONObject json) throws Exception {
        super();
        init(json);
    }

    public WeiboUser(HttpResponseDecorator res ) throws Exception {
        super(res);
        init(JSONObject.fromObject(res.getData()));
    }

    private void init(JSONObject json) throws Exception {
        if(json!=null){
            try {
                id = json.get("id").toString();
                screenName = json.get("screen_name").toString();
                gender = json.get("gender").toString();
            } catch (JSONException jsone) {
                throw new Exception(jsone.getMessage() + ":" + json.toString(), jsone);
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "WeiboUser{" +
                "id='" + id + '\'' +
                ", screenName='" + screenName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    int hashCode() {
        final int prime = 13;
        int hashCode = 1;
        hashCode = prime * hashCode + ((this.id == null) ? 0 : this.id.hashCode()) +
                ((this.screenName == null) ? 0 : this.screenName.hashCode()) +
                ((this.gender == null) ? 0 : this.gender.hashCode())
        return hashCode;
    }
}