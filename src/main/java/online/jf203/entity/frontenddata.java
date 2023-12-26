package online.jf203.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class frontenddata {
    @TableId
//    private Integer id;
    private String location;
    private String content;
    private Double value0;
    private String time;
}
