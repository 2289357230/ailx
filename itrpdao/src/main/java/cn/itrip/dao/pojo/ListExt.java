package cn.itrip.dao.pojo;
import java.util.List;

public class ListExt{

    private String hotelName;

    private List<String> hotelFeatureList;

    private List<String> tradingAreaNameList;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public List<String> getHotelFeatureList() {
        return hotelFeatureList;
    }

    public void setHotelFeatureList(List<String> hotelFeatureList) {
        this.hotelFeatureList = hotelFeatureList;
    }

    public List<String> getTradingAreaNameList() {
        return tradingAreaNameList;
    }

    public void setTradingAreaNameList(List<String> tradingAreaNameList) {
        this.tradingAreaNameList = tradingAreaNameList;
    }
}
