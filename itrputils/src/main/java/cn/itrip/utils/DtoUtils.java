package cn.itrip.utils;


import cn.itrip.dto.Dto;

public class DtoUtils {
    // dto对象的种类   4个   编码  消息   结果 成功 失败    数据   有数据  没有数据   异常

    /**
     * 返回成功的DTo
     * @param msg
     * @return
     */
    public static Dto getSuccesDto(String msg){
            Dto dto=new Dto();
            dto.setErrorCode("000000");
            dto.setMsg(msg);
            dto.setSuccess("true");
            return dto;
        }

    /**
     * 返回失败的DTo
     * @param code
     * @param msg
     * @return
     */
    public static Dto getFailDto(String code,String msg){
        Dto dto=new Dto();
        dto.setErrorCode(code);
        dto.setMsg(msg);
        dto.setSuccess("flase");
        return dto;
    }

    /**
     * 返回成功有数据的DTo
     * @param msg
     * @return
     */
    public static Dto getSuccessWhitDataDto(String msg,Object data){
        Dto dto=new Dto();
        dto.setErrorCode("000000");
        dto.setMsg(msg);
        dto.setSuccess("true");
        dto.setData(data);
        return dto;
    }

    /**
     * 返回失败有数据的DTo
     * @param code
     * @param msg
     * @return
     */
    public static Dto getFailWhitDataDto(String code,String msg,Object data){
        Dto dto=new Dto();
        dto.setErrorCode(code);
        dto.setMsg(msg);
        dto.setSuccess("false");
        dto.setData(data);
        return dto;
    }


    /**
     * 返回异常DTo
     * @param code
     * @param msg
     * @return
     */
    public static  Dto getErrorDto(String code,String msg){
        Dto dto=new Dto();
        dto.setErrorCode(code);
        dto.setMsg(msg);
        dto.setSuccess("false");
        return dto;
    }

}
