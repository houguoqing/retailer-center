package com.kkb.retailer.center.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Column(name="delete_flag")
    private Byte deleteFlag;// 删除状态 0正常 1已删除


}
