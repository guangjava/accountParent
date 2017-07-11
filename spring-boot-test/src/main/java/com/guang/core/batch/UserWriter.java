package com.guang.core.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class UserWriter implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		 System.out.println("handle start =====" + items);
		    for(String a : items) {
		        if(a.equals("good job")) {
		            throw new Exception("custom exception");
		        }
		    }
		    System.out.println("handle end.. -----" + items);
		
	}

}
