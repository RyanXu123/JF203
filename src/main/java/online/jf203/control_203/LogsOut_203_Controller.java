package online.jf203.control_203;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class LogsOut_203_Controller {
    @Autowired
    private JdbcTemplate jdbc;
//导出日志
    @CrossOrigin
    @RequestMapping("/getData/203/logs/out")
    @ResponseBody
//    @Scheduled(fixedRate = 30000)
    public List<Map<String, Object>> LogsSelect() {
        String sql = "select * from log";
        List<Map<String, Object>> list = jdbc.queryForList(sql);
        return list;
    }

    @CrossOrigin
    @PostMapping("/getData/203/logs")
    @ResponseBody
//    @Scheduled(fixedRate = 30000)
    public List<Map<String, Object>> LogsSelect_one(@RequestBody List<String> data) {
        String sql = "select * from log";
        String start_time=data.get(0).toString();
        String end_time=data.get(1).toString();
        sql=sql.concat(" where time >'"+start_time+"' and time <'"+end_time+"';");
        // 使用STR_TO_DATE函数统一时间格式
        //sql = sql.concat(" where time > STR_TO_DATE('" + start_time + "', '%Y-%m-%d %H:%i:%s') and time < STR_TO_DATE('" + end_time + "', '%Y-%m-%d %H:%i:%s');");
        List<Map<String, Object>> list = jdbc.queryForList(sql);
        return list;
    }
}
