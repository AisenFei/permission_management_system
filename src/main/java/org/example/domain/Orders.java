package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.utils.DateUtils;

import java.util.Date;
import java.util.List;

//订单模型
@Getter
@Setter
@ToString
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;


    public String getOrderTimeStr(){
        if(orderTime != null){
            orderTimeStr = DateUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr(){
        if(orderStatus == 0){
            orderStatusStr = "未支付";
        }else if(orderStatus == 1){
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public String getPayTypeStr(){
        //支付方式（0 支付宝 1 微信 2其他）
        if(payType == 0){
            payTypeStr = "支付宝";
        }else if(payType == 1){
            payTypeStr = "微信";
        }else if(payType == 2){
            payTypeStr = "其他";
        }
        return payTypeStr;
    }
}
