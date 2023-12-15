package online.jf203.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.jf203.entity.log;
import online.jf203.mapper.logMapper;
import online.jf203.service.logService;
import org.springframework.stereotype.Service;

@Service
public class logServiceImpl extends ServiceImpl <logMapper, log> implements logService {
}
