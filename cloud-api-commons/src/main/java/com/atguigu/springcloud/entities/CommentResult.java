package com.atguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String msg;
    private T data;
    public CommentResult(Integer code, String msg){
        this(code,msg,null);
    }

    public void setResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
