package datn.web.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import datn.web.dao.MenuOneDao;
import datn.web.dao.MenuTwoDao;
import datn.web.dao.UserDao;
import datn.web.entity.MenuOne;
import datn.web.entity.MenuTwo;
import datn.web.entity.User;
import datn.web.model.Nav2Model;
import datn.web.service.MenuTwoService;

@Service
public class MenuTwoServiceImpl implements MenuTwoService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	MenuOneDao menuOneDao;
	
	@Autowired
	MenuTwoDao menuTwoDao;

	@Override
	public Nav2Model createNav2(Nav2Model nav2Model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User temp = userDao.findUserByEmail(username);
		
		MenuOne menuOne = menuOneDao.findById(nav2Model.getNav1Id()).get();
		
		MenuTwo menuTwo = new MenuTwo();
		
		menuTwo.setName(nav2Model.getName());
		menuTwo.setNamesearch(nav2Model.getNameSearch());
		menuTwo.setMenuOne(menuOne);
		menuTwo.setCreateday(timestamp.toString());
		menuTwo.setPersoncreate(temp.getId());
		
		menuTwoDao.save(menuTwo);
		
		return nav2Model;
	}

	@Override
	public List<MenuTwo> findAll() {
		return menuTwoDao.getListMenuTwo();
	}

	@Override
	public void delete(Integer id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		User temp = userDao.findUserByEmail(username);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		MenuTwo menuTwo = menuTwoDao.findById(id).get();
		menuTwo.setDeleteday(timestamp.toString());
		menuTwo.setPersondelete(temp.getId());
		menuTwoDao.save(menuTwo);
	}

	@Override
	public Nav2Model getOneNav2ById(Integer id) {
		Nav2Model nav2Model = new Nav2Model();
		MenuTwo menuTwo = menuTwoDao.findById(id).get();
		nav2Model.setName(menuTwo.getName());
		nav2Model.setNameSearch(menuTwo.getNamesearch());
		nav2Model.setNav1Id(menuTwo.getMenuOne().getId());
		return nav2Model;
	}

	@Override
	public Nav2Model updateNav2(Nav2Model nav2Model) {
		MenuOne menuOne = menuOneDao.findById(nav2Model.getNav1Id()).get();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User temp = userDao.findUserByEmail(username);
		
		MenuTwo menuTwo = menuTwoDao.findById(nav2Model.getId()).get();
		menuTwo.setName(nav2Model.getName());
		menuTwo.setNamesearch(nav2Model.getNameSearch());
		menuTwo.setMenuOne(menuOne);
		menuTwo.setPersonupdate(temp.getId());
		menuTwo.setUpdateday(timestamp.toString());
		menuTwoDao.save(menuTwo);
		return nav2Model;
	}
}
