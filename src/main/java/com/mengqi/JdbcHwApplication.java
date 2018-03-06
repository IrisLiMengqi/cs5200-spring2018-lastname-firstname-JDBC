package com.mengqi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mengqi.dao.DeveloperDao;
import com.mengqi.dao.PageDao;
import com.mengqi.dao.RoleDao;
import com.mengqi.dao.UserDao;
import com.mengqi.dao.WebsiteDao;
import com.mengqi.dao.WidgetDao;
import com.mengqi.models.Address;
import com.mengqi.models.Developer;
import com.mengqi.models.HeadingWidget;
import com.mengqi.models.HtmlWidget;
import com.mengqi.models.ImageWidget;
import com.mengqi.models.Page;
import com.mengqi.models.Phone;
import com.mengqi.models.User;
import com.mengqi.models.Website;
import com.mengqi.models.Widget;
import com.mengqi.models.YouTubeWidget;

@SpringBootApplication
public class JdbcHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcHwApplication.class, args);
		
		// create developer and user
				Developer alice = new Developer(0, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", "4321rewq");
				Developer bob = new Developer(1, "Bob", "Marley", "bob", "bob", "bob@marley.com", "5432trew");
				Developer charlie = new Developer(2, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", "6543ytre");
				User dan = new User(3, "Dan", "Martin", "dan", "dan", "dan@martin.com",true);
				User ed = new User(4, "Ed", "Karaz", "ed", "ed", "ed@kar.com",true);

				
				
				DeveloperDao.getInstance().createDeveloper(alice);
				DeveloperDao.getInstance().createDeveloper(bob);
				DeveloperDao.getInstance().createDeveloper(charlie);
				UserDao.getInstance().createUser(dan);
				UserDao.getInstance().createUser(ed);

				// create website for developer.
				Website facebook = new Website(10, "Facebook", "an online social nedia and social networking service", 123445534);
				Website twitter = new Website(11, "Twitter", "an onelie news and social networking service", 3245564);
				Website wikipedia = new Website(12, "Wikipedia", "a free online encyclopedia", 3456654);
				Website cnn = new Website(13, "CNN", "an American basic cable and satellite television news channel", 6543345);
				Website cnet = new Website(14, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and .....", 5433455);
				Website gizmodo = new Website(15, "Gizmodo", "a design, tech, science website that also writes articles on politics", 3421523);
				
				

				WebsiteDao.getInstance().createWebsiteForDeveloper(0, facebook);
				WebsiteDao.getInstance().createWebsiteForDeveloper(1, twitter);
				WebsiteDao.getInstance().createWebsiteForDeveloper(2, wikipedia);
				WebsiteDao.getInstance().createWebsiteForDeveloper(0, cnn);
				WebsiteDao.getInstance().createWebsiteForDeveloper(1, cnet);
				WebsiteDao.getInstance().createWebsiteForDeveloper(2, gizmodo);

				// assigning website roles 
				RoleDao.getInstance().assignWebsiteRole(1, 10, 3);
				RoleDao.getInstance().assignWebsiteRole(2, 10, 1);
				RoleDao.getInstance().assignWebsiteRole(2, 11, 3);
				RoleDao.getInstance().assignWebsiteRole(0, 11, 1);
				RoleDao.getInstance().assignWebsiteRole(0, 12, 3);
				RoleDao.getInstance().assignWebsiteRole(1, 12, 1);
				RoleDao.getInstance().assignWebsiteRole(1, 13, 3);
				RoleDao.getInstance().assignWebsiteRole(2, 13, 1);
				RoleDao.getInstance().assignWebsiteRole(2, 14, 3);
				RoleDao.getInstance().assignWebsiteRole(0, 14, 1);
				RoleDao.getInstance().assignWebsiteRole(0, 15, 3);
				RoleDao.getInstance().assignWebsiteRole(1, 15, 1);


				// creating pages
				Page home = new Page(20, "Home", "Landing page", 123423);
				Page about = new Page(21, "About", "Website description", 234525);
				Page contact = new Page(22, "Contact", "Address, phones, contact info", 232314);
				Page preferences = new Page(23, "Preferences", "Where users can configure their preferences", 234523);
				Page profile = new Page(24, "Profile", "Users can configure their personal information", 523456);

				PageDao.getInstance().createPageForWebsite(14, home);
				PageDao.getInstance().createPageForWebsite(15, about);
				PageDao.getInstance().createPageForWebsite(12, contact);
				PageDao.getInstance().createPageForWebsite(13, preferences);
				PageDao.getInstance().createPageForWebsite(14, profile);

				// assign page roles
				RoleDao.getInstance().assignPageRole(0, 20, 3);
				RoleDao.getInstance().assignPageRole(1, 20, 4);
				RoleDao.getInstance().assignPageRole(2, 20, 2);
				RoleDao.getInstance().assignPageRole(1, 21, 3);
				RoleDao.getInstance().assignPageRole(2, 21, 4);
				RoleDao.getInstance().assignPageRole(0, 21, 2);
				RoleDao.getInstance().assignPageRole(2, 22, 3);
				RoleDao.getInstance().assignPageRole(0, 22, 4);
				RoleDao.getInstance().assignPageRole(1, 22, 2);
				RoleDao.getInstance().assignPageRole(0, 23, 3);
				RoleDao.getInstance().assignPageRole(1, 23, 4);
				RoleDao.getInstance().assignPageRole(2, 23, 2);
				RoleDao.getInstance().assignPageRole(1, 24, 3);
				RoleDao.getInstance().assignPageRole(2, 24, 4);
				RoleDao.getInstance().assignPageRole(0, 24, 2);


				// creating widgets
				HeadingWidget head123 = new HeadingWidget(30, "head123", "Welcome", 0, -1, -1, 5);
				HeadingWidget head345 = new HeadingWidget(32, "head345", "Hi", 1, -1, -1, 5);
				HtmlWidget post234 = new HtmlWidget(31, "post234", "<p>Lorem<p/>", 0, -1, -1, "<p>Lorem<p/>");
				HtmlWidget intro456 = new HtmlWidget(33, "intro456", "<h1>Hi</h1>", 2, -1, -1, "<h1>Hi</h1>");
				ImageWidget image345 = new ImageWidget(34, "image345", null, 3, 50, 100, "/img/567.png");
				YouTubeWidget video456 = new YouTubeWidget(35, "video456", "null", 0, 400, 300, "https://youtu.be/h67VX51QXiQ",true,true);

				WidgetDao.getInstance().createWidgetForPage(20, head123);
				WidgetDao.getInstance().createWidgetForPage(21, post234);
				WidgetDao.getInstance().createWidgetForPage(22, head345);
				WidgetDao.getInstance().createWidgetForPage(22, intro456);
				WidgetDao.getInstance().createWidgetForPage(22, image345);
				WidgetDao.getInstance().createWidgetForPage(23, video456);

				// update Charlie's number
				for (Phone each : charlie.getPhones()){
					if (each.isPrimary()) each.setPhone("333-444-5555");
				}
				DeveloperDao.getInstance().updateDeveloper(2, charlie);

				// update widget
				head345.setOrder(3);
				image345.setOrder(1);
				WidgetDao.getInstance().updateWidget(32, head345);
				WidgetDao.getInstance().updateWidget(34, image345);

				// update page
				home.setTitle("CNET-Home");
				profile.setTitle("CNET-Profile");
				PageDao.getInstance().updatePage(home.getId(), home);
				PageDao.getInstance().updatePage(profile.getId(), home);

				// update roles
				RoleDao.getInstance().assignPageRole(0, 20, 3);
				RoleDao.getInstance().assignPageRole(2, 20, 4);
				RoleDao.getInstance().assignPageRole(1, 20, 2);


				// delete developer address
				for (Address each : alice.getAddresses()){
					if (each.isPrimary()) alice.getAddresses().remove(each);
				}
				DeveloperDao.getInstance().updateDeveloper(2, alice);

				// delete widget
				List<Widget> list = new ArrayList<Widget>();
				list.add(head123);
				list.add(post234);
				list.add(head345);
				list.add(intro456);
				list.add(image345);
				list.add(video456);
				WidgetDao.getInstance().deleteWidget(list.get(2).getId());

				// delete page
				List<Page> pg = new ArrayList<Page>();
				pg.add(home);
				pg.add(about);
				pg.add(contact);
				pg.add(preferences);
				pg.add(profile);
				Collections.sort(pg, (p1, p2) -> p1.getUpdated().compareTo(p2.getUpdated()));
				PageDao.getInstance().deletePage(pg.get(pg.size() - 1).getId());
				

				// delete website

				WebsiteDao.getInstance().deleteWebsite(13);
				RoleDao.getInstance().deleteWebsiteRole(1, 14, 0);
				RoleDao.getInstance().deleteWebsiteRole(0 , 14, 1);
				RoleDao.getInstance().deleteWebsiteRole(2, 14, 3);
				RoleDao.getInstance().deletePageRole(0, 20, 3);
				RoleDao.getInstance().deletePageRole(1, 20, 4);
				RoleDao.getInstance().deletePageRole(2, 20, 2);
				RoleDao.getInstance().deletePageRole(1, 24, 3);
				RoleDao.getInstance().deletePageRole(2, 24, 4);
				RoleDao.getInstance().deletePageRole(0, 24, 2);
	
	
		
		
	}
}
