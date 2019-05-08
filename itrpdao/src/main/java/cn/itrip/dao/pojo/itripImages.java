package cn.itrip.dao.pojo;

import cn.itrip.pojo.ItripComment;

import java.util.List;

public class itripImages extends ItripComment {

    private List itripImages;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List getItripImages() {
        return itripImages;
    }

    public void setItripImages(List itripImages) {
        this.itripImages = itripImages;
    }

}
