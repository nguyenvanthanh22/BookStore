package datn.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import datn.web.entity.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer>{
	@Query("SELECT m FROM Manufacturer m WHERE m.Deleteday = null")
	List<Manufacturer> getListManufacturer();
}
