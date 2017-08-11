package com.framework.spider.processor;

import com.framework.spider.pipeline.BookPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BookDetailPageProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
        String content = page.getHtml().xpath("//dd[@id='contents']").get();
        page.putField("content", content);
    	System.out.println(content);
	}

	
	public static void main(String[] args) {
		Spider.create(new BookDetailPageProcessor())
		.addUrl("http://www.x23us.com/html/65/65090/26600484.html")
		.addPipeline(new BookPipeline("26600484"))
		.thread(1)
		.run();
	}
}
