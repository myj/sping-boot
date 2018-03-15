package com.example.demo;

import com.example.demo.entity.SysUser;
import com.example.demo.repository.SysUserRepository;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myj on 2017/6/20.
 */
@RestController
@RequestMapping(value = "/sysUser")
public class HelloController  {

    private static AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private SysUserRepository sysUserRepository;

    private BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")),1000);

    @GetMapping
    public String sysUser() throws InterruptedException {

/*        for (int i=2274;i<50000;i++){
            SysUser sysUser = new SysUser();
            sysUser.setUserName("测试"+i);
            sysUser.setLoginId("测试"+i);
            sysUserRepository.save(sysUser);
        }*/
        System.out.println("请求次数："+counter.incrementAndGet());
        Thread.sleep(1000);
        return configProperties.getName()+" "+configProperties.getAddress();
    }

    @GetMapping(value = "/delUser/{id}")
    public String delUser(@PathVariable("id") Integer id){
        sysUserRepository.delete(id);
        return "success";
    }

    @GetMapping(value = "/getUser/{id}")
    public Object getUser(@PathVariable("id") Integer id){
        return sysUserRepository.findOne(id);
    }

    @PostMapping(value = "/saveUser")
    public void saveUser(String loginId,String userName){

        SysUser sysUser = new SysUser();
        sysUser.setLoginId(loginId);
        sysUser.setUserName(userName);
        sysUserRepository.save(sysUser);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() throws InterruptedException {
/*        Thread.sleep(500);*/
        SysUser sysUser = sysUserRepository.findOne(counter.incrementAndGet());
        String userName = sysUser==null?"":sysUser.getUserName();
        System.out.println(userName+"请求次数："+counter.incrementAndGet());
        return ResponseEntity.ok("ok");
    }
}
