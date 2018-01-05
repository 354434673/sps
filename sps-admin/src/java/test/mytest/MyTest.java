package mytest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sps.entity.areas.Areas;
import com.sps.service.user.AreasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class MyTest {
		@Resource
		private AreasService areasService;
		@Test
		public void test(){
			List<Areas> areasList = areasService.getAreasList("100000");
			System.out.println(JSON.toJSONString(areasList));
		}
}
