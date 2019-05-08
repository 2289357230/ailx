package cn.itrip.service.impl;
import cn.itrip.dto.Dto;
import cn.itrip.pojo.HotelInfo;
import cn.itrip.pojo.ParametersOfTheClass;
import cn.itrip.pojo.ShowHotelInfo;
import cn.itrip.service.GrogshopService;
import cn.itrip.utils.DtoUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class GrogshopServiceImpl implements GrogshopService {

    @Resource
    private SolrTemplate solrTemplate;

    private SimpleQuery simpleQuery=null;

    @Override
    public Dto searchItripHotelListByHotCity(ParametersOfTheClass parametersOfTheClass) {
        if(parametersOfTheClass!=null){
            if(StringUtils.hasText(String.valueOf(parametersOfTheClass.getCityId()))&&StringUtils.hasText(String.valueOf(parametersOfTheClass.getCount()))){
                simpleQuery=new SimpleQuery("cityId:"+parametersOfTheClass.getCityId());
            }
            simpleQuery.addFilterQuery(new SimpleQuery("isHot:1"));
            Page<ShowHotelInfo> pageInfo=solrTemplate.query("hotel",simpleQuery,ShowHotelInfo.class);
            return DtoUtils.getSuccessWhitDataDto(null,pageInfo.getContent());
        }
        return null;
    }

    @Override
    public Dto searchItripHotelPage(HotelInfo hotelInfo) {
      if (hotelInfo!=null){

          if (StringUtils.hasText(hotelInfo.getKeywords())){
              simpleQuery=new SimpleQuery("keywords:"+ hotelInfo.getKeywords());
          }else {
              simpleQuery=new SimpleQuery("*:*");
          }

          if(!StringUtils.isEmpty(hotelInfo.getAscSort())){
              simpleQuery.addSort(new Sort(Sort.Direction.ASC,hotelInfo.getAscSort()));
          }

          if(!StringUtils.isEmpty(hotelInfo.getDescSort())){
              simpleQuery.addSort(new Sort(Sort.Direction.DESC,hotelInfo.getDescSort()));
          }

          if(!StringUtils.isEmpty(hotelInfo.getDestination())){
              simpleQuery.addFilterQuery(new SimpleQuery(new Criteria("tradeAreaNames").is(hotelInfo.getDestination())));
          }

          if(!StringUtils.isEmpty(hotelInfo.getFeatureIds())){
              simpleQuery.addFilterQuery(new SimpleQuery(new Criteria("featureIds").contains(hotelInfo.getFeatureIds())));
          }

          if(!StringUtils.isEmpty(hotelInfo.getHotelLevel())){
              simpleQuery.addFilterQuery(new SimpleQuery(new Criteria("hotelLevel").is(hotelInfo.getHotelLevel())));
          }

          if(!StringUtils.isEmpty(hotelInfo.getMaxPrice())&&!StringUtils.isEmpty(hotelInfo.getMinPrice())){
              simpleQuery.addFilterQuery(new SimpleQuery(new Criteria("minPrice").between(hotelInfo.getMinPrice(),hotelInfo.getMaxPrice())));
          }

          if(!StringUtils.isEmpty(hotelInfo.getTradeAreaIds())){
              simpleQuery.addFilterQuery(new SimpleQuery(new Criteria("tradeAreaIds").contains(hotelInfo.getTradeAreaIds())));
          }
          int currentPage=0;

          int pageSize=5;

          if(hotelInfo.getPageNo()!=null &&hotelInfo.getPageNo()>0){
              currentPage=hotelInfo.getPageNo()-1;
          }

          if(hotelInfo.getPageSize()!=null && hotelInfo.getPageSize()>0){
              pageSize=hotelInfo.getPageSize();
          }

          simpleQuery.setPageRequest(new PageRequest(currentPage,pageSize));
          Page<ShowHotelInfo> pageInfo=solrTemplate.queryForPage("hotel",simpleQuery,ShowHotelInfo.class);
          cn.itrip.dao.pojo.Page page=new cn.itrip.dao.pojo.Page(pageInfo.getNumber()*pageInfo.getSize(),pageInfo.getNumber()+1,pageInfo.getTotalPages(),pageInfo.getSize(),pageInfo.getContent(),pageInfo.getTotalElements());
          return DtoUtils.getSuccessWhitDataDto(null,page);
      }
        return DtoUtils.getErrorDto(null,null);
    }


}
