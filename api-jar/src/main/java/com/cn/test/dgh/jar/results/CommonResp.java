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

}
