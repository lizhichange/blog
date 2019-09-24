package run.halo.app.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import run.halo.app.model.dto.BaseCommentDTO;

/**
 * Base comment with parent comment vo.
 *
 * @author johnniang
 * @date 3/31/19
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseCommentWithParentVO extends BaseCommentDTO implements Cloneable {

    /**
     * Parent comment.
     */
    private BaseCommentWithParentVO parent;

    @Override
    public BaseCommentWithParentVO clone() {
        try {
            return (BaseCommentWithParentVO) super.clone();
        } catch (CloneNotSupportedException e) {

            return null;
        }
    }
}
