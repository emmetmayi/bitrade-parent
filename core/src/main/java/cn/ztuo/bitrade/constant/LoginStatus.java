package cn.ztuo.bitrade.constant;

import cn.ztuo.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有只有两种状态的都可使用,ordinal为0表示正常，启用；ordinal为1表示软删除，禁用，取消.<br>
 *
 * @author Seven
 * @date 2019年12月07日
 */
@AllArgsConstructor
@Getter
public enum LoginStatus implements BaseEnum {
    /**
     * 表示正常状态
     */
    NORMAL("成功"),
    /**
     * 表示非法状态
     */
    ILLEGAL("失败");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
