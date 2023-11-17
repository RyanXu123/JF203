package online.jf203.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("ai_control")
@Data
public class Aicontrol {
    @TableId
    private String content;
    private String username;
    private String time;
    private String userRole;
}
