package dao;

import java.util.Map;

import model.Client;
import model.Driver;
import model.FeedBack;
import model.Owner;

public interface DeliveryDAO {
	public Client createClientProfile(Map<String, String> clientInfo) ;

	public Driver createDriverProfile(Map<String, String> driverInfo) ;

	public Owner createOwnerProfile(Map<String, String> ownerInfo) ;
	public  void addfeedBack(FeedBack feedback);
}
