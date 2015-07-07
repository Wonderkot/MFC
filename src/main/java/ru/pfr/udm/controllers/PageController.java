/**
 * 
 */
package ru.pfr.udm.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.pfr.udm.services.MfcDataService;
import ru.pfr.udm.services.MfcServiceService;
import ru.pfr.udm.services.UserService;
import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcService;
import ru.udm.pfr.models.User;

/**
 * @author pd199717
 *
 */
@Controller
public class PageController {
	private static Logger log = LogManager.getLogger(PageController.class);
	private static final String VALUES_VIEW = "mfc";
	private static final String RESULT_VIEW = "sended";
	@Autowired
	MfcServiceService mfcService;
	@Autowired
	MfcDataService mfcDataService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/valuesOfMfc", method = RequestMethod.GET)
	public String showMfcInput(Model model) {
		ArrayList<MfcService> mfcServices = (ArrayList<MfcService>) mfcService.getServiceList();

		// TODO переделать
		User user = new User();
		user.setName("pd199717");
		Mfc district = userService.getDistrict(user).get(0);
		for (MfcService mfcService : mfcServices) {
			mfcService.setMfcData(mfcDataService.getOldValues(district.getId(),
					mfcService.getId()));
		}
		model.addAttribute("services", mfcServices);

		return VALUES_VIEW;
	}

	@RequestMapping(value = "/valuesOfMfc", method = RequestMethod.POST)
	public String showResult(@ModelAttribute ArrayList<MfcService> services,
			Model model) {
		if (services == null || services.isEmpty()) {
			System.out.println("null");
		}
		for (MfcService mfcService : services) {
			System.out.println(mfcService.getTitle());
			System.out.println(mfcService.getMfcData().getField2());
		}
		model.addAttribute("services", services);
		return RESULT_VIEW;
	}

}
