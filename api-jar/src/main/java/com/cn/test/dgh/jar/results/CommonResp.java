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
    private Head head;
    private T data;


    public static <T>  CommonResp<T> buildSuccess(T data){
        return new CommonResp<T>(new Head(200,null),data);
    }

    public static <T>  CommonResp<T> buildError(String msg){
        return new CommonResp<T>(new Head(-1,msg),null);
    }

}
