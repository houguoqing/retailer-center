package com.kkb.retailer.center.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import java.util.List;


@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
@Table(name="user_info")
public class UserInfo extends BaseEntity{


    private String userName;

    private String userPassword;

    private String description;

    private Byte type;

    private Long shopId;

}
