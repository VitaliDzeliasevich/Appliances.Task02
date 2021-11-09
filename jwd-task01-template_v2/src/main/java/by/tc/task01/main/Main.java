package by.tc.task01.main;


import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.exception.ServiceException;
import by.tc.task01.view.PrintApplianceInfo;

import java.util.List;

public class Main {

	public static void main(String[] args) throws ServiceException {

		List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

//		Appliance oven = new Oven(100,1001,100,100,100,100); // ADDING INFO TO XML
//		service.add(oven);

		/////////////////////////////

		Criteria criteria = new Criteria(); //SEARCHING IN ALL GROUPS BY CRITERIA
		criteria.add(SearchCriteria.Appliance.POWER_CONSUMPTION.toString(), 100);

		appliance = service.find(criteria);

		PrintApplianceInfo.print(appliance);
		System.out.println("////////////");
//		/////////////////////////////
//
//		criteria = new Criteria(SearchCriteria.Oven.class.getSimpleName()); // SEARCHING IN DEFINITE GROUP BY CRITERIA
//		criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
//		criteria.add(SearchCriteria.Oven.DEPTH.toString(), 60);
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");

		/////////////////////////////
//
//		criteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName()); // SEARCHING ONLY BY GROUP (WITHOUT CRITERIA)
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		/////////////////////////////
//
//		criteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
//		criteria.add(SearchCriteria.Refrigerator.HEIGHT.toString(), 200);
//		criteria.add(SearchCriteria.Refrigerator.WIDTH.toString(), 70);
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		/////////////////////////////
//
//		criteria = new Criteria(SearchCriteria.Speakers.class.getSimpleName());
//		criteria.add(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), 2);
//		criteria.add(SearchCriteria.Speakers.CORD_LENGTH.toString(), 2);
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		/////////////////////////////
//
//
//		Criteria criteriaTabletPC = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
//		criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "red");
//		criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 15);
//		criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 8000);
//
//		appliance = service.find(criteriaTabletPC);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		/////////////////////////////
//
//		criteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
//		criteria.add(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), "d");
//		criteria.add(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
	}

}
