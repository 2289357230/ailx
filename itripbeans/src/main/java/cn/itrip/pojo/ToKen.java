package cn.itrip.pojo;

/**
 * @Author: 吴子辉
 * @Date: 2018/12/28 13:39
 * @Description:
 */
public class ToKen{

    private Long expTime;

    private Long genTime;

    private String token;

    public Long getExpTime() {
        return expTime;
    }

    public void setExpTime(Long expTime) {
        this.expTime = expTime;
    }

    public Long getGenTime() {
        return genTime;
    }

    public void setGenTime(Long genTime) {
        this.genTime = genTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ToKen(Long expTime, Long genTime, String token) {
        this.expTime = expTime;
        this.genTime = genTime;
        this.token = token;
    }
}
