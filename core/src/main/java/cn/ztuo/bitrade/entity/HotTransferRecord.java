package cn.ztuo.bitrade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="hot_transfer_record")
public class HotTransferRecord {

    public HotTransferRecord(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private Long adminId ;

    @CreationTimestamp
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transferTime ;

    @Column(columnDefinition = "decimal(20,8) default 0 comment '转账金额'")
    private BigDecimal amount ;

    @Column(columnDefinition = "decimal(20,8) default 0 comment '热钱包余额'")
    private BigDecimal balance ;

    @Column(columnDefinition = "decimal(20,8) default 0 comment '矿工费'")
    private BigDecimal minerFee ;

    private String unit ;

    @Transient
    private String adminName ;

    private String coldAddress ;

    private String transactionNumber ;
}
