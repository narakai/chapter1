package com.clem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Service用于标注业务层组件
//
//@Controller用于标注控制层组件（如struts中的action）
//
//@Repository用于标注数据访问组件，即DAO组件
//
//@Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Chapter1Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter1Application.class, args);
	}
}
