package online.jf203.control_203;

import online.jf203.entity.Alert;
import online.jf203.entity.Sitecold;
import online.jf203.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
public class ColdChange_203_Controller {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private AlertService alertservice;

    Double cold_unstable_fixed_time=10.0;
    Double cold_unstable_fixed_range=3.0;
    @CrossOrigin
    @RequestMapping("/getData/203/realdata/coldsite_change")
    @ResponseBody
    public List<Map<String,Object>> coldsite_change(){

        Double cold_unstable_fixed_time_real=cold_unstable_fixed_time*2;

        List <Map<String,Object>> list_data= new ArrayList<>();  //储存返回的json
        List<String> server = Arrays.asList("A","B","C","D","E","F","G","H","J","K");
        Collections.reverse(server);//从P开始排序
        String sql_penultimate="select * from realdata_once where Location='JF203' and Equipment='服务器' and PointName='冷通道温度'  and time = ( SELECT time FROM realdata_once order by time desc limit 1 OFFSET 60)"; //60数据间隔
        String sql_last="select * from realdata_once where Location='JF203' and Equipment='服务器' and PointName='冷通道温度' and time = ( SELECT time FROM realdata_once order by time desc limit 1)"; //19测点x3+功率
        sql_penultimate.replace("60",cold_unstable_fixed_time_real.toString());
        Map<String, Object> servers_cold= new TreeMap<>();  //所有列列服务器冷通道
        Integer siteNum=19;//测点个数

//        Integer id=0;
        for (String c:server) {  //遍历服务器 c为（"A","B","C","D" ...）
            Map<String, Object> server_temp_cold = new TreeMap<>();  //某列服务器冷通道

            sql_penultimate=sql_penultimate.replace("'服务器'", "'服务器" + c + "'"); //某服务器所有测点
            sql_last=sql_last.replace("'服务器'", "'服务器" + c + "'");

            List<Map<String, Object>> list_penultimate = jdbc.queryForList(sql_penultimate);
            List<Map<String, Object>> list_last = jdbc.queryForList(sql_last);

            List<Double> server_site_cold_up = new ArrayList<>(); //某列服务器冷通道上测点
            List<Double> server_site_cold_down = new ArrayList<>();  //某列服务器冷通道下测点


            for(int i=0; i< list_penultimate.size();i++){
//                Map<String,Object> penultimateMap= list_penultimate.get(i);
//                Map<String,Object> lastMap= list_last.get(i);
                Double penultimateValue=(double)list_penultimate.get(i).get("Value0");
                Double lastValue=(double)list_last.get(i).get("Value0");
                Double gap=Math.abs(penultimateValue-lastValue);

                if(i%2==0){
                    if(lastValue<1.0){
                        server_site_cold_up.add(-1.0);
                    }else{
                        server_site_cold_up.add(Math.round(gap*100.0)/100.0);
                        if(gap>cold_unstable_fixed_range){
                            Alert alert0 = new Alert();
                            alert0.setContent(list_penultimate.get(i).get("SiteName").toString()+"波动"+String.format("%.2f",Math.abs(gap))+"度");
                            alert0.setEquipment(list_penultimate.get(i).get("Equipment").toString().substring(3));
                            alert0.setLocation("FT203");
                            alert0.setSampleTime(list_penultimate.get(i).get("time").toString());
                            alertservice.save(alert0);
                        }
                    }
                }else{
                    if(lastValue<0.1){
                        server_site_cold_down.add(-1.0);
                    }else{
                        server_site_cold_down.add(Math.round(gap*100.0)/100.0);
                        if(gap>cold_unstable_fixed_range){
                            Alert alert0 = new Alert();
                            alert0.setContent(list_penultimate.get(i).get("SiteName").toString()+"波动"+String.format("%.2f",Math.abs(gap))+"度");
                            alert0.setEquipment(list_penultimate.get(i).get("Equipment").toString().substring(3));
                            alert0.setLocation("FT203");
                            alert0.setSampleTime(list_penultimate.get(i).get("time").toString());
                            alertservice.save(alert0);
                        }
                    }
                }
                Map<String, Object> site_cold = new TreeMap<>(); //冷通道
                site_cold.put("up", server_site_cold_up); //某列服务器所有上测点  （up，{服务器所有测点（1，22）（2，22）..}）
                site_cold.put("down", server_site_cold_down);//某列服务器所有下测点  （down，{服务器所有测点（1，22）（2，22）..}）
                servers_cold.put(c, site_cold); //冷通道（A，{(avg,xx),(sitedetail,xx)}）
            }
        }
        list_data.add(servers_cold);








        return list_data;
    }


    @CrossOrigin
    @RequestMapping("/getData/203/realdata/cold_detect_design")
    @ResponseBody
    public List<Double> cold_detect_design(){
        List<Double> ret=new ArrayList<>();
        ret.add(cold_unstable_fixed_range);
        ret.add(cold_unstable_fixed_time);
        return ret;
    }

    @CrossOrigin
    @PostMapping("/getData/203/realdata/cold_detect_design")
    @ResponseBody
    public List<Double> cold_detect_design2(@RequestBody List<Double>data ){
//        List<Double> ret=new ArrayList<>();
        cold_unstable_fixed_range=data.get(0);
        cold_unstable_fixed_time=data.get(1);
        return data;
    }
}
