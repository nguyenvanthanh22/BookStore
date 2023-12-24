package datn.web.service;

import java.util.List;

import datn.web.entity.Address;
import datn.web.model.AddressModel;

public interface AddressService {	
	List<Address> findListAddressByEmail(String username);
	
	AddressModel createAddress(AddressModel addressModel);
	Address getAddressById(int parseInt);
	void delete(Address address);
	Address findAddressById(String username, int id);
	AddressModel getOneAddressById(int id);
	
	AddressModel updateAddress(AddressModel addressModel, Integer id);
}
