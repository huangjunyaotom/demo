package tech.qcode.jpa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;


@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public  void jsonTest() throws Exception {
		String requestBody = "{\"id\":1, \"name\":\"zhang\"}";  
	    mockMvc.perform(post("/user")  
	            .contentType(MediaType.APPLICATION_JSON).content(requestBody)  
	            .accept(MediaType.APPLICATION_JSON)) //执行请求  
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //验证响应contentType  
	            .andExpect(jsonPath("$.id").value(1)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/  
	      
	    String errorBody = "{id:1, name:zhang}";  
	    MvcResult result = mockMvc.perform(post("/user")  
	            .contentType(MediaType.APPLICATION_JSON).content(errorBody)  
	            .accept(MediaType.APPLICATION_JSON)) //执行请求  
	            .andExpect(status().isBadRequest()) //400错误请求  
	            .andReturn();  
	      
	 }
}
