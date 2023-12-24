package datn.web.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import datn.web.entity.Order;
import datn.web.entity.Product;
import datn.web.model.BestSellerModel;
import datn.web.model.DetailOrder;
import datn.web.model.OrderModel;
import datn.web.model.StatisticalProductDay;
import datn.web.model.StatisticalRevenue;
import datn.web.model.StatisticalTotalOrder;

public interface OrderService {

	List<Order> getOrderByName(String code);

	void save(Order order);

	List<OrderModel> listOrderHistory();

	List<Order> listOrderByCodeAndUsername(String id);

	List<OrderModel> listOrderGroupByCode();

	DetailOrder getDetailOrderByCode(String id);

	void approveOrder(String id);

	void cancelOrder(String id);

	List<OrderModel> listOrderGroupByCodeShipping();

	void shippedOrder(String id);

	List<OrderModel> listOrderGroupByCodeSuccess();

	List<OrderModel> listOrderGroupByCodeCancel();

	void deleteOrder(String id);

	List<StatisticalProductDay> listStatisticalProductDay();
	
	List<StatisticalRevenue> listStatisticalRevenue(int month, int year);

	List<StatisticalRevenue> listStatisticalRevenueByMonth(int year);

	List<StatisticalRevenue> listStatisticalRevenueByYear(int year);

	StatisticalTotalOrder getStatisticalTotalOrderOnDay(int day, int month, int year);

	StatisticalTotalOrder getStatisticalTotalOrderOnMonth(int month, int year);

	StatisticalTotalOrder getStatisticalTotalOrderOnYear(int year);

	List<Integer> getListYearOrder();

	StatisticalTotalOrder getStatisticalTotalOrderOnOption(int day, int month, int year);

	List<BestSellerModel> getListBestSellerProduct(Pageable topFour);

	List<Product> listStatisticalProductWarehouse();

}
