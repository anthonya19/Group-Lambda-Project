package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Client;
import model.Driver;
import model.FeedBack;
import model.Owner;

public class DeliveryDAOImpl implements DeliveryDAO {

	List<Client> clients;
	List<Driver> drivers;
	List<Owner> owners;
	List<FeedBack> feedBacks;
	public DeliveryDAOImpl() {
		super();
		feedBacks=new ArrayList<FeedBack>();
		clients=new ArrayList<Client>();
		drivers=new ArrayList<Driver>();
		owners=new ArrayList<Owner>();
		
	}

	

	public Client createClientProfile(Map<String, String> clientInfo) {
		System.out.println("createClientProfile");
		return null;
	};

	public Driver createDriverProfile(Map<String, String> driverInfo) {
		System.out.println("createDriverProfile");
		return null;
	};

	public Owner createOwnerProfile(Map<String, String> ownerInfo) {
		System.out.println("createOwnerProfile");
		return null;
	}

	@Override
	public void addfeedBack(FeedBack feedback) {
		// TODO Auto-generated method stub
		this.feedBacks.add(feedback);
	};

}
