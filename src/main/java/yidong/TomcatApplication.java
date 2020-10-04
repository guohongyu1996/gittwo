package yidong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("yidong.dao")
public class TomcatApplication {
    public static void main(String[] args) {
        SpringApplication.run(TomcatApplication.class,args);
    }
}
