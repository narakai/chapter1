package com.clem;

import com.clem.domain.User;
import com.clem.service.UserRepository;
import com.clem.tasks.Tasks;
import com.clem.web.HelloController;
import com.clem.web.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter1ApplicationTests {
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(new HelloController(), new UserController()).build();
        userRepository.save(new User("AAA", 10));
    }

    @Test
    public void test() throws Exception {
        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());
        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());

        u1.setAge(20);
        userRepository.save(u1);
        User u3 = userRepository.findByName("AAA");
        System.out.println("第三次查询：" + u3.getAge());
    }


//	@Test
//	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Hello World")));
//	}
//
//	@Test
//	public void testUserController() throws Exception {
////  	测试UserController
//		RequestBuilder request = null;
//
//		// 1、get查一下user列表，应该为空
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[]")));
//
//		// 2、post提交一个user
//		request = post("/users/")
//				.param("id", "1")
//				.param("name", "测试大师")
//				.param("age", "20");
//		mvc.perform(request)
////				.andDo(MockMvcResultHandlers.print())
//				.andExpect(content().string(equalTo("success")));
//
//		// 3、get获取user列表，应该有刚才插入的数据
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
//
//		// 4、put修改id为1的user
//		request = put("/users/1")
//				.param("name", "测试终极大师")
//				.param("age", "30");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("success")));
//
//		// 5、get一个id为1的user
//		request = get("/users/1");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
//
//		// 6、del删除id为1的user
//		request = delete("/users/1");
//		mvc.perform(request)
//				.andExpect(content().string(equalTo("success")));
//
//		// 7、get查一下user列表，应该为空
//		request = get("/users/");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[]")));
//
//	}
//
//	@Test
//    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
//	public void test() throws Exception {
//		// 创建10条记录
//		userRepository.save(new User("AAA", 10));
//		userRepository.save(new User("BBB", 20));
//		userRepository.save(new User("CCC", 30));
//		userRepository.save(new User("DDD", 40));
//		userRepository.save(new User("EEE", 50));
//		userRepository.save(new User("FFF", 60));
//		userRepository.save(new User("GGG", 70));
//		userRepository.save(new User("HHHHH", 80));
//		userRepository.save(new User("III", 90));
//		userRepository.save(new User("JJJ", 100));
//		// 测试findAll, 查询所有记录
//		Assert.assertEquals(10, userRepository.findAll().size());
//		// 测试findByName, 查询姓名为FFF的User
//		Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());
//		// 测试findUser, 查询姓名为FFF的User
//		Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());
//		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
//		Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());
//		// 测试删除姓名为AAA的User
//		userRepository.delete(userRepository.findByName("AAA"));
//		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
//		Assert.assertEquals(9, userRepository.findAll().size());
//	}
//
//	@Autowired
//	private Tasks task;
//	@Test
//	public void testTasks() throws Exception {
////		task.doTaskOne();
////		task.doTaskTwo();
////		task.doTaskThree();
//        long start = System.currentTimeMillis();
//
//        Future<String> task1 = task.doTaskOne();
//        Future<String> task2 = task.doTaskTwo();
//        Future<String> task3 = task.doTaskThree();
//
//        while(true) {
//            if(task1.isDone() && task2.isDone() && task3.isDone()) {
//                // 三个任务都调用完成，退出循环等待
//                break;
//            }
//            Thread.sleep(500);
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
//	}
//
//	Logger logger = LogManager.getLogger("Test");
//
//	@Test
//    public void contextLoads() {
//        logger.trace("I am trace log.");
//        logger.debug("I am debug log.");
//        logger.warn("I am warn log.");
//        logger.error("I am error log.");
//    }


}
