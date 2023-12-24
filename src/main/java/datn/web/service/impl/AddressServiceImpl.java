package datn.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import datn.web.dao.AddressDao;

import datn.web.dao.UserDao;
import datn.web.entity.Address;


import datn.web.entity.User;

import datn.web.model.AddressModel;
import datn.web.service.AddressService;

@Service
@Repository
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<Address> findListAddressByEmail(String username) {
		return addressDao.findListAddressByEmail(username);
	}

	RestTemplate rest = new RestTemplate();
	String url = "https://addressapi-812db-default-rtdb.firebaseio.com/.json";
	
	

	@Override
	public AddressModel createAddress(AddressModel addressModel) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
		User temp = userDao.findUserByEmail(username);
//		ProvinceDao list = rest.getForObject(url, ProvinceDao.class);	
//		Province province = list.get(Integer.parseInt(addressModel.getProvince()));
//		District district = province.getDistricts().get(Integer.parseInt(addressModel.getDistrict()));
//		Ward ward = district.getWards().get(Integer.parseInt(addressModel.getWard()));
		
		Address address = new Address();
		address.setFullname(addressModel.getFullName());
		address.setPhone(addressModel.getPhone());
		address.setDetail(addressModel.getDetail());
//		address.setProvince(province.getName());
//		address.setDistrict(district.getName());
//		address.setWard(ward.getName());
		address.setUser(temp);
		addressDao.save(address);	
		return addressModel;
	}

	@Override
	public Address getAddressById(int id) {	
		return addressDao.findById(id).get();
	}

	@Override
	public void delete(Address address) {		
		addressDao.delete(address);
	}

	@Override
	public Address findAddressById(String username, int id) {
		return addressDao.findAddressById(username, id);
	}

	@Override
	public AddressModel getOneAddressById(int id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
		Address address = addressDao.findAddressById(username, id);
		
		AddressModel addressModel = new AddressModel();
		
		addressModel.setFullName(address.getFullname());
		addressModel.setPhone(address.getPhone());
		addressModel.setDetail(address.getDetail());
		
//		addressModel.setProvince(address.getProvince());
//		addressModel.setDistrict(address.getDistrict());
//		addressModel.setWard(address.getWard());
		
		return addressModel;
	}

	
	@Override
	public AddressModel updateAddress(AddressModel addressModel, Integer id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		
//		ProvinceDao list = rest.getForObject(url, ProvinceDao.class);	
//		Province province = list.get(Integer.parseInt(addressModel.getProvince()));
//		District district = province.getDistricts().get(Integer.parseInt(addressModel.getDistrict()));
//		Ward ward = district.getWards().get(Integer.parseInt(addressModel.getWard()));
		User temp = userDao.findUserByEmail(username);
		Address address = addressDao.findAddressById(username, id);
		
		address.setFullname(addressModel.getFullName());
		address.setPhone(addressModel.getPhone());
		address.setDetail(addressModel.getDetail());
//		address.setProvince(province.getName());
//		address.setDistrict(district.getName());
//		address.setWard(ward.getName());
		address.setUser(temp);
		addressDao.save(address);
		
		return addressModel;
	}


}
