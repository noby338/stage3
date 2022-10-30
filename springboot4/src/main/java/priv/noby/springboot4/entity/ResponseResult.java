package priv.noby.springboot4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult<T>{
    private Integer code;
    private String msg;
    private T data;
}
