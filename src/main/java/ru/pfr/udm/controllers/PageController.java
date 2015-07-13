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
import org.springframework.web.servlet.ModelAndView;

import ru.pfr.udm.services.MfcDataService;
import ru.pfr.udm.services.MfcServiceService;
import ru.pfr.udm.services.UserService;
import ru.udm.pfr.models.DataWrapper;
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
	private static final String ERROR_VIEW = "sended";
	@Autowired
	MfcServiceService mfcService;
	@Autowired
	MfcDataService mfcDataService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/valuesOfMfc", method = RequestMethod.GET)
	public ModelAndView showMfcInput() {
		ArrayList<MfcService> mfcServices = (ArrayList<MfcService>) mfcService
				.getServiceList();
		// TODO переделать
		User user = new User();
		user.setName("pd199717");
		Mfc district = userService.getDistrict(user).get(0);
		for (MfcService mfcService : mfcServices) {
			mfcService.setMfcData(mfcDataService.getOldValues(district.getId(),
					mfcService.getId()));
		}

		DataWrapper wrapper = new DataWrapper();
		wrapper.setUser(user);
		wrapper.setMfc(district);
		wrapper.setServices(mfcServices);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(VALUES_VIEW);
		modelAndView.addObject("wrapper", wrapper);
		return modelAndView;
	}

	@RequestMapping(value = "/valuesOfMfc", method = RequestMethod.POST)
	public String showResult(@ModelAttribute("wrapper") DataWrapper wrapper,
			Model model) {

		if (wrapper.getServices() == null || wrapper.getServices().isEmpty()) {
			log.error("services is null");
			return ERROR_VIEW;
		}
		for (MfcService mfcService : wrapper.getServices()) {
			log.info(mfcService.getId());
			String title = this.mfcService.getByid(mfcService.getId())
					.getTitle();
			mfcService.setTitle(title);
			log.info("Наименование услуги: {}", mfcService.getTitle());
			if (mfcService.getMfcData() != null
					&& mfcService.getMfcData().getField2() != null)
				log.info("field2:{}", mfcService.getMfcData().getField2());
			if (mfcService.getMfcData() != null
					&& mfcService.getMfcData().getField2() != null)
				log.info("field3:{}", mfcService.getMfcData().getField3());

		}
		model.addAttribute("wrapper", wrapper);
		return RESULT_VIEW;
	}

}
