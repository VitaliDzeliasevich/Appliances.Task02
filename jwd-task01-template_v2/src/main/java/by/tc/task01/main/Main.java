package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Appliance> appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

//		Appliance oven = new Laptop(100,"Linux",100,100,100,100); // ADDING INFO TO XML
//
//		service.add(oven);

		////////////////////////////////////

		Criteria criteria = new Criteria(); //SEARCHING IN ALL GROUPS BY CRITERIA
		criteria.add(SearchCriteria.Appliance.POWER_CONSUMPTION.toString(), 100);

		appliance = service.find(criteria);

		PrintApplianceInfo.print(appliance);
		System.out.println("////////////1");
		///////////////////////////////////

		criteria = new Criteria(Oven.class.getSimpleName()); // SEARCHING IN DEFINITE GROUP BY CRITERIA
		criteria.add(SearchCriteria.Oven.CAPACITY.toString(), 33);
		criteria.add(SearchCriteria.Oven.DEPTH.toString(), 60);

		appliance = service.find(criteria);

		PrintApplianceInfo.print(appliance);
		System.out.println("////////////");

		////////////////////////////////

		criteria = new Criteria(Laptop.class.getSimpleName()); // SEARCHING ONLY BY GROUP (WITHOUT CRITERIA)

		appliance = service.find(criteria);

		PrintApplianceInfo.print(appliance);
		System.out.println("////////////");

		///////////////////////////////
//
//		criteria = new Criteria(Refrigerator.class.getSimpleName());
//		criteria.add(Refrigerator.HEIGHT.toString(), 200);
//		criteria.add(Refrigerator.WIDTH.toString(), 70);
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		/////////////////////////////
//
//		criteria = new Criteria(Speakers.class.getSimpleName());
//		criteria.add(Speakers.NUMBER_OF_SPEAKERS.toString(), 2);
//		criteria.add(Speakers.CORD_LENGTH.toString(), 2);
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		////////////////////////////////////////////////////////////////// 6666666
//
//
//		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
//		criteriaTabletPC.add(TabletPC.COLOR.toString(), "red");
//		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 15);
//		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);
//
//		appliance = service.find(criteriaTabletPC);// find(Object...obj)
//
//		PrintApplianceInfo.print(appliance);
//		System.out.println("////////////");
//
//		////////////////////////////////////////////////////////////////// 7777777
//
//		criteria = new Criteria(VacuumCleaner.class.getSimpleName());
//		criteria.add(VacuumCleaner.FILTER_TYPE.toString(), "d");
//		criteria.add(VacuumCleaner.WAND_TYPE.toString(), "all-in-one");
//
//		appliance = service.find(criteria);
//
//		PrintApplianceInfo.print(appliance);
	}

}
