package com.project.demo.Service;

import com.project.demo.model.HrDetails;

public interface HrDetailsService {
	
	
	HrDetails saveHrDetails(HrDetails hrDetails);
	HrDetails loginHrDetails(HrDetails hrDetails);
	HrDetails getHrDetailsById(long id,HrDetails hrDetails);
	HrDetails editHrDetailsById(long id,HrDetails hrDetails);

}
