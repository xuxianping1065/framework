package com.framework.spider.processor;

import java.util.List;

import com.framework.spider.pipeline.BookPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BookCatalogPageProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		List<String> contents = page.getHtml().xpath("//div[@class='mulu']/ul/li/a").all();
		page.putField("content", contents);
	}

	public static void main(String[] args) {
		Spider.create(new BookCatalogPageProcessor())
			.addUrl("http://www.88dushu.com/xiaoshuo/85/85211/index.html")
			.addPipeline(new BookPipeline("85211"))
			.thread(5)
			.run();
	}
}
