package online.jf203.control_203;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.*;

@Controller
public class dataTest_203_Controller {
    @RequestMapping("/api/aigroupdatas/203")
    @ResponseBody
    public String getJsonData203() throws IOException{
        File file = new File("E://机房//JF203//src//main//resources//ai.json");
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
        File file = new File("E://机房//JF203//src//main//resources//ai204.json");
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
        File file = new File("E://机房//JF203//src//main//resources//ai205.json");
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
