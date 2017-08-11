package com.framework.spider.pipeline;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class BookPipeline implements Pipeline{
	private String bookName = "test";
	
	public BookPipeline(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public void process(ResultItems resultItems, Task task) {
		List<String> contents = resultItems.get("content");
		StringBuilder sb = new StringBuilder();
		for(String content: contents){
			sb.append(content+"<br/>");
		}
		try {
			FileUtils.writeStringToFile(new File("d:/"+bookName+".html"), sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
