/**
 * 
 */
package com.his.cms.velocity;

import com.his.cms.velocity.builder.GalleryBuilder;
import com.his.cms.velocity.builder.IndexBuilder;
import com.his.cms.velocity.builder.MenuNewsListBuilder;
import com.his.cms.velocity.builder.MenuPageBuilder;
import com.his.cms.velocity.builder.NewsDetailBuilder;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-5-12
 */
public class AllBuilder {

	public void builder() throws Exception {
		IndexBuilder b1 = new IndexBuilder();
		MenuPageBuilder b2 = new MenuPageBuilder();
		MenuNewsListBuilder b3 = new MenuNewsListBuilder(); 
		NewsDetailBuilder b4 = new NewsDetailBuilder();
		GalleryBuilder b5 = new GalleryBuilder();
		b1.builder();
		b2.builder();
		b3.builder();
		b4.builder();
		b5.builder();
	}
	
	public static void main(String[] args) throws Exception {
		AllBuilder builder = new AllBuilder();
		builder.builder();
	}
}
