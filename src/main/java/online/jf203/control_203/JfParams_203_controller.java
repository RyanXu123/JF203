package online.jf203.control_203;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class JfParams_203_controller {
    @Autowired
    private JdbcTemplate jdbc;


   //机房参数
    @CrossOrigin
    @RequestMapping("/getData/203/aipreparams")
    @ResponseBody
//    @Scheduled(fixedRate = 30000)
    public List<Map<String,Object>> getdata203_ai(){
        String sql="select * from aipreparams where time = (select time from aipreparams order by id desc limit 0,1)";
        List <Map<String,Object>> list=jdbc.queryForList(sql);
        List <Map<String,Object>> list1=new ArrayList<>();
        List <Map<String,Object>> list2=new ArrayList<>();
        for (Map<String,Object> c :list){
            String content=c.get("Content").toString();
            if(content.equals("机房IT总功率") |content.equals("机房空调总功率") |content.equals("机房PUE") ){

            }else{
                list2.add(c);
            }
        }
        return list2;//{（机房总功率，xxxx），（机房空调总功率，xxxxx），（机房pue，xxxx）}
    }


    @CrossOrigin
    @RequestMapping("/getData/203/jfparams")
    @ResponseBody
    @Scheduled(fixedRate = 30000)
    public List<Map<String,Object>> getdata203_ai2(){
        String sql="select * from aipreparams where time = (select time from aipreparams order by id desc limit 0,1)";
        List <Map<String,Object>> list=jdbc.queryForList(sql);
        List <Map<String,Object>> list1=new ArrayList<>();
        List <Map<String,Object>> list2=new ArrayList<>();
        for (Map<String,Object> c :list){
            String content=c.get("Content").toString();
            if(content.equals("机房IT总功率") |content.equals("机房空调总功率") |content.equals("机房PUE") ){
                list1.add(c);
            }else{

            }
        }
        return list1;
    }
}
