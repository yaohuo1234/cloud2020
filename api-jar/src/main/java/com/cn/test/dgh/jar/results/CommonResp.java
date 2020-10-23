package com.cn.test.dgh.jar.results;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  CommonResp<T> {
    private Integer code;
    private  String msg;
    private T data;


    public static <T>  CommonResp<T> buildSuccess(T data){
        return new CommonResp<T>(200,"",data);
    }

    public static <T>  CommonResp<T> buildError(String msg){
        return new CommonResp<T>(-1,msg,null);
    }

}
