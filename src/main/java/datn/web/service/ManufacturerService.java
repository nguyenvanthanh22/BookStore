package datn.web.service;

import java.util.List;

import datn.web.entity.Manufacturer;
import datn.web.model.ManufacturerModel;

public interface ManufacturerService{

	ManufacturerModel createManufacturer(ManufacturerModel manufacturerModel);

	List<Manufacturer> findAll();

	ManufacturerModel getOneManufacturerById(Integer id);

	void delete(Integer id);

	ManufacturerModel updateManufacturer(ManufacturerModel manufacturerModel);

}
