package online.jf203.control_203;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;

@Controller
public class dataTest_203_Controller {

    private static int requestCount = 0;

    @RequestMapping("/api/aigroupdatas/203")
    @ResponseBody
    public String getJsonData203() throws IOException {
        // 定义文件路径数组
        String[] filePaths = {
                "E://机房//JF203//src//main//resources//ai//1.json",
                "E://机房//JF203//src//main//resources//ai//2.json",
                "E://机房//JF203//src//main//resources//ai//3.json",
                "E://机房//JF203//src//main//resources//ai//4.json"
        };

        // 计算当前要读取的文件索引
        int fileIndex = requestCount % filePaths.length;
        requestCount++;  // 每次请求后递增计数器

        File file = new File(filePaths[fileIndex]);

        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
            reader.close();
            return jsonData.toString();
        } else {
            return "File not found!";
        }
    }

//        File file = new File("");
//        if(file.exists()){//检查文件是否存在E://机房//JF203//src//main//resources//203ai.json
//            BufferedReader reader= new BufferedReader( new FileReader(file));
//            StringBuilder jsonData = new StringBuilder();
//            String line;
//            while((line = reader.readLine())!=null){
//                jsonData.append(line);
//            }
//            reader.close();
//            return  jsonData.toString();
//        }else{
//            return  "File not Find!";
//        }
//
////        InputStream inputStream = resource.getI
//    }



    @RequestMapping("/api/aigroupdatas/201")
    @ResponseBody
    public String getJsonData201() throws IOException{
        File file = new File("E://机房//JF203//src//main//resources//ai201.json");
        if(file.exists()){
            BufferedReader reader= new BufferedReader( new FileReader(file));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                jsonData.append(line);
            }
            reader.close();
            return  jsonData.toString();
        }else{
            return  "File not Find!";
        }

//        InputStream inputStream = resource.getI
    }

    @RequestMapping("/api/aigroupdatas/204")
    @ResponseBody
    public String getJsonData204() throws IOException{
        File file = new File("E://机房//JF203//src//main//resources//jf204.json");
        if(file.exists()){
            BufferedReader reader= new BufferedReader( new FileReader(file));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                jsonData.append(line);
            }
            reader.close();
            return  jsonData.toString();
        }else{
            return  "File not Find!";
        }

//        InputStream inputStream = resource.getI
    }

    @RequestMapping("/api/aigroupdatas/205")
    @ResponseBody
    public String getJsonData205() throws IOException{
        File file = new File("E://机房//JF203//src//main//resources//205ai.json");
        if(file.exists()){
            BufferedReader reader= new BufferedReader( new FileReader(file));
            StringBuilder jsonData = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                jsonData.append(line);
            }
            reader.close();
            return  jsonData.toString();
        }else{
            return  "File not Find!";
        }

//        InputStream inputStream = resource.getI
    }
    @PostMapping("/ai/trainning")
    @ResponseBody
    public String ai_instruction(){
        return "success";
    }
}
