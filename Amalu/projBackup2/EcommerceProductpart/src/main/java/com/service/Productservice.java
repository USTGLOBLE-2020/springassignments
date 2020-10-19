package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.Productentity;

public interface Productservice {



	public Productentity productcreate(Productentity pentity);

	public Optional<Productentity> getProductDetailsById(String id);

	public List<Productentity> getListOfproducts();

}
