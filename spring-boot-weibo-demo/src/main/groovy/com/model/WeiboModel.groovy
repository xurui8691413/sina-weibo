package com.model

import net.sf.json.JSONException
import net.sf.json.JSONObject
import groovyx.net.http.HttpResponseDecorator
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * weibo info data mapping ui model used for display
 * weibo information
 */
public class WeiboModel {

    private static final long serialVersionUID = -8795691786466526420L;
    /**
     * user information
     */
    private WeiboUser user = null;

    /**
     * create time
     */
    private Date createdAt;

    /**
     * status id
     */
    private String id;

    /**
     * weibo mid
     */
    private String mid;

    /**
     * weibo content
     */
    private String text;

    public WeiboModel() {}

    public WeiboModel(HttpResponseDecorator res)throws Exception{
        super(res);
        JSONObject json = JSONObject.fromObject(res.getData());
        constructJson(json);
    }

    private void constructJson(JSONObject json) throws Exception {
        try {
            createdAt = parseDate(json.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            id = json.get("id").toString();
            mid=json.get("mid").toString();
            text = json.get("text").toString();
            if(!json.get("user") != null)
                user = new WeiboUser(json.getJSONObject("user"));
        } catch (JSONException je) {
            throw new Exception(je.getMessage() + ":" + json.toString(), je);
        }
    }

    protected Date parseDate(String str, String format) throws Exception{
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            synchronized (sdf) {
                // SimpleDateFormat is not thread safe
                return sdf.parse(str);
            }
        } catch (ParseException pe) {
            throw new Exception("Unexpected format(" + str + ") returned from sina.com.cn");
        }
    }

    public WeiboModel(JSONObject json)throws Exception, JSONException{
        constructJson(json);
    }
    public WeiboModel(String str) throws Exception, JSONException {
        super();
        JSONObject json = new JSONObject(str);
        constructJson(json);
    }


    public WeiboUser getUser() {
        return user;
    }
    public void setUser(WeiboUser user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WeiboEntity{" +
                "user=" + user +
                ", createdAt=" + createdAt +
                ", id='" + id + '\'' +
                ", mid='" + mid + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + ((this.user == null) ? 0 : this.user.hashCode()) +
                ((this.createdAt == null) ? 0 : this.createdAt.hashCode()) +
                ((this.id == null) ? 0 : this.id.hashCode()) +
                ((this.mid == null) ? 0 : this.mid.hashCode()) +
                ((this.text == null) ? 0 : this.text.hashCode())

        return hashCode;
    }
}
