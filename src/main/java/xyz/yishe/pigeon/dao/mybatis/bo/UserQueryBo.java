package xyz.yishe.pigeon.dao.mybatis.bo;

import lombok.*;
import lombok.experimental.Accessors;
import xyz.yishe.pigeon.common.bean.BaseBean;
import xyz.yishe.pigeon.common.model.page.PageOrderProperty;

/**
 * 用户信息
 *
 * @author owen 2019-12-24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserQueryBo extends BaseBean {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String nickname;

    @PageOrderProperty
    @Getter
    public enum DirectorQuerySortEnum {
        CREATE_TIME("create_date"),
        ;
        private String desc;

        DirectorQuerySortEnum(String desc) {
            this.desc = desc;
        }
    }
}
