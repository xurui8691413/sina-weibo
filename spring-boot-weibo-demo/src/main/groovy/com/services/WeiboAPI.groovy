package com.services

import com.model.WeiboModel
import com.util.WeiboConfig
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.HttpResponseException
import net.sf.json.JSONArray
import net.sf.json.JSONException
import groovyx.net.http.RESTClient
import net.sf.json.JSONObject
import org.apache.log4j.Logger
import org.springframework.stereotype.Service
import com.custom.exception.RestClientException

import static groovyx.net.http.ContentType.*

@Service("weiboApi")
class WeiboAPI {

    final static Logger LOG = Logger.getLogger(this.class)

    /**
     * Retrieve the latest weibo update list through groovy rest client,the response is json data type
     *
     * @return return the {@link WeiboModel} to map to ui model
     */
    public getPublicTimeline() {
        LOG.info("Get public time line...")
        def client = new RESTClient( WeiboConfig.getValue("baseURL") )
        LOG.debug("Base url is ".concat(WeiboConfig.getValue("baseURL")))
        HttpResponseDecorator response;
        LOG.debug("access  token is ".concat(WeiboConfig.getValue("access_token")))

        try {
            response = client .get(path:WeiboConfig.getValue("publicTimeline"),
                    contentType: JSON,
                    query:[ 'access_token': WeiboConfig.getValue("access_token"),
                            'count': '200',
                            'RESPONSE-DATA-FORMAT':'JSON',]);
            LOG.debug("Get 200 updated records")
        }catch(HttpResponseException ex){
            LOG.error(ex)
            throw new RestClientException("Can not access the weibo url, Bad request.")
        };

        return parseResponse(response)
    }

    private parseResponse(HttpResponseDecorator response) {
        JSONObject object = JSONObject.fromObject(response.getData())
        JSONArray statuses = null;
        try {
            if(object.get("statuses") != null){
                statuses = object.getJSONArray("statuses");
            }
            int size = statuses.size();
            List<WeiboModel> status = new ArrayList<WeiboModel>(size);
            for (int i = 0; i < size; i++) {
                status.add(new WeiboModel(statuses.getJSONObject(i)));
            }
            return status
        } catch (JSONException jsone){
            throw new RestClientException("Json parse failed : ".concat(jsone.message));
        }
          catch (Exception ex){
              throw new RestClientException("Json parse failed : ".concat(ex.message));
        }
    }
}
