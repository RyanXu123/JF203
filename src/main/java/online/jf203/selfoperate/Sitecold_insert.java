//package online.jf203.selfoperate;
//
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import online.jf203.entity.Sitecold;
//import online.jf203.mapper.SitecoldMapper;
//import online.jf203.service.SitecoldService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class Sitecold_insert implements ApplicationRunner {
//
//    @Autowired
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    private SitecoldService sitecoldservice;
//
//    @Autowired
//    SitecoldMapper sitecoldmapper;
//    Integer cnt=0;
//    @Override
//    public  void run(ApplicationArguments args) throws Exception{
//
//        while(true){
////            System.out.println("test");
//            List<Sitecold> list_site_cold= new ArrayList<>();
////            sitecold sc= new sitecold();
//
//            String sql0=" truncate sitecold";
//            String sql=" select Value0,SiteName from realdata_once where Location='JF203' and PointName='冷通道温度' ";
////            jdbc.execute(sql0); //清空一下sitecold表格
//            List<Map<String,Object>> cold_temp_all=jdbc.queryForList(sql);
//
//            if(cnt==0){
//                for(Map<String,Object> c :cold_temp_all ){//更新上一时刻测点温度
//                    Sitecold sc= new Sitecold();
//                    sc.setLocation("JF203");
//                    sc.setPointName(c.get("SiteName").toString());
//                    sc.setGapValue(Double.parseDouble(c.get("Value0").toString()));
////                    System.out.println(sc);
//                    sitecoldservice.save(sc);
//                }
//                cnt=1;
//            }else{
//
//                for(Map<String,Object> c :cold_temp_all ){//更新上一时刻测点温度
//                    UpdateWrapper<Sitecold> updatawrapper = new UpdateWrapper<>();
//                    updatawrapper.eq("PointName",c.get("SiteName").toString()).set("GapValue",Double.parseDouble(c.get("Value0").toString()));//更新,就不会出现空的情况
//                    sitecoldmapper.update(null,updatawrapper);
//                }
////                cnt=0;
//            }
//            Thread.sleep(60000);
//        }
//    }
//
//}
