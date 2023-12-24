package datn.web.service;

import java.util.List;

import datn.web.entity.Discount;
import datn.web.entity.User;
import datn.web.model.DiscountModel;
import datn.web.model.InformationModel;

public interface DiscountService {

	DiscountModel createDiscount(DiscountModel discountModel);

	List<Discount> findAll();

	DiscountModel getOneDiscountById(Integer id);

	void delete(Integer id);

	DiscountModel updateDiscount(DiscountModel discountModel);

	Discount getDiscountByCode(String code);

	void updateQuality(Discount discount);

	List<Discount> getListDiscountAvailable();

	User sendCodeDiscount(Integer discountId, User user);

}
