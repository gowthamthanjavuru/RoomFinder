package com.twg.spring.fur.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twg.spring.fur.bussiness.EntryBusinessInterface;
import com.twg.spring.fur.bussiness.UserBussinessInterface;
import com.twg.spring.fur.dao.EntryDaoInterface;
import com.twg.spring.fur.dao.UserDaoInterface;
import com.twg.spring.fur.entities.Entry;
import com.twg.spring.fur.entities.User;

@Controller
public class HomeController {


	@Autowired
	private UserBussinessInterface userBusinBussinessInterface;
	
	public UserBussinessInterface getUserBusinBussinessInterface() {
		return userBusinBussinessInterface;
	}

	public void setUserBusinBussinessInterface(UserBussinessInterface userBusinBussinessInterface) {
		this.userBusinBussinessInterface = userBusinBussinessInterface;
	}

	@Autowired
	private EntryBusinessInterface entryBusinessInterface;
	
	public EntryBusinessInterface getEntryBusinessInterface() {
		return entryBusinessInterface;
	}

	public void setEntryBusinessInterface(EntryBusinessInterface entryBusinessInterface) {
		this.entryBusinessInterface = entryBusinessInterface;
	}
	
	@Autowired
	HttpSession session;
	
	//Mappings
	
	@RequestMapping("/home")
	public ModelAndView homepage()
	
	{
		ModelAndView model=new ModelAndView("loginpage");
		return model;
	}
	
	@RequestMapping("/sturegister")
	public ModelAndView register()
	{
		ModelAndView model=new ModelAndView("ownerregister");
		return model;
	}
	
	@RequestMapping(value="/saveuser",method = RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user") User user)
	{
		ModelAndView model=new ModelAndView("loginpage");
		userBusinBussinessInterface.save(user);
		return model;
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ModelAndView authenticateuser(@ModelAttribute("user") User user)
	{
		ModelAndView model=new ModelAndView("loginpage");
		
		User user1=userBusinBussinessInterface.findByUsername(user.getUsername());
		if(user1!=null && user.getPassword().equals(user1.getPassword()))
		{
			model.setViewName("userhomepage");
			model.addObject("user", user1);
			
			session.setAttribute("user", user1);
			
			List<Entry> entries=null;
			try {
				entries=entryBusinessInterface.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addObject("entrieslist", entries);
		}
		return model;
	}

	@RequestMapping("addentry")
	public ModelAndView addentry()
	{
		ModelAndView model=new ModelAndView("addentryform");
		return model;
	}
	
	@RequestMapping("saveentry")
	public ModelAndView saveentry(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.save(entry);
		
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		return model;
	}
	
	@RequestMapping("updateentry")
	public ModelAndView updateentry(@RequestParam("id")int id)
	{
		ModelAndView model=new ModelAndView("displayupdateentry");
		Entry entry=entryBusinessInterface.findById(id);
		
		model.addObject("entry", entry);
		
		User user1=(User)session.getAttribute("user");
		if(user1==null)
			model.setViewName("loginpage");
		return model;
	}
	
	@RequestMapping("processentryupdate")
	public ModelAndView processentryupdate(@ModelAttribute("entry") Entry entry)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		entryBusinessInterface.update(entry);
		
		User user1=(User)session.getAttribute("user");
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		return model;
	}
	
	@RequestMapping("deleteentry")
	public ModelAndView deleteentry(@RequestParam("id")int id)
	{
		ModelAndView model=new ModelAndView("userhomepage");
		
		User user1=(User)session.getAttribute("user");
		Entry entry=entryBusinessInterface.findById(id);
		if(user1==null)
			model.setViewName("loginpage");
		else
		  entryBusinessInterface.delete(entry);
		
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		return model;
	}
	
	@RequestMapping("signout")
	public ModelAndView signout()
	{
		ModelAndView model=new ModelAndView("loginpage");
		session.invalidate();
		return model;
	}
	
	//Student Mappings
	
	@RequestMapping("studentview")
	public ModelAndView studentview()
	{
		ModelAndView model=new ModelAndView("studentView");
		return model;
	}
	
	@RequestMapping("getentries")
	public ModelAndView getentries(@RequestParam("uni")String uni)
	{
		ModelAndView model=new ModelAndView("showentries");
		
		List<Entry> entries=null;
		try {
			entries=entryBusinessInterface.findByUni(uni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject("entrieslist", entries);
		model.addObject("uni", uni);
		return model;
	}
	
}
